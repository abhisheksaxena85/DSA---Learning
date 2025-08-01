/*
    Starting Binary Search Trees
    Start Date - Jul 29, 2025, 02:23 AM
 */

import java.util.*;

public class chapter_18 {

    public static void main(String args[]) {
        // int arr[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        // TreeNode t = buildTree(arr);
        // inorderTraversal(t);
        // System.out.println();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(14);
        // System.out.println(searchNode(root, 121));
        // levelOrderPrint(t);
        // System.out.println();
        // rootToLeaf(t);

        System.out.println(isValidBST(root, null, null));
        // levelOrderPrint(t);
        // System.out.println();
    }

    public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    static ArrayList<Integer> path = new ArrayList<>();

    public static void rootToLeaf(TreeNode root) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + " ");
            }
            System.out.println();
        }

        rootToLeaf(root.left);
        rootToLeaf(root.right);
        path.remove(path.size() - 1);
    }

    public static void printInRange(TreeNode root, int k1, int k2) { // K1 is min & K2 is max
        if (root == null) {
            return;
        }

        // When range is in both subtrees
        if (root.val >= k1 && root.val <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.val + " ");
            printInRange(root.right, k1, k2);

        } else if (root.val > k2) { // When range is in left subtree
            printInRange(root.left, k1, k2);
        } else if (root.val < k1) { // When range is in right subtree
            printInRange(root.right, k1, k2);
        } else {
            System.out.print(root.val + " ");
        }
    }

    public static TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return root;
        } else if (root.val > val) {
            root.left = delete(root.left, val);
        } else if (root.val < val) {
            root.right = delete(root.right, val);
        } else {
            // When node is leaf node
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) { // Node with single child
                return root.right;
            } else if (root.right == null) { // Node with single child
                return root.left;
            } else { // Node with two childs
                // find inorder successor
                TreeNode IS = inorderSuccessor(root.right);
                // replace root's data with inorder successor's data
                root.val = IS.val;

                // delete the inorder successor
                root.right = delete(root.right, IS.val);
            }
        }
        return root;
    }

    public static TreeNode inorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void levelOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        levelOrderPrint(root.left);
        System.out.print(root.val + " - ");
        levelOrderPrint(root.right);
    }

    public static boolean searchNode(TreeNode root, int key) {
        if (root == null) {
            return false;
        } else if (root.val == key) {
            return true;
        }

        if (root.val > key) {// left
            return searchNode(root.left, key);
        } else {// right
            return searchNode(root.right, key);
        }
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
