package midterm;

import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            String[] p = t.split(":");
            times[i] = Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
        }
        String q = sc.next();
        String[] pp = q.split(":");
        int qt = Integer.parseInt(pp[0]) * 60 + Integer.parseInt(pp[1]);
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (times[mid] > qt) r = mid;
            else l = mid + 1;
        }
        if (l >= n) {
            System.out.println("No train");
        } else {
            int t = times[l];
            System.out.printf("%02d:%02d\n", t / 60, t % 60);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：對排序後的陣列執行二分搜尋找下一班時間
 */
