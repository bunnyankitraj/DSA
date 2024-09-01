package org.example;

public class MaxBuildingHeight {

    public static int maxBuildingHeightSum(int[] maxHeight) {
        int n = maxHeight.length;

        // Step 1: Create an array to store the final heights of buildings
        int[] height = new int[n];

        // Step 2: Forward pass to ensure no dips from left to right
        height[0] = maxHeight[0];
        for (int i = 1; i < n; i++) {
            height[i] = Math.min(maxHeight[i], height[i-1] + 1);
        }

        // Step 3: Backward pass to ensure no dips from right to left
        for (int i = n - 2; i >= 0; i--) {
            height[i] = Math.min(height[i], height[i+1] + 1);
        }

        // Step 4: Calculate the sum of the final heights
        int totalHeight = 0;
        for (int i = 0; i < n; i++) {
            totalHeight += height[i];
        }

        return totalHeight;
    }

    public static void main(String[] args) {
        int[] maxHeights1 = {5, 10, 5, 10, 5};
        int[] maxHeights2 = {1, 2, 3, 4, 5};
        System.out.println("Maximum possible sum of heights: " + maxBuildingHeightSum(maxHeights1));  // Expected Output: 27
        System.out.println("Maximum possible sum of heights: " + maxBuildingHeightSum(maxHeights2));  // Expected Output: 15
    }
}
