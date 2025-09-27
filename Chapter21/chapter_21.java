/*
    Starting Tries
    Start Date - Sep 25 2025, 03:37 AM
 */

class chapter_21 {
    public static void main(String args[]) {

        String arr[] = { "the", "a", "there", "their", "any", "thee" };

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        System.out.println(search("asdf"));

    }

    public static boolean search(String strValue) {
        Node curr = root;
        for (int i = 0; i < strValue.length(); i++) {
            int idx = strValue.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord == true;
    }

    public static void insert(String str) {
        Node curr = root;
        for (int j = 0; j < str.length(); j++) {
            int idx = str.charAt(j) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    static Node root = new Node();

    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }
}