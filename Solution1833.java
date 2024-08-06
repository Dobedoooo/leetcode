import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        int[] orderedCosts = countingSort(costs);
        int iceCream = 0;
        for(int i = 0; i < orderedCosts.length; i++) {
            if(coins >= orderedCosts[i] && orderedCosts[i] != 0) {
                coins -= orderedCosts[i];
                iceCream += 1;
            }
        }
        return iceCream;
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
        int[] result = new int[array.length];
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
        int[] costs = { 6,2,8,8,5,6,6,2,2,2 };
        int coins = 77;
        System.out.println(new Solution1833().maxIceCream(costs, coins));
    }

}
