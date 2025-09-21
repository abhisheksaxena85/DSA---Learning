/*
    Starting Hashing[Map(Hashmap, LinkedHasmap, Treemap), Sets(HashSet, LinkedSet, TreeSet)]
    Start Date - Aug 22 2025, 09:35 PM
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;
// import java.util.HashMap;

public class chapter_20 {

    public static void main(String[] args) {
        // TreeMap<String, Integer> map = new TreeMap<>();
        // map.put("india", 120);
        // map.put("china", 140);

        // map.put("a1", 5689);
        // map.put("a2", 5689);
        // map.put("asdfghjk3", 5689);
        // map.put("asdfghjk4", 5689);
        // map.put("asdfghjk5", 5689);
        // map.put("asdfghjk6", 5689);
        // map.put("asdfghjk7", 5689);
        // map.put("asdfghjk9", 5689);
        // System.out.println(map);

        // int arr[] = { 1, 2 };
        // int n = arr.length / 3;
        // HashMap<Integer, Integer> hash = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        // if (hash.containsKey(arr[i])) {
        // hash.put(arr[i], hash.get(arr[i]) + 1);
        // } else {
        // hash.put(arr[i], 1);
        // }
        // }
        // for (Integer key : hash.keySet()) {
        // if (hash.get(key) >= n) {
        // System.out.println(key);
        // }
        // }

        // String s1 = "tulip";
        // String s2 = "lipid";
        // HashMap<Character, Integer> s1Hash = new HashMap<>();
        // HashMap<Character, Integer> s2Hash = new HashMap<>();

        // for (int i = 0; i < s1.length() && i < s2.length(); i++) {
        // s1Hash.put(s1.charAt(i), s1Hash.getOrDefault(s1.charAt(i), 0) + 1);
        // s2Hash.put(s2.charAt(i), s2Hash.getOrDefault(s2.charAt(i), 0) + 1);
        // }

        // Character set1[] = s1Hash.keySet().toArray(new Character[0]);
        // Character set2[] = s1Hash.keySet().toArray(new Character[0]);

        // for (int i = 0; i < set1.length && i < set2.length; i++) {
        // Character c1 = set1[i];
        // Character c2 = set2[i];

        // if (s2Hash.get(c1) != s1Hash.get(c1)) {
        // System.out.println(false);
        // return;
        // }
        // }
        // System.out.println(true);

        // TreeSet<Integer> hashSet = new TreeSet<>();
        // hashSet.add(2);
        // hashSet.add(1);
        // hashSet.add(4);
        // hashSet.add(5);
        // System.out.println(hashSet);
        // while (hashSet.iterator().hasNext()) {
        // System.out.println(hashSet.iterator().next());
        // hashSet.remove(hashSet.iterator().next());
        // }

        // int arr[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };
        // HashSet<Integer> hash = new HashSet<>();
        // for (int i = 0; i < arr.length; i++) {
        // hash.add(arr[i]);
        // }

        // System.out.println(hash.size());

        int set1[] = { 7, 3, 9 };
        int set2[] = { 6, 3, 9, 2, 9, 4 };

        /// Union of two sets
        HashSet<Integer> hashUnion = new HashSet<>();
        for (int i = 0; i < set1.length; i++) {
            hashUnion.add(set1[i]);
        }
        for (int i = 0; i < set2.length; i++) {
            hashUnion.add(set2[i]);
        }
        // System.out.println(hashUnion);

        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < set1.length; i++) {
            hash.add(set1[i]);
        }
        for (int i = 0; i < set2.length; i++) {
            if (hash.contains(set2[i])) {
                hash.remove(set1[i]);
                System.out.println(set2[i]);
            }
        }
    }
}

// class HashMap<K, V> {

// private LinkedList<Node> buckets[];
// private int bucketLength = 0;
// private int length = 0;

// @SuppressWarnings("unchecked")
// HashMap() {
// this.bucketLength = 4;
// this.buckets = new LinkedList[4];
// for (int i = 0; i < 4; i++) {
// this.buckets[i] = new LinkedList<>();
// }
// }

// public int hashFunction(K key) {
// int hashCode = key.hashCode();
// return Math.abs(hashCode) % bucketLength;
// }

// public int searchLinkedList(K key, int bi) {
// LinkedList<Node> ll = buckets[bi];
// for (int i = 0; i < ll.size(); i++) {
// Node node = ll.get(i);
// if (node.key == key) {
// return i;
// }
// }
// return -1;
// }

// @SuppressWarnings("unchecked")
// private void rehasing() {
// LinkedList<Node> oldBucketList[] = buckets;
// buckets = new LinkedList[bucketLength * 2];
// bucketLength = bucketLength * 2;
// for (int i = 0; i < buckets.length; i++) {
// buckets[i] = new LinkedList<>();
// }

// for (LinkedList<Node> ll : oldBucketList) {
// for (int j = 0; j < ll.size(); j++) {
// Node node = ll.remove(j);
// put(node.key, node.value);
// }
// }
// }

// public void put(K key, V value) {
// int bi = hashFunction(key);
// int nodeIndex = searchLinkedList(key, bi);
// if (nodeIndex != -1) { // Replacing the element
// Node node = buckets[bi].get(nodeIndex);
// node.value = value;
// } else {
// buckets[bi].add(new Node(key, value));
// length++;
// }

// // Cheking the value of lembda
// double lembda = (double) length / bucketLength;
// if (lembda > 2.00) {
// rehasing();
// }
// }

// public boolean containsKey(K key) {
// int bi = hashFunction(key);
// int nodeIndex = searchLinkedList(key, bi);
// return nodeIndex != -1;
// }

// public V remove(K key) {
// int bi = hashFunction(key);
// int nodeIndex = searchLinkedList(key, bi);
// if (nodeIndex != -1) {
// length--;
// return buckets[bi].remove(nodeIndex).value;
// } else {
// return null;
// }
// }

// public V get(K key) {
// int bi = hashFunction(key);
// int nodeIndex = searchLinkedList(key, bi);
// if (nodeIndex != -1) {
// return buckets[bi].get(nodeIndex).value;
// } else {
// return null;
// }
// }

// public boolean isEmpty() {
// return length == 0;
// }

// private class Node {

// K key;
// V value;

// public Node(K key, V value) {
// this.key = key;
// this.value = value;
// }
// }
// }
