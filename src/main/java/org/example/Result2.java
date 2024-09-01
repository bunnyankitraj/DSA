package org.example;

public class Result2 {

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

    public static int maxBuildingHeightSum2(int[] maxHeight) {
        int n = maxHeight.length;
        if (n == 0) return 0;
        if (n == 1) return maxHeight[0];
        if (n == 2) return maxHeight[0] + maxHeight[1];

        int[] height = new int[n];

        // Set the height of the first building to its maximum possible height.
        height[0] = maxHeight[0];

        // Iterate from the second building to the end.
        for (int i = 1; i < n; i++) {
            // The height of the current building should be no more than the previous building's height + 1.
            height[i] = Math.min(maxHeight[i], height[i-1] + 1);
        }

        // Iterate backwards to ensure there are no dips
        for (int i = n - 2; i >= 0; i--) {
            // The height of the current building should be no more than the next building's height + 1.
            height[i] = Math.min(height[i], height[i+1] + 1);
        }

        // Calculate the sum of the heights
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += height[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] maxHeights = {4,8,6,7};
        int[] maxHeights2 = {1,2,3,4,5};
        int[] maxHeights3 = {5, 10, 5, 10, 5};
        System.out.println("Maximum possible sum of heights: " + maxBuildingHeightSum(maxHeights3));
        System.out.println("Maximum possible sum of heights: " + maxBuildingHeightSum2(maxHeights3));

    }
}
