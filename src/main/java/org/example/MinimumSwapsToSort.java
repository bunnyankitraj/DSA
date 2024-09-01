package org.example;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.System.*;


class MinimumSwapsToSort extends PartyParity{
    public int minSwaps(int[] numbers) {
        int n = numbers.length;

        // Create a sorted copy of the array
        int[] sorted = Arrays.copyOf(numbers, n);
        Arrays.sort(sorted);

        // Map to store the positions of elements in the original array
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(numbers[i], i);
        }

        boolean[] visited = new boolean[n];
        int swapCount = 0;

        for (int i = 0; i < n; i++) {
            // If the element is already visited or already in the correct position, skip it
            if (visited[i] || sorted[i] == numbers[i]) {
                continue;
            }

            // Start a cycle detection
            int cycleSize = 0;
            int x = i;

            while (!visited[x]) {
                visited[x] = true;
                x = map.get(sorted[x]);
                cycleSize++;
            }

            // If there is a cycle of size n, we need (n - 1) swaps to sort it
            if (cycleSize > 0) {
                swapCount += (cycleSize - 1);
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
//        MinimumSwapsToSort sol = new MinimumSwapsToSort();
//        int[] numbers = {1,4,3,2};
        int[] numbers = {3,2,1,5,6,4};
        System.out.println(findKthLargest(numbers,2));  // Expected output should be the number of swaps to sort the array
        out.println(findKthLargestGPT(numbers,2));  // Expected output should be the number of swaps to sort the array

//        System.out.println(getFormattedDateStringFromEpochMilli(1721765324L,TimeZone.getTimeZone("UTC"),"dd MMM, HH:mm"));
//        System.out.println(getFormattedDateStringFromEpochSecond(1721765324384L,TimeZone.getTimeZone("America/Los_Angeles"),"dd MMM, HH:mm"));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : nums){
            pq.add(n);
        }

        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }

    public static int findKthLargestGPT(int[] nums, int k) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add elements to the heap
        for (int num : nums) {
            minHeap.add(num);
            // If the size of the heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }


    public static String getFormattedDateStringFromEpochMilli(long epochMilli, TimeZone timeZone, String pattern) {
        ZoneId zoneId = ZoneId.of(timeZone.getID());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), zoneId);

        // The pattern can be adjusted to the desired format.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return zonedDateTime.format(formatter);
    }

    public static String getFormattedDateStringFromEpochSecond(long epoch, TimeZone timeZone, String pattern) {
        ZoneId zoneId = ZoneId.of(timeZone.getID());
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochSecond(epoch), zoneId);

        // The pattern can be adjusted to the desired format.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return zonedDateTime.format(formatter);
    }

}
