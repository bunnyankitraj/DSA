package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TemperatureVinay {

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

    public static void main(String[] args) {
/*
        Input: arr[] = [1 3 2 4], n = 4
        Output: 3 4 4 -1
*/
        int[] temp =
//                {30,40,50,60}
                {30,60,90}
//                {73,74,75,71,69,72,76,73}
                ;
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(nextGreat(temp)));

        System.out.println(Arrays.toString(dailyTemperatures(temp)));
        System.out.println(Arrays.toString(dailyTemperaturesChat(temp)));
    }

    private static int[] dailyTemperatures(int[] temp) {
        int[] nextGrt = nextGreat(temp);
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


    public static int[] dailyTemperaturesChat(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temp[i] > temp[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i - idx;
            }
            st.push(i);
        }

        return ans;
    }

}
