
import java.util.Arrays;

public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        int minNum = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while(light <= heavy) {
            if(people[light] + people[heavy] <= limit) {
                light += 1;
            }
            heavy -= 1;
            minNum += 1;
        }
        return minNum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution881().numRescueBoats(new int[] { 1, 2 }, 3));
    }

}
