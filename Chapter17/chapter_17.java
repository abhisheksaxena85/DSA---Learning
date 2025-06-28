/*
    Starting Binary Trees
    Start Date - June 23, 2025, 12:04 AM
 */

class chapter_17 {

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node result = buildTree(arr, -1);
        System.out.println(result.left.left.data);
        System.out.println(result.data);
    }

    public static Node buildTree(int arr[], int index) {
        index++;
        if (arr[index] == -1) {
            return null;
        }

        Node newNode = new Node(arr[index]);
        newNode.left = buildTree(arr, index);
        newNode.right = buildTree(arr, index);
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
