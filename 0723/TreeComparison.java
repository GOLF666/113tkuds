public class TreeComparison {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 判斷兩棵樹是否完全相同
    public static boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.data != b.data) return false;
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }

    // 2. 判斷 tree2 是否為 tree1 的子樹
    public static boolean isSubtree(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) return true;
        if (tree1 == null) return false;
        if (isIdentical(tree1, tree2)) return true;
        return isSubtree(tree1.left, tree2) || isSubtree(tree1.right, tree2);
    }

    // 3. 找出兩棵樹的最大公共子樹（以節點數最大為準）
    public static TreeNode findLargestCommonSubtree(TreeNode a, TreeNode b) {
        int[] max = {0};
        TreeNode[] result = {null};
        findLCSHelper(a, b, max, result);
        return result[0];
    }

    private static int findLCSHelper(TreeNode a, TreeNode b, int[] max, TreeNode[] result) {
        if (a == null || b == null) return 0;

        if (a.data == b.data && isIdentical(a, b)) {
            int size = countNodes(a);
            if (size > max[0]) {
                max[0] = size;
                result[0] = a;
            }
        }

        int left = findLCSHelper(a.left, b, max, result);
        int right = findLCSHelper(a.right, b, max, result);
        findLCSHelper(a, b.left, max, result);
        findLCSHelper(a, b.right, max, result);

        return Math.max(left, right);
    }

    private static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void printPreOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void main(String[] args) {
        // Tree A
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.right.right = new TreeNode(6);

        // Tree B (identical to a.left)
        TreeNode b = new TreeNode(2);
        b.left = new TreeNode(4);
        b.right = new TreeNode(5);

        System.out.println("兩棵樹是否完全相同: " + isIdentical(a.left, b));
        System.out.println("b 是否為 a 的子樹: " + isSubtree(a, b));

        TreeNode common = findLargestCommonSubtree(a, b);
        System.out.print("最大公共子樹（前序）: ");
        printPreOrder(common);
    }
}