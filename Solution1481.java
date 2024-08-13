import java.util.*;
import java.util.stream.Collectors;

public class Solution1481 {
    private int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 记录每个数字出现的次数
        Map<Integer, Integer> numsCountMap = new HashMap<>();
        for(int n: arr) numsCountMap.put(n, numsCountMap.getOrDefault(n, 0) + 1);
        // 按值从小到大排序
        Integer[] numCountValue = numsCountMap.values().toArray(new Integer[0]);
        Arrays.sort(numCountValue);
        // 贪心：从最少的数开始移除
        int leastNum = numCountValue.length;
        for(int i = 0; i < numCountValue.length; i++) {
            if(numCountValue[i] > k) break;
            k -= numCountValue[i];
            leastNum -= 1;
        }
        return leastNum;
    }
    private int findLeastNumOfUniqueInts2(int[] arr, int k) {
        // 计数 计数排序缺点：不适合对大数字进行排序，不适合该题
        int maxValue = maxValue(arr);
        int[] count = new int[maxValue + 1];
        for(int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }
        // 将各个数的出现次数从大到小排序
        Arrays.sort(count);

        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0) continue;
            if(count[i] > k) break;
            k -= count[i];
            count[i] = 0;
        }
        int leastNum = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 0) continue;
            leastNum += 1;
        }
        return leastNum;
    }
    private static int maxValue(int[] array) {
        int max = 0;
        for (int j : array) max = Math.max(max, j);
        return max;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int k = 3;
        System.out.println(new Solution1481().findLeastNumOfUniqueInts(arr, k));
//        System.out.println(new Solution1481().findLeastNumOfUniqueInts2(arr, k));
    }
}
