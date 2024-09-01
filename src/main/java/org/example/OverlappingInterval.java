package org.example;

import java.util.Scanner;

class Interval {
    int left;
    int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public boolean overlapsWith(Interval other) {
        return (this.left <= other.right && this.left >= other.left) ||
                (this.right <= other.right && this.right >= other.left) ||
                (other.left <= this.right && other.left >= this.left) ||
                (other.right <= this.right && other.right >= this.left);
    }
}

public class OverlappingInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L1 = sc.nextInt();
        int R1 = sc.nextInt();
        int L2 = sc.nextInt();
        int R2 = sc.nextInt();

        Interval Interval1 = new Interval(L1, R1);
        Interval Interval2 = new Interval(L2, R2);

        if (Interval1.overlapsWith(Interval2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
