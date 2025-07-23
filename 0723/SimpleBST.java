public class SimpleBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    // 搜尋值
    public static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;
        
        if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }
    
    public static void main(String[] args) {
        // 手動建立一個BST
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        
        // 測試搜尋
        System.out.println("搜尋 30: " + search(root, 30));
        System.out.println("搜尋 40: " + search(root, 40));
        System.out.println("搜尋 60: " + search(root, 60));
        System.out.println("搜尋 25: " + search(root, 25));

        System.out.println("搜尋 10: " + search(root, 10));
        System.out.println("搜尋 15: " + search(root, 15));
        System.out.println("搜尋 35: " + search(root, 35));
        System.out.println("搜尋 50: " + search(root, 50));
        System.out.println("搜尋 70: " + search(root, 70));
        System.out.println("搜尋 99: " + search(root, 99));

    }
}