import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.printf("%4d", i * j); 
            }
            System.out.println(); 
        }
    }
}
