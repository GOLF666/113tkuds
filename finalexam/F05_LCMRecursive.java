package finalexam;

import java.util.*;

public class F05_LCMRecursive {
    static long gcd(long a, long b) {
        if (a == b) return a;
        if (a > b)  return gcd(a - b, b);
        else        return gcd(a, b - a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong();
        long g = gcd(a, b);
        long l = a / g * b; 
        System.out.println("LCM: " + l);
    }
}

/*
 * Time Complexity: O(max(a,b)/gcd) ≈ O(n)
 * 說明：每次減法遞迴一小段，最壞需線性次數遞迴
 */
