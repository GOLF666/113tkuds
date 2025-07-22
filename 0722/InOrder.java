// 定義 TreeNode 類別
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
    }
}

public class InOrder {

    // 中序走訪：左 → 根 → 右
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);             // 遞迴左子樹
        System.out.print(root.data + " "); // 拜訪根節點
        inOrder(root.right);            // 遞迴右子樹
    }

    public static void main(String[] args) {
        // 建立一棵範例二元樹：
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("中序走訪結果: ");
        inOrder(root); // 預期輸出：4 2 5 1 3
    }
}