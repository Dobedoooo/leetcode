import java.util.*;
import java.util.stream.Collectors;

public class Solution1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 记录每个数字出现的次数
        Map<Integer, Integer> numsCount = new HashMap<>();
        for(int n: arr) {
            if(numsCount.containsKey(n)) {
                numsCount.put(n, numsCount.get(n) + 1);
            } else {
                numsCount.put(n, 1);
            }
        }
        int num = numsCount.size();
        // 按值从小到大排序
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(numsCount.entrySet());
        entryList.sort(Comparator.comparingInt(Map.Entry::getValue));
        Map<Integer, Integer> linkedNumsCount = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry: entryList) {
            linkedNumsCount.put(entry.getKey(), entry.getValue());
        }
        // 贪心：从最少的数开始移除
        Iterator<Map.Entry<Integer, Integer>> iter = linkedNumsCount.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            if(entry.getValue() > k) break;
            k -= entry.getValue();
            num -= 1;
        }
        return num;
    }
    public static void main(String[] args) {
        int[] arr = { 4,3,1,1,3,3,2 };
        int k = 3;
        System.out.println(new Solution1481().findLeastNumOfUniqueInts(arr, k));
    }
}
