/*
    Starting Binary Search Trees
    Start Date - Jul 29, 2025, 02:23 AM
 */

public class chapter_18 {
    public static void main(String args[]) {
        int arr[] = { 5, 1, 3, 4, 2, 7 };
        TreeNode t = buildTree(arr);
        inorderTraversal(t);
    }

    public static TreeNode buildTree(int[] arr) {
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        return root;
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) { // left sub tree
            root.left = insert(root.left, val);
        } else { // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " - ");
        inorderTraversal(root.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}
