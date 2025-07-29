package finalexam;

import java.util.*;

public class F06_ArraySecondLargest {
    static class Pair {
        int max, second;
        Pair(int m, int s) { max = m; second = s; }
    }

    static Pair helper(int[] a, int i) {
        if (i == 0) {
            return new Pair(a[0], Integer.MIN_VALUE);
        }
        Pair p = helper(a, i - 1);
        int  v = a[i];
        if (v > p.max) {
            return new Pair(v, p.max);
        } else if (v > p.second) {
            return new Pair(p.max, v);
        } else {
            return p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Pair res = helper(a, n - 1);
        System.out.println("SecondMax: " + res.second);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：遞迴合併每次處理一元素，總共 n 次
 */
