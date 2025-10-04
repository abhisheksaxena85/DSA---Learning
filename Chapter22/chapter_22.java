/*
 * Starting Graphs
 * Start Date - Sep 28 2025, 10:03 PM
 */

import java.util.*;

class chapter_22 {
    public static void main(String a[]) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> adjList[] = new ArrayList[5];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        adjList[0].add(new Edge(0, 1, 5));
        adjList[1].add(new Edge(1, 0, 5));
        adjList[1].add(new Edge(1, 2, 1));
        adjList[1].add(new Edge(1, 3, 3));

        adjList[2].add(new Edge(2, 1, 1));
        adjList[2].add(new Edge(2, 3, 1));
        adjList[2].add(new Edge(2, 4, 2));

        adjList[3].add(new Edge(3, 1, 3));
        adjList[3].add(new Edge(3, 2, 1));

        adjList[4].add(new Edge(4, 2, 2));

        for (int i = 0; i < adjList[2].size(); i++) {
            System.out.println(adjList[2].get(i).destination);
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