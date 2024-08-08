import java.util.Arrays;

public class Solution2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] remain = new int[n];
        for(int i = 0; i < n; i++) {
            remain[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remain);
        int bagNum = 0;
        for(int i = 0; i < n; i++) {
            if(remain[i] == 0) {
                bagNum += 1;
            } else if(additionalRocks >= remain[i]) {
                additionalRocks -= remain[i];
                bagNum += 1;
            }
        }
        return bagNum;
    }

    public static void main(String[] args) {
        int[] capacity = { 10, 2, 2 };
        int[] rocks = { 2, 2, 0 };
        int additionalRocks = 100;
        System.out.println(new Solution2279().maximumBags(capacity, rocks, additionalRocks));
    }
}
