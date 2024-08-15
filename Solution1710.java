import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (i, j) -> j[1] - i[1]);
        int maxUnits = 0;
        for(int i = 0; i < boxTypes.length; i++) {
            if(truckSize - boxTypes[i][0] >= 0) {
                truckSize -= boxTypes[i][0];
                maxUnits += boxTypes[i][0] * boxTypes[i][1];
            } else {
                maxUnits += truckSize * boxTypes[i][1];
                return maxUnits;
            }
        }
        return maxUnits;
    }
    public static void main(String[] args) {
        int[][] boxTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
        int trackSize = 4;
        System.out.println(new Solution1710().maximumUnits(boxTypes, trackSize));
    }
}
