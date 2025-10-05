/*
 * Starting Graphs
 * Start Date - Sep 28 2025, 10:03 PM
 */

import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

class chapter_22 {
    public static void main(String a[]) {
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> adjList[] = new ArrayList[7];
        // for (int i = 0; i < adjList.length; i++) {
        // adjList[i] = new ArrayList<>();
        // }

        // adjList[0].add(new Edge(0, 1, 1));
        // adjList[0].add(new Edge(0, 2, 1));
        // adjList[1].add(new Edge(1, 0, 1));
        // adjList[1].add(new Edge(1, 3, 1));

        // adjList[2].add(new Edge(2, 0, 1));
        // adjList[2].add(new Edge(2, 4, 1));
        // adjList[2].add(new Edge(2, 3, 1));

        // adjList[3].add(new Edge(3, 1, 1));
        // adjList[3].add(new Edge(3, 5, 1));
        // adjList[3].add(new Edge(3, 6, 1));

        // adjList[4].add(new Edge(4, 2, 1));
        // adjList[4].add(new Edge(4, 3, 1));
        // adjList[4].add(new Edge(4, 5, 1));

        // adjList[5].add(new Edge(5, 3, 1));
        // adjList[5].add(new Edge(5, 4, 1));
        // adjList[5].add(new Edge(5, 6, 1));

        // adjList[6].add(new Edge(6, 5, 1));

        // System.out.println(hasPath(adjList, 0, 12, new boolean[7]));
        // boolean visited[] = new boolean[adjList.length];
        // for (int i = 0; i < adjList.length; i++) {
        // if (!visited[i]) {
        // bfs(adjList, visited, i);
        // }
        // }

        // System.out.println(hasCycle(adjList));

        ArrayList<Edge> graph[] = new ArrayList[5];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges for an undirected graph (example)
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));

        int col[] = new int[graph.length];

        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        System.out.println(biPart(graph, col));
    }

    public static boolean biPart(ArrayList<Edge> graph[], int col[]) {
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                if (!isBiPartite(graph, col, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBiPartite(ArrayList<Edge> graph[], int col[], int vertex) {
        Queue<Integer> q = new LinkedList<>();
        col[vertex] = 0;
        q.add(vertex);
        while (!q.isEmpty()) {
            int val = q.remove();

            for (int i = 0; i < graph[val].size(); i++) {
                Edge e = graph[val].get(i);
                if (col[e.destination] == -1) {
                    col[e.destination] = col[val] == 0 ? 1 : 0;
                    q.add(e.destination);
                } else if (col[e.destination] == col[val]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasCycle(ArrayList<Edge>[] adjList) {
        boolean visited[] = new boolean[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i]) {
                if (hashCycleUtil(adjList, i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPath(ArrayList<Edge> arr[], int src, int dst, boolean visited[]) {
        if (src == dst)
            return true;

        visited[src] = true;
        for (int i = 0; i < arr[src].size(); i++) {
            Edge e = arr[src].get(i);
            if (!visited[e.destination] && hasPath(arr, e.destination, dst, visited)) {
                return true;
            }
        }
        return false;

    }

    /// Depth First Search - Graph Traversal
    public static boolean hashCycleUtil(ArrayList<Edge>[] arr, int curr, int par, boolean visited[]) {
        visited[curr] = true;

        for (int i = 0; i < arr[curr].size(); i++) {
            Edge e = arr[curr].get(i);

            if (visited[e.destination] && curr != par) {
                return true;
            } else if (!visited[e.destination]) {
                if (hashCycleUtil(arr, e.destination, curr, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void bfs(ArrayList<Edge>[] adjList, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

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