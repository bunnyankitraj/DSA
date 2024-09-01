package org.example;

public class TargetSum494 {

    private static void backTrack(int[] nums, int i, int target, int currSum, int[] ans) {
        if (target == currSum) {
            ans[0]++;
            return;
        }
        if (i == nums.length) {
            return;
        }
        backTrack(nums, i + 1, target, currSum + nums[i], ans);
        backTrack(nums, i + 1, target, currSum - nums[i], ans);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int[] ans = {0};
        int target = 3;
        backTrack(nums, 0, target, 0, ans);
        System.out.println(ans[0]);
    }

}
