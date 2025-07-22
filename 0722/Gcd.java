public class Gcd {

    // 遞迴法：計算兩數的最大公因數
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a; // 終止條件：b 為 0 時，a 即為最大公因數
        }
        return gcd(b, a % b); // 遞迴呼叫
    }

    public static void main(String[] args) {
        System.out.println("GCD of 48 and 18: " + gcd(48, 18));   // 6
        System.out.println("GCD of 100 and 25: " + gcd(100, 25)); // 25
        System.out.println("GCD of 27 and 36: " + gcd(27, 36));   // 9
    }
}