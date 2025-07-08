import java.util.Scanner;

public class q7permutation {
    static int count = 0;

    static void perm(int[] a, int l) {
        if (l == a.length) {
            for (int v : a) System.out.print(v + " ");
            System.out.println();
            count++;
            return;
        }
        for (int i = l; i < a.length; i++) {
            int t = a[l]; a[l] = a[i]; a[i] = t;
            perm(a, l + 1);
            t = a[l]; a[l] = a[i]; a[i] = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();              
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        sc.close();

        perm(a, 0);                      
        System.out.println(count);      
    }
}