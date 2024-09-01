package org.example;

public class SubArraySum1524 {

//    private static void backTrack(int[] arr, int i, int sum, int[] ans) {
//        if (i >= arr.length) {
//            if (sum % 2 != 0) {
//                ans[0]++;
//            }
//            return;
//        }
//
//        // if(sum%2!=0){
//        //     ans[0]++;
//        // }
//        backTrack(arr, i + 1, sum + arr[i], ans);
//        backTrack(arr, i + 1, sum, ans);
//    }
//
//    public static int numOfSubarrays(int[] arr) {
//        int[] ans = new int[1];
//        backTrack(arr, 0, 0, ans);
//        return ans[0];
//    }

    public static void main(String[] args) {
//        int[] arr =  {1,2,4,5};
//        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.activeCount());
//        System.out.println(numOfSubarrays(arr));
    }
}
