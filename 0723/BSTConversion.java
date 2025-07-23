import java.util.*;

public class BSTConversion {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class DoublyListNode {
        int data;
        DoublyListNode prev, next;

        DoublyListNode(int data) {
            this.data = data;
        }
    }

    // 1. BST → 排序的雙向鏈表
    public static DoublyListNode bstToDoublyLinkedList(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        inOrder(root, sorted);

        if (sorted.isEmpty()) return null;

        DoublyListNode head = new DoublyListNode(sorted.get(0));
        DoublyListNode curr = head;

        for (int i = 1; i < sorted.size(); i++) {
            DoublyListNode node = new DoublyListNode(sorted.get(i));
            curr.next = node;
            node.prev = curr;
            curr = node;
        }

        return head;
    }

    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);
    }

    // 2. 將排序陣列轉為平衡 BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildBalancedBST(arr, left, mid - 1);
        node.right = buildBalancedBST(arr, mid + 1, right);
        return node;
    }

    // 3. 將 BST 轉為 Greater Tree
    public static void convertToGreaterTree(TreeNode root) {
        convertHelper(root, new int[]{0});
    }

    private static void convertHelper(TreeNode node, int[] sum) {
        if (node == null) return;
        convertHelper(node.right, sum);
        sum[0] += node.data;
        node.data = sum[0];
        convertHelper(node.left, sum);
    }

    // 輔助列印中序
    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    // 測試
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        // 功能 1：BST → 雙向鏈表
        DoublyListNode head = bstToDoublyLinkedList(root);
        System.out.print("雙向鏈表正向: ");
        DoublyListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

        // 功能 2：陣列轉平衡 BST
        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        TreeNode balanced = sortedArrayToBST(sorted);
        System.out.print("平衡BST中序: ");
        printInOrder(balanced);
        System.out.println();

        // 功能 3：BST轉Greater Tree
        convertToGreaterTree(root);
        System.out.print("Greater Tree 中序: ");
        printInOrder(root);
        System.out.println();
    }
}