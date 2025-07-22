import java.util.Scanner;

public class StringReverse {
    
    // 遞迴反轉字串
    public static String reverseString(String str) {
        // 停止條件：空字串或單字元
        if (str.length() <= 1) {
            return str;
        }
        // 尾字元 + 反轉剩下的字串
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入一個單字：");
        String input = scanner.nextLine();

        String reversed = reverseString(input);

        System.out.println("反轉結果：" + reversed);

        scanner.close();
    }
}