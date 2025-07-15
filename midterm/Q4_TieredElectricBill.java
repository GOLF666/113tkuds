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
        int[] usages = new int[n];
        for (int i = 0; i < n; i++) {
            usages[i] = sc.nextInt();
        }
        int total = 0;
        for (int kwh : usages) {
            int cost = calc(kwh);
            System.out.println("Bill: $" + cost);
            total += cost;
        }
        System.out.println("Total: $"   + total);
        System.out.println("Average: $" + (int) Math.round((double) total / n));
    }
}

/*
 * Time Complexity: O(n)
 * 說明：讀入 n 筆用電量後，各呼叫一次 calc（固定階段數量），整體為線性
 */
