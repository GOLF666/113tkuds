import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();               
        long sum = 0;                       
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();           
        }
        sc.close();
        System.out.println(sum);            
        System.out.println(n);              
    }
}
