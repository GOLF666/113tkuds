import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 找兩個節點之間的距離
    public static int distanceBetweenNodes(TreeNode root, int a, int b) {
        TreeNode lca = lowestCommonAncestor(root, a, b);
        int distA = distanceFromNode(lca, a);
        int distB = distanceFromNode(lca, b);
        return distA + distB;
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {
        if (root == null || root.data == a || root.data == b) return root;

        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    private static int distanceFromNode(TreeNode node, int target) {
        if (node == null) return -1;
        if (node.data == target) return 0;

        int left = distanceFromNode(node.left, target);
        int right = distanceFromNode(node.right, target);

        if (left >= 0) return 1 + left;
        if (right >= 0) return 1 + right;
        return -1;
    }

    // 2. 找樹的直徑（任兩點最長距離）
    static int maxDiameter = 0;

    public static int treeDiameter(TreeNode root) {
        maxDiameter = 0;
        getHeightAndUpdateDiameter(root);
        return maxDiameter;
    }

    private static int getHeightAndUpdateDiameter(TreeNode node) {
        if (node == null) return 0;

        int left = getHeightAndUpdateDiameter(node.left);
        int right = getHeightAndUpdateDiameter(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }

    // 3. 找出與根距離為 k 的所有節點
    public static List<Integer> nodesAtDistanceKFromRoot(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        findNodesAtK(root, k, result);
        return result;
    }

    private static void findNodesAtK(TreeNode node, int k, List<Integer> result) {
        if (node == null) return;
        if (k == 0) {
            result.add(node.data);
        } else {
            findNodesAtK(node.left, k - 1, result);
            findNodesAtK(node.right, k - 1, result);
        }
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \   \
          4   5   6
                   \
                    7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println("距離(4, 5): " + distanceBetweenNodes(root, 4, 5)); // 2
        System.out.println("距離(4, 7): " + distanceBetweenNodes(root, 4, 7)); // 4
        System.out.println("樹的直徑: " + treeDiameter(root)); // 5
        System.out.println("與根距離為2的節點: " + nodesAtDistanceKFromRoot(root, 2)); // [4, 5, 6]
    }
}