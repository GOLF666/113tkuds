package midterm;

import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
            if (a[i] == 5.0) count++;
        }
        if (count == 0) {
            System.out.println("None");
            return;
        }
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 5.0) idx.add(i);
        }
        for (int i = 0; i < idx.size(); i++) {
            System.out.print(idx.get(i) + (i < idx.size() - 1 ? " " : ""));
        }
        System.out.println();
    }
}
