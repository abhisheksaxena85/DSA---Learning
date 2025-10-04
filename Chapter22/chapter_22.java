/*
 * Starting Graphs
 * Start Date - Sep 28 2025, 10:03 PM
 */

import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

class chapter_22 {
    public static void main(String a[]) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> adjList[] = new ArrayList[7];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        adjList[0].add(new Edge(0, 1, 1));
        adjList[0].add(new Edge(0, 2, 1));
        adjList[1].add(new Edge(1, 0, 1));
        adjList[1].add(new Edge(1, 3, 1));

        adjList[2].add(new Edge(2, 0, 1));
        adjList[2].add(new Edge(2, 4, 1));

        adjList[3].add(new Edge(3, 1, 1));
        adjList[3].add(new Edge(3, 4, 1));
        adjList[3].add(new Edge(3, 5, 1));

        adjList[4].add(new Edge(4, 2, 1));
        adjList[4].add(new Edge(4, 3, 1));
        adjList[4].add(new Edge(4, 5, 1));

        adjList[5].add(new Edge(5, 3, 1));
        adjList[5].add(new Edge(5, 4, 1));

        adjList[6].add(new Edge(5, 6, 1));

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[adjList.length];

        q.add(0);

        while (!q.isEmpty()) {
            int val = q.remove();
            if (visited[val] == false) {
                System.out.println(val);
                for (int i = 0; i < adjList[val].size(); i++) {
                    q.add(adjList[val].get(i).destination);
                }
                visited[val] = true;
            }
        }

    }

    static class Edge {
        int source, destination, weight;

        public Edge(int s, int d, int w) {
            this.weight = w;
            this.source = s;
            this.destination = d;
        }
    }
}