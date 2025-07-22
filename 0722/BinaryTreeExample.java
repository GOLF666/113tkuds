class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class BinaryTreeExample {
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;
        return search(root.left, target) || search(root.right, target);
    }

    public static void main(String[] args) {
        // 構造節點數=9，高度=5 的樹
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.left.left = new TreeNode(9);

        System.out.print("前序走訪: ");
        preOrder(root);
        System.out.println();

        System.out.println("樹的高度: " + getHeight(root));   // 應為 5
        System.out.println("節點總數: " + countNodes(root));  // 應為 9
        System.out.println("搜尋 4: " + search(root, 4));     // true
        System.out.println("搜尋 6: " + search(root, 6));   // false
    }
}