import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Solution2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> good = new ArrayList<>();
        for(int i = 0; i < variables.length; i++) {
            BigDecimal r1 =  new BigDecimal(variables[i][0]).pow(variables[i][1]);
            BigDecimal r2 = r1.remainder(BigDecimal.valueOf(10));
            BigDecimal r3 = r2.pow(variables[i][2]);
            BigDecimal r4 = r3.remainder(BigDecimal.valueOf(variables[i][3]));
            if(r4.compareTo(BigDecimal.valueOf(target)) == 0) {
                good.add(i);
            }
        }
        return good;
    }

//    private int pow(int x, int n) {
//        if(n % 2 != 0) {
//
//        }
//    }

    public static void main(String[] args) {
        int[][] variables = { { 31, 12, 21, 24 } };
        int target = 1;
        System.out.println(new Solution2961().getGoodIndices(variables, target));
//        System.out.println(2 << 2);
    }
}
