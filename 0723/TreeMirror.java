public class TreeMirror {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.data == b.data && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    public static void mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    public static boolean areMirrors(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.data == b.data && areMirrors(a.left, b.right) && areMirrors(a.right, b.left);
    }

    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.right.right = new TreeNode(3);

        System.out.println("是否對稱: " + isSymmetric(root1));

        System.out.print("鏡像前中序: ");
        printInOrder(root1);
        System.out.println();

        mirror(root1);

        System.out.print("鏡像後中序: ");
        printInOrder(root1);
        System.out.println();

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println("兩棵樹是否互為鏡像: " + areMirrors(root1, root2));
    }
}