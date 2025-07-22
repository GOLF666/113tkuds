public class FibonacciSlow {
    // 標準遞迴版（效率低）
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    // 使用記憶化的高效版（Top-down DP）
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n]; // 若已計算過則直接回傳
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 35; // 測試計算第 35 項

        // 測試 fibonacciSlow
        long startSlow = System.currentTimeMillis();
        int resultSlow = fibonacciSlow(n);
        long endSlow = System.currentTimeMillis();
        System.out.println("fibonacciSlow(" + n + ") = " + resultSlow);
        System.out.println("耗時：" + (endSlow - startSlow) + " ms");

        // 測試 fibonacciFast
        int[] memo = new int[n + 1]; // 建立記憶陣列
        long startFast = System.currentTimeMillis();
        int resultFast = fibonacciFast(n, memo);
        long endFast = System.currentTimeMillis();
        System.out.println("fibonacciFast(" + n + ") = " + resultFast);
        System.out.println("耗時：" + (endFast - startFast) + " ms");
    }
}