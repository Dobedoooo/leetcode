import java.util.Arrays;

public class Solution3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApple = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int boxNum = 0;
        for(int i = capacity.length - 1; i >= 0; i--) {
            if(totalApple >= capacity[i]) {
                boxNum += 1;
                totalApple -= capacity[i];
            }
        }
        return boxNum;
    }

    public static void main(String[] args) {
        int[] apple = { 1, 3, 2 };
        int[] capacity = { 4, 3, 1, 5, 2 };
        System.out.println(new Solution3074().minimumBoxes(apple, capacity));
    }
}
