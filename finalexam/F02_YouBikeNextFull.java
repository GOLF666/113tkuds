package finalexam;

import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            String[] p = t.split(":");
            times[i] = Integer.parseInt(p[0])*60 + Integer.parseInt(p[1]);
        }
        String q = sc.next();
        String[] qp = q.split(":");
        int qt = Integer.parseInt(qp[0])*60 + Integer.parseInt(qp[1]);
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) / 2;
            if (times[m] > qt) r = m;
            else             l = m + 1;
        }
        if (l >= n) {
            System.out.println("No bike");
        } else {
            int t = times[l];
            System.out.printf("%02d:%02d\n", t/60, t%60);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：對已排序陣列使用二分搜尋找首個大於查詢時間
 */
