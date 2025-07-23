import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> getAllRootToLeafPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        traverse(root, new ArrayList<>(), paths);
        return paths;
    }

    private static void traverse(TreeNode node, List<Integer> path, List<List<Integer>> paths) {
        if (node == null) return;
        path.add(node.data);

        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            traverse(node.left, path, paths);
            traverse(node.right, path, paths);
        }

        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.data == targetSum;
        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
    }

    public static List<Integer> maxSumPath(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        maxSumPathHelper(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    private static void maxSumPathHelper(TreeNode node, List<Integer> currentPath, int currentSum,
                                         int[] maxSum, List<Integer> maxPath) {
        if (node == null) return;

        currentPath.add(node.data);
        currentSum += node.data;

        if (node.left == null && node.right == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                maxPath.clear();
                maxPath.addAll(currentPath);
            }
        } else {
            maxSumPathHelper(node.left, currentPath, currentSum, maxSum, maxPath);
            maxSumPathHelper(node.right, currentPath, currentSum, maxSum, maxPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> paths = getAllRootToLeafPaths(root);
        System.out.println("所有根到葉路徑:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        int target = 22;
        System.out.println("是否存在總和為 " + target + " 的路徑: " + hasPathSum(root, target));

        List<Integer> maxPath = maxSumPath(root);
        System.out.println("最大總和路徑: " + maxPath);
    }
}