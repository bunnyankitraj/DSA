package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public static long getMaximumSumOfHeights(List<Integer> maxHeight) {
        int n = maxHeight.size();
        long[] leftToRight = new long[n];
        long[] rightToLeft = new long[n];

        // Calculate possible heights from left to right
        leftToRight[0] = maxHeight.get(0);
        for (int i = 1; i < n; i++) {
            leftToRight[i] = Math.min(maxHeight.get(i), leftToRight[i - 1]);
        }

        // Calculate possible heights from right to left
        rightToLeft[n - 1] = maxHeight.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            rightToLeft[i] = Math.min(maxHeight.get(i), rightToLeft[i + 1]);
        }

        // Calculate the maximum possible sum of heights
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += Math.min(leftToRight[i], rightToLeft[i]);
        }

        return maxSum;
    }

    public static long getMaximumSumOfHeights2(List<Integer> maxHeight) {
        int n = maxHeight.size();
        long[] heights = new long[n];

        // Forward pass
        heights[0] = maxHeight.get(0);
        for (int i = 1; i < n; i++) {
            heights[i] = Math.min(maxHeight.get(i), heights[i - 1] + 1);
        }

        // Backward pass
        heights[n - 1] = Math.min(maxHeight.get(n - 1), heights[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            heights[i] = Math.min(heights[i], heights[i + 1] + 1);
        }

        // Calculate the maximum possible sum of heights
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += heights[i];
        }

        return maxSum;
    }


    public static int maxBuildingHeightSum(int[] maxHeight) {
        int n = maxHeight.length;
        if (n == 0) return 0;
        if (n == 1) return maxHeight[0];
        if (n == 2) return maxHeight[0] + maxHeight[1];

        int[] dp = new int[n];

        // Base cases
        dp[0] = maxHeight[0];
        dp[1] = maxHeight[0] + maxHeight[1];

        // Fill dp array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + maxHeight[i]);
        }

        // The last element in dp array contains the maximum height sum
        return dp[n-1];
    }

    public static long getMaximumSumOfHeights1(List<Integer> maxHeight) {
        int n = maxHeight.size();
        long[] heights = new long[n];

        // Forward pass to set initial heights
        heights[0] = maxHeight.get(0);
        for (int i = 1; i < n; i++) {
            heights[i] = Math.min(maxHeight.get(i), heights[i - 1] + 1);
        }

        // Backward pass to adjust heights
        for (int i = n - 2; i >= 0; i--) {
            heights[i] = Math.min(heights[i], heights[i + 1] + 1);
        }

        // Calculate the maximum possible sum of heights
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += heights[i];
        }

        return maxSum;
    }

    public static long getMaximumSumOfHeights3(List<Integer> maxHeight) {
        int n = maxHeight.size();
        long[] heights = new long[n];

        // Forward pass to set initial heights
        heights[0] = maxHeight.get(0);
        for (int i = 1; i < n; i++) {
            heights[i] = Math.min(maxHeight.get(i), heights[i - 1] + 1);
        }

        // Backward pass to adjust heights
        for (int i = n - 2; i >= 0; i--) {
            heights[i] = Math.min(heights[i], heights[i + 1] + 1);
        }

        // Calculate the maximum possible sum of heights
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += heights[i];
        }

        return maxSum;
    }


    public static void main(String[] args) {
        List<Integer> maxHeight = new ArrayList<>();
//        maxHeight.add(4);
        maxHeight.add(4);
        maxHeight.add(8);
        maxHeight.add(6);
        maxHeight.add(7);

        List<Integer> maxHeight2 = new ArrayList<>();
//        maxHeight.add(5);
        maxHeight.add(1);
        maxHeight.add(2);
        maxHeight.add(3);
        maxHeight.add(4);
        maxHeight.add(5);

        long maxSum = getMaximumSumOfHeights(maxHeight);
//        int[] maxHeights = {4, 8, 6, 7};
        int[] maxHeights = {4,8,6,7};
        System.out.println("Maximum possible sum of heights: " + maxSum);
        System.out.println("Maximum : " + getMaximumSumOfHeights2(maxHeight));
        System.out.println("Maximum : " + getMaximumSumOfHeights1(maxHeight));
        System.out.println("Maximum : " + maxBuildingHeightSum(maxHeights));
        System.out.println("Maximum : " + getMaximumSumOfHeights3(maxHeight2));
    }
}
