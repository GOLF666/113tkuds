import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();               
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();            
        }
        int key = sc.nextInt();             
        sc.close();

        boolean found = false;
        int ops = 0;                       
        for (int i = 0; i < n; i++) {
            ops++;
            if (a[i] == key) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Yes" : "No");
        System.out.println(ops);           
    }
}