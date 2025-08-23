/*
    Starting Hashing[Map(Hashmap, LinkedHasmap, Treemap), Sets(HashSet, LinkedSet, TreeSet)]
    Start Date - Aug 22 2025, 09:35 PM
 */

import java.util.*;

public class chapter_20 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("China", 140);

        map.remove("India");

        System.out.println(map.get("India"));
    }
}