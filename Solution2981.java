public class Solution2981 {
    public static String maximunLength(String s) {
        int ret = -1;
        int[] length = new int[s.length()];
        char el = ' ';
        int subLength = 1;
        int index = 0;
        /**
         * 1. 先找出最长特殊子字符串
         */
        for (int i = 0; i < s.length() - 1; i++) {
            el = s.charAt(i);
            if(el == s.charAt(i + 1)) {
                subLength += 1;
            }
        }

        StringBuilder sub = new StringBuilder(subLength);
        for(int k = 0; k < subLength; k++) sub.append(el);
        return sub.toString();
    }

    public static void main(String[] args) {
        String res = maximunLength("baabca");
        System.out.println("最长特殊子字符串为: " + res);
    }
}
