import java.util.Arrays;

public class Solution3112 {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        for(int i = 0; i < edges.length; i++) {

        }
        return new int[]{ 1 };
    }

    /**
     * 迪杰斯特拉算法
     * @param weight 权重矩阵
     * @param start  起点
     * @return 从给定起点到其他点的最短路径
     */
    private int[] dijkstra(int[][] weight, int start) {
        boolean[] visited = new boolean[weight.length]; // 标记顶点是否被访问过
        int[] res = weight[start];                      // 记录 start 到各点的最短路径

        for(int i = 1; i < weight.length; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            for(int j = 0; j < weight.length; j++) {
                if(start != j && !visited[j] && res[j] < min) {
                    min = res[j];
                    p = j;
                }
            }
            visited[p] = true;

            for(int j = 0; j < weight.length; j++) {
                if(j == p || weight[p][j] == Integer.MAX_VALUE) continue;
                if(res[p] + weight[p][j] < res[j]) {
                    res[j] = res[p] + weight[p][j];
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
//        int n = 3;
//        int[][] edges = { { 0, 1, 2 }, { 1, 2, 1 }, { 0, 2, 4 } };
//        int[] disappear = { 1, 1, 5 };
//        System.out.println(new Solution3112().minimumTime(n, edges, disappear));
//        int MAX = Integer.MAX_VALUE;
//        int[][] weight = { {   0,   1,  12, MAX, MAX, MAX },
//                           { MAX,   0,   9,  3,  MAX, MAX },
//                           { MAX, MAX,   0, MAX,   5, MAX },
//                           { MAX, MAX,   4,   0,  13,  15 },
//                           { MAX, MAX, MAX, MAX,   0,   4 },
//                           { MAX, MAX, MAX, MAX, MAX,   0 } };
//        System.out.println(Arrays.toString(new Solution3112().dijkstra(weight, 0)));

    }
}
