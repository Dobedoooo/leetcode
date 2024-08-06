import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        int[] orderedCosts = countingSort(costs);
        for(int item: orderedCosts) {
            if(coins > 0) {
                coins -= item;
            }
        }
        return 0;
    }

    /**
     * 计数排序
     * @param array 待排序数组
     * @return 有序数组
     */
    private int[] countingSort(int[] array) {
        // 找出最大值
        int maxValue = 0;
        for(int item: array) maxValue = Math.max(maxValue, item);

        // 计数
        int[] count = new int[maxValue + 1];
        for(int item: array) {
            count[item] += 1;
        }
        // 排序
        int index = 0;
        int[] result = new int[maxValue + 1];
        for(int i = 0; i < maxValue + 1; i++) {
            while(count[i] > 0) {
                result[index] = i;
                count[i] -= 1;
                index += 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] costs = { 1, 3, 2, 4, 0 };
        int coins = 7;
//        System.out.println(new Solution1833().maxIceCream(costs, coins));
    }

}
