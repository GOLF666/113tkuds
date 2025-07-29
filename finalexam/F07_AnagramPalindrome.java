package finalexam;

import java.util.*;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                cnt[c - 'a']++;
            }
        }
        int odd = 0;
        for (int v : cnt) if ((v & 1) == 1) odd++;
        System.out.println(odd <= 1 ? "Possible" : "Impossible");
    }
}
