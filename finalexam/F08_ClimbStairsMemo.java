package finalexam;

import java.util.*;

public class F08_ClimbStairsMemo {
    static long[] memo;

    static long ways(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] != -1) return memo[n];
        long w = ways(n-1) + ways(n-2) + ways(n-3);
        memo[n] = w;
        return w;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new long[n+1];
        Arrays.fill(memo, -1);
        System.out.println("Ways: " + ways(n));
    }
}
