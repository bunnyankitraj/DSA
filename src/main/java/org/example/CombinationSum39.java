package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum39 {

    public static List<List<Integer>> combinationSum(int[] c, int t) {
        int n = c.length;

        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(c[i], 1);
        }

        for (int i = 0; i < n; i++) {
            int x = t % c[i];
            if (x == 0) {
                List<Integer> ans1 = new ArrayList<>();
                for (int j = 0; j < t / c[i]; j++) {
                    ans1.add(c[i]);
                }
                ans.add(ans1);
            } else if (map.get(x) != null) {
                List<Integer> ans2 = new ArrayList<>();
                for (int j = 0; j < t / c[i]; j++) {
                    ans2.add(c[i]);
                }
                ans2.add(x);
                ans.add(ans2);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] num = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> finalAns = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        dp(0, num, target, curr, finalAns);

        for (List<Integer> ans : finalAns) {
            System.out.println(ans);
        }
    }

    private static void dp(int index, int[] num, int target, List<Integer> curr, List<List<Integer>> finalAns) {
        if (target == 0) {
            finalAns.add(new ArrayList<>(curr));
            return;
        }
        if (index == num.length || target < 0) {
            return;
        }


        if (num[index] <= target) {
            curr.add(num[index]);
            dp(index, num, target - num[index], curr, finalAns);
            curr.remove(curr.size() - 1);
        }
        dp(index + 1, num, target, curr, finalAns);
    }


    private static int[] canBeCombinationSum(int n1, int n2, int tar) {
        // Loop through possible multiples of n1
        for (int i = 0; i <= tar / n1; i++) {
            // Loop through possible multiples of n2
            for (int j = 0; j <= tar / n2; j++) {
                // Check if the combination of i*n1 and j*n2 equals the target
                if (i * n1 + j * n2 == tar) {
                    // Return the array with the counts of n1, n2, and total
                    return new int[]{i, j, i + j};
                }
            }
        }
        // Return null if no valid combination is found
        return null;
    }


}
