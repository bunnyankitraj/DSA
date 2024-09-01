package org.example;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> ans = new HashMap<>();

        ans.put(target - nums[0], 0);
        for (int i = 1; i < n; i++) {
            if (ans.containsKey(nums[i])) {
                return new int[]{ans.get(nums[i]), i};
            }
            ans.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
//        int[] hlo = twoSum(new int[]{2, 7, 11, 15}, 9);

        int[] hlo = twoSum(new int[]{3, 3}, 6);
        if (hlo != null) {
//            for (int i = hlo.length - 1; i >= 0; i--) {
//                System.out.println(hlo[i]);
//            }
            for (int i = 0; i < hlo.length; i++) {
                System.out.println(hlo[i]);
            }
        } else {
            System.out.println("No solution found");
        }
    }
}
