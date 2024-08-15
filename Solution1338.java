import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1338 {
    public int minSetSize(int[] arr) {
        int halfLen = arr.length / 2;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i: arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        Integer[] valueArr = countMap.values().toArray(new Integer[0]);
        Arrays.sort(valueArr);
        int minSetSize = 0;
        int removed = 0;
        for(int i = valueArr.length - 1; i >= 0; i--) {
            minSetSize += 1;
            removed += valueArr[i];
            if(removed >= halfLen) break;
        }
        return minSetSize;
    }
    public static void main(String[] args) {
        int[] arr = { 7, 7, 7, 7, 7 };
        System.out.println(new Solution1338().minSetSize(arr));
    }
}
