import java.util.Scanner;

public class q6fibonaccirec {
    static long fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();               
        sc.close();
        long fn = fib(n);                  
        long calls = 2 * fn - 1;            
        System.out.println(fn);
        System.out.println(calls);          
    }
}