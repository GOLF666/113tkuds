package midterm;

import java.util.*;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        int limit = Math.min(n, 5);
        for (int i = 0; i < limit; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[max]) max = j;
            }
            double tmp = a[i];
            a[i] = a[max];
            a[max] = tmp;
            System.out.printf("%.1f\n", a[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：使用選擇排序兩層巢狀迴圈找出前 5 名
 */
