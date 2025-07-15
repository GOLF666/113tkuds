package midterm;

import java.util.*;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[7];
        for (int i = 0; i < 7; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 6; i >= 0; i--) {
            System.out.print(a[i] + (i > 0 ? " " : ""));
        }
        System.out.println();
    }
}
