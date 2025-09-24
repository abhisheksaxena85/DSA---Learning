/*
    Starting Binary Search Trees
    Start Date - Jul 29, 2025, 02:23 AM
 */

import java.util.*;

class chapter_18 {

    public static void main(String args[]) {
        // int arr[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        // TreeNode t = buildTree(arr);
        // inorderTraversal(t);
        // System.out.println();

        // TreeNode root = new TreeNode(8);
        // root.left = new TreeNode(5);
        // root.right = new TreeNode(10);
        // root.left.left = new TreeNode(3);
        // root.left.right = new TreeNode(6);
        // root.left.left.left = new TreeNode(1);
        // root.left.left.right = new TreeNode(4);
        // root.right.right = new TreeNode(11);
        // root.right.right.right = new TreeNode(14);
        // System.out.println(searchNode(root, 121));
        // levelOrderPrint(t);
        // System.out.println();
        // rootToLeaf(t);
        // System.out.println(isValidBST(t, null, null));
        // levelOrderPrint(t);
        // System.out.println();
        // mirrorEffect(t);
        // levelOrderPrint(t);
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(17);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        TreeNode root = mergeBST(root1, root2);
        inorderTraversal(root);
    }

    public static TreeNode mergeBST(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        // Step 1 - Get both BST to sorted lists
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(root1, arr1);
        inorder(root2, arr2);

        // Step 2 - Merge both sorted lists into one
        ArrayList<Integer> mergedList = mergeList(arr1, arr2);

        // Step 3 - Build a BST from merged list with balanced height
        return buildTree(mergedList, 0, mergedList.size() - 1);
    }

    // Building BST with sorted list
    public static TreeNode buildTree(ArrayList<Integer> list, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, si, mid - 1);
        root.right = buildTree(list, mid + 1, ei);
        return root;
    }

    // Merge two soretd lists
    public static ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                list.add(list1.get(i));
                i++;
            } else {
                list.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            list.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            list.add(list2.get(j));
            j++;
        }

        return list;
    }

    // Get values to list from BST
    public static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    static class Info {

        boolean isValidBST;
        int max;
        int min;
        int size;

        Info(boolean isValidBST, int max, int min, int size) {
            this.isValidBST = isValidBST;
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }

    static int maxLengthOfRoot = 0;

    public static Info getLargestBST(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        Info left = getLargestBST(root.left);
        Info right = getLargestBST(root.right);

        int max = Math.max(root.val, Math.max(left.max, right.max));
        int min = Math.min(root.val, Math.min(left.min, right.min));
        int size = left.size + right.size + 1;

        // when BST is not valid
        if (root.val <= left.max || root.val >= right.min) {
            return new Info(false, max, min, size);
        }

        // if Left or right is invalid BST then current root also be invalid
        if (left.isValidBST && right.isValidBST) {
            maxLengthOfRoot = Math.max(maxLengthOfRoot, size);
            return new Info(true, max, min, size);
        }

        return new Info(false, max, min, size);
    }

    public static TreeNode buildTree(int si, int ei, int[] nums) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(si, mid - 1, nums);
        root.right = buildTree(mid + 1, ei, nums);
        return root;
    }

    public static TreeNode mirrorEffect(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = mirrorEffect(root.left);
        TreeNode right = mirrorEffect(root.right);

        root.left = right;
        root.right = left;
        return root;
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

    // public static TreeNode buildTree(int[] arr) {
    // TreeNode root = null;
    // for (int i = 0; i < arr.length; i++) {
    // root = insert(root, arr[i]);
    // }
    // return root;
    // }
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
