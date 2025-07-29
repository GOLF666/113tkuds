package finalexam;

import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    private static TreeNode insert(TreeNode root, int v) {
        if (root == null) return new TreeNode(v);
        if (v < root.val)  root.left  = insert(root.left,  v);
        else                root.right = insert(root.right, v);
        return root;
    }

    private static int rangeSumBST(TreeNode node, int L, int R) {
        if (node == null) return 0;
        if (node.val < L)  return rangeSumBST(node.right, L, R);
        if (node.val > R)  return rangeSumBST(node.left,  L, R);
        return node.val
             + rangeSumBST(node.left,  L, R)
             + rangeSumBST(node.right, L, R);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().trim().split("\\s+");
        TreeNode root = null;
        for (String p : parts) {
            int v = Integer.parseInt(p);
            if (v == -1) continue;    
            root = insert(root, v);
        }
        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSumBST(root, L, R);
        System.out.println(sum);
    }
}
