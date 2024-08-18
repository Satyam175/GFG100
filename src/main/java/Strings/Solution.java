package Strings;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(lcs("tyfg", "dsfty"));
    }

    public static int lcs(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(s, s.length() - 1, t, t.length() - 1, dp);
    }

    public static int rec(String s, int i1, String t, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0) return 0;

        if (dp[i1][i2] != -1) return dp[i1][i2];

        if (s.charAt(i1) == t.charAt(i2)) {
            // If characters match, recursively check for LCSu without reset
            return dp[i1][i2] = 1 + rec(s, i1 - 1, t, i2 - 1, dp);
        } else {
            // If characters don't match, the length of common substring is zero
            // Reset to zero and recursively check for LCSu
            return rec(s, i1 - 1, t, i2 - 1, dp);
        }
    }
}

