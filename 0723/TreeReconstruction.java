import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1,
                          inorder, 0, inorder.length - 1, inIndex);
    }

    private static TreeNode buildPreIn(int[] pre, int ps, int pe,
                                       int[] in, int is, int ie,
                                       Map<Integer, Integer> inIndex) {
        if (ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(pre[ps]);
        int index = inIndex.get(pre[ps]);
        int leftSize = index - is;

        root.left = buildPreIn(pre, ps + 1, ps + leftSize, in, is, index - 1, inIndex);
        root.right = buildPreIn(pre, ps + leftSize + 1, pe, in, index + 1, ie, inIndex);
        return root;
    }

    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1,
                           inorder, 0, inorder.length - 1, inIndex);
    }

    private static TreeNode buildPostIn(int[] post, int ps, int pe,
                                        int[] in, int is, int ie,
                                        Map<Integer, Integer> inIndex) {
        if (ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(post[pe]);
        int index = inIndex.get(post[pe]);
        int leftSize = index - is;

        root.left = buildPostIn(post, ps, ps + leftSize - 1, in, is, index - 1, inIndex);
        root.right = buildPostIn(post, ps + leftSize, pe - 1, in, index + 1, ie, inIndex);
        return root;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private static void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inOrder(node.left, result);
        result.add(node.data);
        inOrder(node.right, result);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder =  {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root1 = buildFromPreIn(preorder, inorder);
        System.out.println("前序+中序建立的樹之中序：" + inorderTraversal(root1));

        TreeNode root2 = buildFromPostIn(postorder, inorder);
        System.out.println("後序+中序建立的樹之中序：" + inorderTraversal(root2));

        System.out.println("是否重建正確：" + inorderTraversal(root1).equals(Arrays.asList(9, 3, 15, 20, 7)));
    }
}