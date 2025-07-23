public class TreeStatistics {

    // 二元樹節點類別
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 1. 計算節點總和
    public static int sum(TreeNode root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    // 2. 找最大值
    public static int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }

    // 2. 找最小值
    public static int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.data, Math.min(findMin(root.left), findMin(root.right)));
    }

    // 3. 計算葉節點數量
    public static int countLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 4. 計算樹的高度
    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // 測試
    public static void main(String[] args) {
        // 建立一棵測試樹：
        /*
                10
               /  \
              5    15
             / \     \
            2   7     20
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        System.out.println("節點總和: " + sum(root));
        System.out.println("最大值: " + findMax(root));
        System.out.println("最小值: " + findMin(root));
        System.out.println("葉節點數: " + countLeaves(root));
        System.out.println("樹的高度: " + getHeight(root));
    }
}