public class BSTKthElement {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class Counter {
        int count = 0;
        int result = -1;
    }

    public static int kthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        inOrderKth(root, k, counter);
        return counter.result;
    }

    private static void inOrderKth(TreeNode node, int k, Counter counter) {
        if (node == null || counter.count >= k) return;

        inOrderKth(node.left, k, counter);

        counter.count++;
        if (counter.count == k) {
            counter.result = node.data;
            return;
        }

        inOrderKth(node.right, k, counter);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        System.out.println("第 1 小: " + kthSmallest(root, 1)); // 5
        System.out.println("第 3 小: " + kthSmallest(root, 3)); // 15
        System.out.println("第 5 小: " + kthSmallest(root, 5)); // 25
        System.out.println("第 7 小: " + kthSmallest(root, 7)); // 35
    }
}