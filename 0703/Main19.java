import java.util.Scanner;

public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                continue; 
            }
            sum += i;
        }

        System.out.println(sum);
    }
}
