import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }

    public static List<Integer> findInvalidNodes(TreeNode root) {
        List<Integer> invalid = new ArrayList<>();
        findInvalidNodesHelper(root, Long.MIN_VALUE, Long.MAX_VALUE, invalid);
        return invalid;
    }

    private static void findInvalidNodesHelper(TreeNode node, long min, long max, List<Integer> invalid) {
        if (node == null) return;
        if (node.data <= min || node.data >= max) invalid.add(node.data);
        findInvalidNodesHelper(node.left, min, node.data, invalid);
        findInvalidNodesHelper(node.right, node.data, max, invalid);
    }

    public static int minRemovalsToValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        collectInOrder(root, inorder);
        return inorder.size() - lengthOfLIS(inorder);
    }

    private static void collectInOrder(TreeNode node, List<Integer> inorder) {
        if (node == null) return;
        collectInOrder(node.left, inorder);
        inorder.add(node.data);
        collectInOrder(node.right, inorder);
    }

    private static int lengthOfLIS(List<Integer> nums) {
        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(lis, num);
            if (i < 0) i = -i - 1;
            if (i == lis.size()) lis.add(num);
            else lis.set(i, num);
        }
        return lis.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8); // 錯誤：應大於10
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(12); // 錯誤：應小於10

        System.out.println("是否為有效 BST: " + isValidBST(root));
        System.out.println("不合法節點: " + findInvalidNodes(root));
        System.out.println("最少移除節點數: " + minRemovalsToValidBST(root));
    }
}