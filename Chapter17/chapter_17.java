/*
    Starting Binary Trees
    Start Date - June 23, 2025, 12:04 AM
 */

import java.util.HashMap;
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

        findKthLevelNodes(root, 1, 1);

        // Node node = new Node(2);
        // node.left = new Node(4);
        // node.right = new Node(5);

        // System.out.println(isSubtreeFound(root, node));
    }

    public static boolean isSubtreeFound(Node root, Node node) {
        if (root == null) {
            return false;
        } else if (root.data == node.data) {
            if (isIdentical(root, node)) {
                return true;
            }
        }

        boolean left = isSubtreeFound(root.left, node);
        boolean right = isSubtreeFound(root.right, node);
        return left || right;
    }

    public static boolean isIdentical(Node root, Node node) {
        if (root == null && node == null) {
            return true;
        } else if (root == null || node == null || root.data != node.data) {
            return false;
        } else if (!isIdentical(root.left, node.left)) {
            return false;
        } else if (!isIdentical(root.right, node.right)) {
            return false;
        }
        return true;
    }

    static class Data {

        int diameter;
        int height;

        public Data(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Data diameter(Node root) {
        if (root == null) {
            return new Data(0, 0);
        }

        Data left = diameter(root.left);
        Data right = diameter(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int diam = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height + 1);

        return new Data(diam, height);
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

    static class Info {
        int horizontalDistance;
        Node node;

        Info(int horizontalDistance, Node node) {
            this.horizontalDistance = horizontalDistance;
            this.node = node;
        }
    }

    public static void topView(Node node) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        q.add(new Info(0, node));
        q.add(null);

        while (!q.isEmpty()) {
            Info val = q.remove();
            if (val == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(val.horizontalDistance)) {
                    map.put(val.horizontalDistance, val.node);
                    System.out.println(val.node.data);
                }
                if (val.node.left != null) {
                    q.add(new Info(val.horizontalDistance - 1, val.node.left));
                }
                if (val.node.right != null) {
                    q.add(new Info(val.horizontalDistance + 1, val.node.right));

                }
            }
        }
    }

    public static void findKthLevelNodes(Node root, int k, int level) {
        if (root == null) {
            return;
        }

        if (k == level) {
            System.out.println(root.data + " ");
        }

        findKthLevelNodes(root.left, k, level + 1);
        findKthLevelNodes(root.right, k, level + 1);
    }

    // public static void findLevel(N){}

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
