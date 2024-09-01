package org.example;

import java.util.Arrays;

public class EditDistance {
    public  static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return backTrack(word1,0,m,word2,0,n,dp);
    }

    private static int backTrack(String word1,int i,int m, String word2,int j,int n,int[][] dp){
        if(i==m || j==n) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int len = 999999;
        int del = 999999;
        int insert=999999;
        int rep=999999;
        if(word1.charAt(i)==word2.charAt(j)){
            len = backTrack(word1,i+1,m,word2,j+1,n,dp);
        }
        else{
            del = 1+backTrack(word1,i+1,m,word2,j+1,n,dp);
            insert = 1+backTrack(word1,i+1,m,word2,j+1,n,dp);
            rep = 1+backTrack(word1,i+1,m,word2,j+1,n,dp);
            del = Math.min(del,Math.min(insert,rep));
        }
        return Math.min(len,del);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("abc","xyz"));
    }
}
