package midterm;

import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.print("PrefixSum:");
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
            System.out.print(" " + sum);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：一次走訪陣列累加前 k 場勝場數
 */
