public class Solution2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int need = 0;
        for(int i: batteryPercentages) {
            if(i > need) need += 1;
        }
        return need;
    }

    public static void main(String[] args) {
        int[] batteryPercentages = { 0, 1, 2 };
        System.out.println(new Solution2960().countTestedDevices(batteryPercentages));
    }
}
