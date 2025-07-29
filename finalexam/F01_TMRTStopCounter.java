package finalexam;

import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }
        String start = sc.next();
        String end = sc.next();
        int si = -1, ei = -1;
        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) si = i;
            if (stops[i].equals(end))   ei = i;
        }
        if (si == -1 || ei == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(si - ei) + 1);
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：一次掃描陣列找起訖索引，計算差值並加 1
 */
