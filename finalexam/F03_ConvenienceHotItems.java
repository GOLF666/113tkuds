package finalexam;

import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] qty    = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            qty[i]   = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            String  keyName = names[i];
            int     keyQty  = qty[i];
            int     j       = i - 1;
            while (j >= 0 && qty[j] < keyQty) {
                names[j+1] = names[j];
                qty[j+1]   = qty[j];
                j--;
            }
            names[j+1] = keyName;
            qty[j+1]   = keyQty;
        }
        int limit = Math.min(n, 10);
        for (int i = 0; i < limit; i++) {
            System.out.println(names[i] + " " + qty[i]);
        }
    }
}

/*
 * Time Complexity: O(n^2)
 * 說明：使用插入排序，最壞需二重迴圈比較移動
 */
