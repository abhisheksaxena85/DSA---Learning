/*
    Starting Binary Trees
    Start Date - June 23, 2025, 12:04 AM
 */

class chapter_17 {

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node result = buildTree(arr);
        postorder(result);
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
