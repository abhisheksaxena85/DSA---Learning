/*
    Starting Tries
    Start Date - Sep 25 2025, 03:37 AM
 */

import java.util.List;

class chapter_21 {
    public static void main(String args[]) {

        // String arr[] = { "the", "a", "there", "their", "any", "thee" };

        // for (int i = 0; i < arr.length; i++) {
        // insert(arr[i]);
        // }

        // System.out.println(search("asdf"));

        // String arr[] = { "i", "like", "sam",
        // "samsung",
        // "mobile", "ice" };
        // String key = "ilikesamsung";

        // for (int i = 0; i < arr.length; i++) {
        // insert(arr[i]);
        // }
        // System.out.println(wordBreak(key));

        String arr[] = { "zebra", "dog", "duck", "dove" };

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        root.freq = -1;

        findPref(root, "");

    }

    public static void findPref(Node node, String ans) {
        if (node == null) {
            return;
        }
        if (node.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                findPref(node.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    // public static boolean wordBreak(String str) {
    // if (str.length() == 0) {
    // return true;
    // }
    // for (int i = 1; i <= str.length(); i++) {
    // if (search(str.substring(0, i)) == true && wordBreak(str.substring(i)) ==
    // true) {
    // return true;
    // }
    // }
    // return false;
    // }

    // public static boolean search(String strValue) {
    // Node curr = root;
    // for (int i = 0; i < strValue.length(); i++) {
    // int idx = strValue.charAt(i) - 'a';
    // if (curr.children[idx] == null) {
    // return false;
    // }
    // curr = curr.children[idx];
    // }
    // return curr.endOfWord == true;
    // }

    public static void insert(String str) {
        Node curr = root;
        for (int j = 0; j < str.length(); j++) {
            int idx = str.charAt(j) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    static Node root = new Node();

    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        int freq;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }
}