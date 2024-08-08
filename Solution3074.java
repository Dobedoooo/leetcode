import java.util.Arrays;

public class Solution3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApple = 0;
        for(int i = 0; i < apple.length; i++) {
            totalApple += apple[i];
        }
        Arrays.sort(capacity);
        int boxNum = 0;
        for(int i = capacity.length - 1; i >= 0; i--) {
            boxNum += 1;
            totalApple -= capacity[i];
            if(totalApple <= 0) break;
        }
        return boxNum;
    }

    public static void main(String[] args) {
        int[] apple = { 1,8,6,8,9,3,3 };
        int[] capacity = { 10,6,8,7,3,6 };
        System.out.println(new Solution3074().minimumBoxes(apple, capacity));
    }
}
