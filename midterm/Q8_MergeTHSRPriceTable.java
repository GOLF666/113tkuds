package midterm;

import java.util.*;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stn = new String[n];
        int[] std = new int[n], bus = new int[n];
        for (int i = 0; i < n; i++) {
            stn[i] = sc.next();
            std[i] = sc.nextInt();
            bus[i] = sc.nextInt();
        }
        System.out.println("Station|Standard|Business");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s|%d|%d\n", stn[i], std[i], bus[i]);
        }
    }
}
