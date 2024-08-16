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

    public int maximumUnitsOptm(int[][] boxTypes, int truckSize) {
        // 由于 boxTypes.length <= 1000，使用计数排序优化排序速度
        int[] type = new int[1001];
        for(int[] boxType: boxTypes) type[boxType[1]] += boxType[0];
        int maxUnits = 0;
        for(int i = type.length - 1; i >= 0; i--) {
            if(type[i] == 0) continue;
            if(truckSize >= type[i]) {
                maxUnits += i * type[i];
                truckSize -= type[i];
            } else {
                maxUnits += truckSize * i;
                return maxUnits;
            }
        }
        return maxUnits;
    }

    public static void main(String[] args) {
        int[][] boxTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
        int trackSize = 4;
        System.out.println(new Solution1710().maximumUnitsOptm(boxTypes, trackSize));
    }
}
