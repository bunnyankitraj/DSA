package org.example;

public class SudokuValidator {

    public static boolean isValidSudoku(int[][] grid, int[][] solution) {
        // Check that the solution matches the initial grid's non-zero values
        for (int i = 0; i < 9; i++) { // Loop through each row
            for (int j = 0; j < 9; j++) { // Loop through each column
                if (grid[i][j] != 0 && grid[i][j] != solution[i][j]) {
                    // If the original grid has a non-zero value, and it doesn't match the corresponding value in the solution grid, return false
                    return false;
                }
            }
        }

        // Check rows, columns, and sub-grids for validity and sum
        return checkRows(solution) && checkColumns(solution) && checkSubGrids(solution);
    }

    private static boolean checkRows(int[][] grid) {
        // Validate each row to ensure it contains all numbers from 1 to 9 without repetition and sums to 45
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[10]; // Array to track numbers 1-9 (index 0 is unused)
            int sum = 0; // Initialize sum for each row
            for (int j = 0; j < 9; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) {
                    // If the number is out of range or has already been seen in this row, return false
                    return false;
                }
                seen[num] = true; // Mark the number as seen
                sum += num; // Add the number to the sum
            }
            if (sum != 45) { // Check if the sum of the row is 45
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumns(int[][] grid) {
        // Validate each column to ensure it contains all numbers from 1 to 9 without repetition and sums to 45
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[10]; // Array to track numbers 1-9 (index 0 is unused)
            int sum = 0; // Initialize sum for each column
            for (int i = 0; i < 9; i++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) {
                    // If the number is out of range or has already been seen in this column, return false
                    return false;
                }
                seen[num] = true; // Mark the number as seen
                sum += num; // Add the number to the sum
            }
            if (sum != 45) { // Check if the sum of the column is 45
                return false;
            }
        }
        return true;
    }

    private static boolean checkSubGrids(int[][] grid) {
        // Validate each 3x3 sub-grid to ensure it contains all numbers from 1 to 9 without repetition and sums to 45
        for (int block = 0; block < 9; block++) {
            boolean[] seen = new boolean[10]; // Array to track numbers 1-9 (index 0 is unused)
            int sum = 0; // Initialize sum for each sub-grid
            for (int i = 0; i < 3; i++) { // Loop through rows within a block
                for (int j = 0; j < 3; j++) { // Loop through columns within a block
                    int row = (block / 3) * 3 + i; // Calculate the actual row index in the grid
                    int col = (block % 3) * 3 + j; // Calculate the actual column index in the grid
                    int num = grid[row][col];
                    if (num < 1 || num > 9 || seen[num]) {
                        // If the number is out of range or has already been seen in this sub-grid, return false
                        return false;
                    }
                    seen[num] = true; // Mark the number as seen
                    sum += num; // Add the number to the sum
                }
            }
            if (sum != 45) { // Check if the sum of the sub-grid is 45
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        int[][] solution = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
                { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
                { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
                { 2, 6, 3, 4, 1, 5, 9, 8, 7 },
                { 9, 7, 4, 8, 6, 3, 1, 2, 5 },
                { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
                { 1, 3, 8, 9, 4, 7, 2, 5, 6 },
                { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
                { 7, 4, 5, 2, 8, 6, 3, 1, 9 } };

        // Validate the solution and print the result
        System.out.println(isValidSudoku(grid, solution) ? "Valid solution" : "Invalid solution");
    }
}
