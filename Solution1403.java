import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        int remainSum = Arrays.stream(nums).sum();
        List<Integer> minSub = new ArrayList<>();
        Arrays.sort(nums);
        int listSum = 0;
        for(int i = nums.length - 1; i >=0; i--) {
            minSub.add(nums[i]);
            listSum += nums[i];
            if(listSum > remainSum - listSum) break;
        }
        return minSub;
    }
    public static void main(String[] args) {
        int[] nums = { 4, 4, 7, 6, 7 };
        System.out.println(new Solution1403().minSubsequence(nums));
    }
}
