package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures739 {

    public static int[] nextGreat(int[] temp) {
        Stack<Integer> st = new Stack<>();
        int n = temp.length;
        int[] ans = new int[n];

        ans[n - 1] = -1;
        st.push(temp[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() < temp[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek();
            } else {
                ans[i] = -1;
            }
            st.push(temp[i]);

        }

        return ans;
    }

    public static int[] dailyTemperatures(int[] temp) {
        int[] nextGrt = nextGreat(temp);
        for (int i = 0; i < nextGrt.length; i++) {
            System.out.print(nextGrt[i] + " ");
        }
        System.out.println("DONE");
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int t : temp) {
            map.put(t, cnt++);
        }

        int ans[] = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            Integer x = map.get(nextGrt[i]);
            if (x == null) {
                ans[i] = 0;
            } else {
                ans[i] = map.get(nextGrt[i]) - i;
            }
        }
        return ans;
    }

//    public static int nthUglyNumber(int n) {
//        if (n == 1) return 0;
//        int k = 1;
//        int ans = 0;
//        for (int i = 1; k < n; i++) {
//            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
//                ans = i;
//                k++;
//            }
//        }
//        return ans;
//    }


    public  static int nthUglyNumber(int n) {
        if(n==1) return 1;
        int k = 1;
        int[] nums = new int[n+1];
        nums[0]=1;
        for(int i = 1;k<n;i++){
            if(i%2==0 || i%3==0 || i%5==0){
                nums[k]=i;
                k++;
            }
        }
        return nums[n-1];
    }

    public static void main(String[] args) {

        System.out.println(nthUglyNumber(11));


//        int[] temp = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
//        for (int i = 0; i < temp.length; i++) {
//            System.out.print(temp[i] + " ");
//        }
//        System.out.println("DONE");
//        int[] ans = dailyTemperatures(temp);
//        for (int i = 0; i < ans.length; i++) {
//            System.out.print(ans[i] + " ");
//        }
    }
}
