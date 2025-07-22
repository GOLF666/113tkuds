public class DigitSum {
    // 遞迴：計算 n 的各位數總和
    public static int digitSum(int n) {
        // 停止條件：只剩個位數
        if (n < 10) {
            return n;
        }
        // 取個位數 + 剩下的數遞迴加總
        return (n % 10) + digitSum(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("digitSum(1234) = " + digitSum(1234)); // 1+2+3+4 = 10
        System.out.println("digitSum(9) = " + digitSum(9));       // 9
        System.out.println("digitSum(9876) = " + digitSum(9876)); // 9+8+7+6 = 30
    }
}