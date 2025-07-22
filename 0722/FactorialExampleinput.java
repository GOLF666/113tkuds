import java.util.Scanner;

public class FactorialExampleinput {
    // 回傳 n! 的值，並記錄每一步的乘數
    public static int factorial(int n, StringBuilder steps) {
        if (n <= 1) {
            steps.append("1");
            return 1;
        }

        steps.append(n).append(" * ");
        int result = factorial(n - 1, steps);
        return n * result;
    }

    // 印出完整階乘計算過程
    public static void printFactorialProcess(int n) {
        StringBuilder steps = new StringBuilder();
        int result = factorial(n, steps);
        System.out.println(n + "! = " + steps.toString() + " = " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入一個非負整數 n：");
        int n;

        // 確保輸入為非負整數
        while (true) {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n >= 0) break;
                else System.out.print("請輸入一個非負整數（0或更大）：");
            } else {
                System.out.print("輸入錯誤，請輸入一個整數：");
                scanner.next(); // 清除錯誤輸入
            }
        }

        printFactorialProcess(n);

        scanner.close();
    }
}