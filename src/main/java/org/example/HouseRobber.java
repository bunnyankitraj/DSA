package org.example;

import java.util.ArrayList;
import java.util.List;


public class HouseRobber {


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        int sum = 0;
//        int maxSum = 0;
        int[] maxSum = {0};  // Use an array to pass the sum by reference

        List<Boolean> visit = new ArrayList<>();

        // Initialize the visit list
        for (int i = 0; i < arr.length; i++) {
            visit.add(false);
        }

        helperFunc(arr, 0, arr.length, sum, visit, maxSum);
        System.out.println(sum);
        System.out.println(maxSum);
    }

    //    private static void helperFunc(int[] arr, int i, int n, int currentSum, List<Boolean> visit, int maxSum) {
    private static void helperFunc(int[] arr, int i, int n, int currentSum, List<Boolean> visit, int[] maxSum) {
        if (i == n) {

//            if (currentSum > maxSum) {
//                maxSum = currentSum;
//            }

            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
            }

            return;

        }

        // Option to include the current house
        if (i == 0 || !visit.get(i - 1)) {  // Check previous house is not visited
            visit.set(i, true);
            helperFunc(arr, i + 1, n, currentSum + arr[i], visit, maxSum);
            visit.set(i, false);  // Backtrack
        }

        // Option to exclude the current house
        helperFunc(arr, i + 1, n, currentSum, visit, maxSum);
    }
}

/*
public class HouseRobber {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};
        int[] maxSum = {0};  // Use an array to pass the sum by reference
        List<Boolean> visit = new ArrayList<>();

        // Initialize the visit list
        for (int i = 0; i < arr.length; i++) {
            visit.add(false);
        }

        helperFunc(arr, 0, arr.length, 0, visit, maxSum);
        System.out.println(maxSum[0]);
    }

    private static void helperFunc(int[] arr, int i, int n, int currentSum, List<Boolean> visit, int[] maxSum) {
        if (i >= n) {
            // Update maxSum if currentSum is greater
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
            }
            return;
        }

        // Option to include the current house
        if (i == 0 || !visit.get(i - 1)) {  // Check previous house is not visited
            visit.set(i, true);
            helperFunc(arr, i + 1, n, currentSum + arr[i], visit, maxSum);
            visit.set(i, false);  // Backtrack
        }

        // Option to exclude the current house
        helperFunc(arr, i + 1, n, currentSum, visit, maxSum);
    }
}
*/
