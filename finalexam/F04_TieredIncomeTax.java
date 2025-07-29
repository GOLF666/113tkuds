package finalexam;

import java.util.*;

public class F04_TieredIncomeTax {
    static double[] rates    = {0.05, 0.12, 0.20, 0.30, 0.40};
    static int[]    limits   = {540000, 1210000, 2420000, 4530000}; 

    static long calcTax(long income) {
        long tax = 0;
        long prevLimit = 0;
        for (int i = 0; i < rates.length; i++) {
            long upper = (i < limits.length ? limits[i] : Long.MAX_VALUE);
            if (income <= prevLimit) break;
            long taxable = Math.min(income, upper) - prevLimit;
            tax += Math.round(taxable * rates[i]);
            prevLimit = upper;
        }
        return tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long inc = sc.nextLong();
            long t   = calcTax(inc);
            System.out.println("Tax: $" + t);
            sum += t;
        }
        System.out.println("Average: $" + (sum + n/2) / n);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：走訪每筆年收入，對固定級距線性計算稅額
 */
