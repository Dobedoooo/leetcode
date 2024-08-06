import java.util.ArrayList;
import java.util.List;

public class Solution2101 {
    /**
     * @author dobedoo
     */
    public int maximumDetonation(int[][] bombs) {
        int[] totalCount = new int[bombs.length];
        for(int k = 0; k < bombs.length; k++) {
            int[] count = new int[1];
            boolean[] banged = new boolean[bombs.length];
            bang(bombs, k, count, banged);
            totalCount[k] = count[0];
        }
        int maxCount = 0;
        for(int l = 0; l < bombs.length; l++) {
            if(maxCount < totalCount[l]) {
                maxCount = totalCount[l];
            }
        }
        return maxCount;
    }
    /**
     * @author dobedoo
     */
    private void bang(int[][] bombs, int bomb, int[] count, boolean[] banged) {
        int len = bombs.length;
        count[0] += 1;
        banged[bomb] = true;
        for(int j = 0; j < len; j++) {
            if(j == bomb) continue;
            double distance = Math.pow(bombs[j][0] - bombs[bomb][0], 2) + Math.pow(bombs[j][1] - bombs[bomb][1], 2);
            if(!banged[j] && Math.pow(bombs[bomb][2], 2) >= distance) {
                bang(bombs, j, count, banged);
            }
        }
    }

    /**
     * @author leetcode
     */
    public int maxDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer[]>[] graph = new ArrayList[n];
        return 0;
    }

    public static void main(String[] args) {
        int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } };
//        System.out.println(new Solution2101().maximumDetonation(bombs));
        System.out.println(new Solution2101().maximumDetonation(bombs));
    }
}
