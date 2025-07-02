import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();               
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();            
        }
        sc.close();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count++;                  
            }
        }

        System.out.println(count);
        System.out.println(count);         
    }
}