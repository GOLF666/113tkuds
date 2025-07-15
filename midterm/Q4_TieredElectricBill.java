package midterm;

import java.util.*;

public class Q4_TieredElectricBill {
    static int calc(int k) {
        double bill = 0;
        int rem = k;
        int[] limits = {120, 210, 170, 200, 300};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24};
        for (int i = 0; i < limits.length; i++) {
            int use = Math.min(rem, limits[i]);
            bill += use * rates[i];
            rem -= use;
            if (rem <= 0) break;
        }
        if (rem > 0) {
            bill += rem * 8.46;
        }
        return (int) Math.round(bill);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int kwh = sc.nextInt();
            int b = calc(kwh);
            System.out.println("Bill: $" + b);
            sum += b;
        }
        System.out.println("Total: $" + sum);
        System.out.println("Average: $" + (int) Math.round((double) sum / n));
    }
}

/*
 * Time Complexity: O(n)
 * 說明：對每筆資料呼叫固定階段計算函式，整體為線性
 */
