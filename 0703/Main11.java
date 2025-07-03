import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  
        sc.close();

        for (int i = 1; i <= N; i++) {
            StringBuilder line = new StringBuilder();

            for (int j = 1; j <= i; j++) {
                line.append(j).append(" ");
            }

            for (int j = i - 1; j >= 1; j--) {
                line.append(j);
                if (j != 1) {
                    line.append(" ");
                }
            }
            
            System.out.println(line.toString().trim());
        }
    }
}
