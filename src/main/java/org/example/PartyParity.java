package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PartyParity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine().trim()); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(sc.nextLine().trim()); // Number of voters

            // Read voter IDs for party 1
            Set<String> party1 = new HashSet<>();
            String[] party1IDs = sc.nextLine().trim().split("\\s+");
            party1.addAll(Arrays.asList(party1IDs));

            // Read voter IDs for party 2
            Set<String> party2 = new HashSet<>();
            String[] party2IDs = sc.nextLine().trim().split("\\s+");
            party2.addAll(Arrays.asList(party2IDs));

            // Find the missing voter ID
            String missingVoterID = findMissingVoterID(party1, party2);
            System.out.println(missingVoterID);
        }

        sc.close();
    }

    private static String findMissingVoterID(Set<String> party1, Set<String> party2) {
        for (String id : party1) {
            if (!party2.contains(id)) {
                return id;
            }
        }
        return "Not found";
    }
}
