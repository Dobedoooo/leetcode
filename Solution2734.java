import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution2734 {
    public static void main(String[] args) {
        String str = "aa";
        String smallestStr = new Solution2734().smallestString(str);
        System.out.println(smallestStr);
    }

    public String smallestString(String s) {
        int begin = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            if('a' != s.charAt(i)) {
                begin = i;
                break;
            }
        }
        for(int j = begin + 1; j < s.length(); j++) {
            if('a' == s.charAt(j)) {
                end = j - 1;
                break;
            }
        }
        if(0 == end) {
            end = s.length() - 1;
        }
        char[] sub = s.substring(begin, end + 1).toCharArray();
        StringBuilder smallSub = new StringBuilder();
        for(int k = 0; k < sub.length; k++) {
            char subChar = (char)(sub[k] - 1);
            smallSub.append(subChar);
        }
        return s.replaceFirst(new String(sub), smallSub.toString());
    }
}
