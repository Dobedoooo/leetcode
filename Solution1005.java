import java.util.Arrays;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i = 0; i < k; i++) {
            nums[0] = -nums[0];

            int j = 0;
            while(j != nums.length - 1 && nums[j] > nums[j + 1]) {
                int tmp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tmp;
                j += 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { -2,5,0,2,-2 };
        int k = 3;
        System.out.println(new Solution1005().largestSumAfterKNegations(nums, k));
    }
}