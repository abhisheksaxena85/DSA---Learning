/*
    Starting Binary Trees
    Start Date - June 23, 2025, 12:04 AM
 */

import java.util.LinkedList;
import java.util.Queue;

class chapter_17 {

    public static void main(String[] args) {
        // int arr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // Node result = buildTree(arr);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(findDiameter(root));
    }

    public static int findDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);
        int max = treeHeight(root.left) + treeHeight(root.right) + 1;
        return Math.max(Math.max(right, left), max);
    }

    public static int totalSum(Node root) {
        if (root == null) {
            return 0;
        }
        int left = totalSum(root.left);
        int right = totalSum(root.right);
        return left + right + root.data;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    public static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node val = queue.remove();
            if (val == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(val.data);
                if (val.left != null) {
                    queue.add(val.left);
                }
                if (val.right != null) {
                    queue.add(val.right);
                }
            }
        }
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    static int index = -1;

    public static Node buildTree(int arr[]) {
        index++;
        if (arr[index] == -1) {
            return null;
        }

        Node newNode = new Node(arr[index]);
        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);
        return newNode;
    }

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
}
