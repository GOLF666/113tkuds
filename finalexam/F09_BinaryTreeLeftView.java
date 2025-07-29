package finalexam;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class F09_BinaryTreeLeftView {
    public static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;
        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 1;
        while (!q.isEmpty() && idx < vals.size()) {
            TreeNode node = q.poll();
            Integer v = vals.get(idx++);
            if (v != -1) {
                node.left = new TreeNode(v);
                q.add(node.left);
            }
            if (idx < vals.size()) {
                v = vals.get(idx++);
                if (v != -1) {
                    node.right = new TreeNode(v);
                    q.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().trim().split("\\s+");
        List<Integer> vals = new ArrayList<>();
        for (String p : parts) vals.add(Integer.parseInt(p));
        TreeNode root = buildTree(vals);
        List<Integer> leftView = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    TreeNode node = q.poll();
                    if (i == 0) leftView.add(node.val);
                    if (node.left  != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
            }
        }
        System.out.print("LeftView:");
        for (int v : leftView) System.out.print(" " + v);
        System.out.println();
    }
}
