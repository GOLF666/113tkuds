import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();                      
        int result = (n + n) + (n * 5);            
        System.out.println(result);                
        sc.close();
    }
}