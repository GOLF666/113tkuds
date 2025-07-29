package finalexam;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class F11_BSTClosestValue {
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
        List<Integer> vals = new ArrayList<>();
        for (String t : sc.nextLine().trim().split("\\s+"))
            vals.add(Integer.parseInt(t));
        int target = sc.nextInt();
        TreeNode root = buildTree(vals);
        int closest = root.val;
        TreeNode node = root;
        while (node != null) {
            if (Math.abs(node.val - target) < Math.abs(closest - target) ||
                (Math.abs(node.val - target) == Math.abs(closest - target) && node.val < closest)) {
                closest = node.val;
            }
            node = (target < node.val ? node.left : node.right);
        }
        System.out.println(closest);
    }
}
