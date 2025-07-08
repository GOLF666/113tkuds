import java.util.Scanner;

public class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(); 
        double pi = 3.14;
        double area = pi * r * r;

        System.out.printf("%.2f", area);
    }
}
