package Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    //    using sorting O(nlogn) and space O(1)
    static String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        int end = Math.min(strs[0].length(), strs[strs.length - 1].length());
        int i = 0;
        while (i < end && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
            i++;
        }
        return strs[0].substring(0, i);
    }


    //    time O(N2) and space O(1)
    static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        String c = strs[0];
        for (int i = 0; i < c.length(); i++) {
            char a = c.charAt(i);
            for (String s : strs) {
                if (i >= s.length()) {
                    return ans.toString();
                }
                if (s.charAt(i) != a) {
                    return ans.toString();
                }
            }
            ans.append(a);
        }
        return ans.toString();
    }
}
