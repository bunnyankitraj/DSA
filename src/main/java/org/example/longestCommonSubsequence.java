package org.example;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("aabc", "abc"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }


        return lcs(text1, 0, m, text2, 0, n, dp);
    }

    private static int lcs(String text1, int i, int m, String text2, int j, int n, int[][] dp) {
        if (i == m || j == n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + lcs(text1, i + 1, m, text2, j + 1, n, dp);
        } else {
            dp[i][j] = Math.max(lcs(text1, i + 1, m, text2, j, n, dp), lcs(text1, i, m, text2, j + 1, n, dp));
        }
        return dp[i][j];
    }
}