public class BSTBalance {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 是否為平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;

        int left = checkBalance(node.left);
        int right = checkBalance(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    // 2. 取得某節點的平衡因子（左高 - 右高）
    public static int getBalanceFactor(TreeNode node) {
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // 3. 找出最不平衡的節點（平衡因子差最大）
    static class BalanceInfo {
        TreeNode node;
        int maxDiff = -1;
    }

    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        BalanceInfo info = new BalanceInfo();
        findUnbalancedHelper(root, info);
        return info.node;
    }

    private static int findUnbalancedHelper(TreeNode node, BalanceInfo info) {
        if (node == null) return 0;

        int left = findUnbalancedHelper(node.left, info);
        int right = findUnbalancedHelper(node.right, info);
        int diff = Math.abs(left - right);

        if (diff > info.maxDiff) {
            info.maxDiff = diff;
            info.node = node;
        }

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);

        System.out.println("是否為平衡樹: " + isBalanced(root));
        System.out.println("根節點平衡因子: " + getBalanceFactor(root));

        TreeNode mostUnbalanced = findMostUnbalancedNode(root);
        System.out.println("最不平衡節點: " + (mostUnbalanced != null ? mostUnbalanced.data : "無"));
    }
}