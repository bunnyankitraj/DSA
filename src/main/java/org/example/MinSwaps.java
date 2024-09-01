package org.example;

public class MinSwaps {

    public static int minSwaps(int[] array) {
        int n = array.length;

        // Create an array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on the values of the array using selection sort
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[indices[j]] < array[indices[minIdx]]) {
                    minIdx = j;
                }
            }
            // Swap indices
            int temp = indices[i];
            indices[i] = indices[minIdx];
            indices[minIdx] = temp;
        }

        // To keep track of visited elements
        boolean[] visited = new boolean[n];

        int swapCount = 0;
        for (int i = 0; i < n; i++) {
            // If the element is already visited or in the correct position
            if (visited[i] || indices[i] == i) {
                continue;
            }

            // Calculate the size of the cycle
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indices[j];
                cycleSize++;
            }

            // If there is a cycle of size > 1, add (cycleSize - 1) to the swap count
            if (cycleSize > 1) {
                swapCount += (cycleSize - 1);
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3};
        System.out.println(minSwaps(arr)); // Expected output: 2
    }
}
