/*
    Starting Hashing[Map(Hashmap, LinkedHasmap, Treemap), Sets(HashSet, LinkedSet, TreeSet)]
    Start Date - Aug 22 2025, 09:35 PM
 */

import java.util.LinkedList;

public class chapter_20 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("China", 140);

        map.remove("India");
        System.out.println(map.containsKey("China"));
    }

}

class HashMap<K, V> {

    private LinkedList<Node> buckets[];
    private int bucketLength = 0;
    private int length = 0;

    @SuppressWarnings("unchecked")
    HashMap() {
        this.bucketLength = 4;
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public int hashFunction(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % bucketLength;
    }

    public int searchLinkedList(K key, int bi) {
        LinkedList<Node> ll = buckets[bi];
        for (int i = 0; i < ll.size(); i++) {
            Node node = ll.get(i);
            if (node.key == key) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehasing() {
        LinkedList<Node> oldBucketList[] = buckets;
        buckets = new LinkedList[bucketLength * 2];
        bucketLength = bucketLength * 2;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Node> ll : oldBucketList) {
            for (int j = 0; j < ll.size(); j++) {
                Node node = ll.remove(j);
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        int bi = hashFunction(key);
        int nodeIndex = searchLinkedList(key, bi);
        if (nodeIndex != -1) { // Replacing the element
            Node node = buckets[bi].get(nodeIndex);
            node.value = value;
        } else {
            buckets[bi].add(new Node(key, value));
            length++;
        }

        // Cheking the value of lembda
        double lembda = (double) length / bucketLength;
        if (lembda > 2.00) {
            rehasing();
        }
    }

    public boolean containsKey(K key) {
        int bi = hashFunction(key);
        int nodeIndex = searchLinkedList(key, bi);
        return nodeIndex != -1;
    }

    public V remove(K key) {
        int bi = hashFunction(key);
        int nodeIndex = searchLinkedList(key, bi);
        if (nodeIndex != -1) {
            length--;
            return buckets[bi].remove(nodeIndex).value;
        } else {
            return null;
        }
    }

    public V get(K key) {
        int bi = hashFunction(key);
        int nodeIndex = searchLinkedList(key, bi);
        if (nodeIndex != -1) {
            return buckets[bi].get(nodeIndex).value;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private class Node {

        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
