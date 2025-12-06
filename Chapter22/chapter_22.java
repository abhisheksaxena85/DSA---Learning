/*
 * Starting Graphs
 * Start Date - Sep 28 2025, 10:03 PM
 */

import java.util.*;

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

        // ArrayList<Edge> graph[] = new ArrayList[6];

        // for (int i = 0; i < graph.length; i++) {
        // graph[i] = new ArrayList<>();
        // }

        // Add edges for an undirected graph (example)
        // graph[0].add(new Edge(0, 1, 2));
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));

        // int col[] = new int[graph.length];
        // for (int i = 0; i < col.length; i++) {
        // col[i] = -1;
        // }
        // System.out.println(biPart(graph, col));
        // System.out.println(hasCycleDirected(graph));
        // topologicalSort(graph);
        // topologicalSortBFS(graph);
        // allPaths(graph, 5, 1, "");
        // dijkstraAlgo(graph, 0);

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[5];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));

        bellmanFordAlgo(graph, 0);

    }

    public static void bellmanFordAlgo(ArrayList<Edge> graph[], int src) {
        int weight[] = new int[graph.length];
        for (int i = 0; i < weight.length; i++) {
            if (i != src) {
                weight[i] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < graph.length - 1; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    if (weight[e.source] != Integer.MAX_VALUE
                            && (weight[e.source] + e.weight) < weight[e.destination]) {
                        weight[e.destination] = weight[e.source] + e.weight;
                    }
                }
            }
        }

        for (int i = 0; i < weight.length; i++) {
            System.out.println(weight[i]);
        }
    }

    static class GraphNode implements Comparable<GraphNode> {
        int index;
        int pathVal;

        GraphNode(int index, int pathVal) {
            this.pathVal = pathVal;
            this.index = index;
        }

        @Override
        public int compareTo(GraphNode node) {
            return this.pathVal - node.pathVal;
        }
    }

    public static void dijkstraAlgo(ArrayList<Edge> graph[], int src) {

        int weight[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];

        for (int i = 1; i < weight.length; i++) {
            if (i != src) {
                weight[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(src, 0));

        while (!pq.isEmpty()) {
            GraphNode node = pq.remove();
            if (!vis[node.index]) {
                vis[node.index] = true;
                for (int i = 0; i < graph[node.index].size(); i++) {
                    Edge e = graph[node.index].get(i);
                    if (weight[e.source] + e.weight < weight[e.destination]) {
                        weight[e.destination] = weight[node.index] + e.weight;
                        pq.add(new GraphNode(e.destination, weight[e.destination]));
                    }
                }
            }
        }

        for (int i = 0; i < weight.length; i++) {
            System.out.println(weight[i]);
        }
    }

    public static void allPaths(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPaths(graph, e.destination, dest, path + e.source);
        }
    }

    // public static void topologicalSortBFS(ArrayList<Edge> graph[]) {
    // int inEd[] = new int[graph.length];
    // for (int i = 0; i < inEd.length; i++) {
    // for (int j = 0; j < graph[i].size(); j++) {
    // Edge e = graph[i].get(j);
    // inEd[e.destination]++;
    // }
    // }

    // Queue<Integer> q = new LinkedList<>();

    // for (int i = 0; i < inEd.length; i++) {
    // if (inEd[i] == 0) {
    // q.add(i);
    // }
    // }

    // while (!q.isEmpty()) {
    // int val = q.remove();
    // System.out.println(val);
    // for (int i = 0; i < graph[val].size(); i++) {
    // Edge e = graph[val].get(i);
    // inEd[e.destination]--;
    // if (inEd[e.destination] == 0) {
    // q.add(e.destination);
    // }
    // }
    // }
    // }

    // public static void topologicalSort(ArrayList<Edge> graph[]) {
    // boolean vis[] = new boolean[graph.length];
    // Stack<Integer> stack = new Stack<>();

    // for (int i = 0; i < graph.length; i++) {
    // if (!vis[i]) {
    // topSort(graph, i, vis, stack);
    // }
    // }

    // while (!stack.isEmpty()) {
    // System.out.println(stack.pop());
    // }
    // }

    // public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[],
    // Stack<Integer> stack) {
    // vis[curr] = true;
    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // if (!vis[e.destination]) {
    // topSort(graph, e.destination, vis, stack);
    // }
    // }
    // stack.push(curr);
    // }

    // public static boolean hasCycleDirected(ArrayList<Edge> graph[]) {
    // boolean vis[] = new boolean[graph.length];
    // boolean stack[] = new boolean[graph.length];

    // for (int i = 0; i < graph.length; i++) {
    // if (!vis[i]) {
    // if (hasCycleDirectedUtil(graph, i, vis, stack)) {
    // return true;
    // }
    // }
    // }
    // return false;
    // }

    // public static boolean hasCycleDirectedUtil(ArrayList<Edge> graph[], int curr,
    // boolean vis[], boolean stack[]) {
    // vis[curr] = true;
    // stack[curr] = true;

    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // if (stack[e.destination]) {
    // return true;
    // }
    // if (!stack[e.destination] && hasCycleDirectedUtil(graph, e.destination, vis,
    // stack)) {
    // return true;
    // }
    // }
    // stack[curr] = false;
    // return false;
    // }

    // public static boolean biPart(ArrayList<Edge> graph[], int col[]) {
    // for (int i = 0; i < graph.length; i++) {
    // if (col[i] == -1) {
    // if (!isBiPartite(graph, col, i)) {
    // return false;
    // }
    // }
    // }
    // return true;
    // }

    // public static boolean isBiPartite(ArrayList<Edge> graph[], int col[], int
    // vertex) {
    // Queue<Integer> q = new LinkedList<>();
    // col[vertex] = 0;
    // q.add(vertex);
    // while (!q.isEmpty()) {
    // int val = q.remove();
    // for (int i = 0; i < graph[val].size(); i++) {
    // Edge e = graph[val].get(i);
    // if (col[e.destination] == -1) {
    // col[e.destination] = col[val] == 0 ? 1 : 0;
    // q.add(e.destination);
    // } else if (col[e.destination] == col[val]) {
    // return false;
    // }
    // }
    // }
    // return true;
    // }

    // public static boolean hasCycle(ArrayList<Edge>[] adjList) {
    // boolean visited[] = new boolean[adjList.length];
    // for (int i = 0; i < adjList.length; i++) {
    // if (!visited[i]) {
    // if (hashCycleUtil(adjList, i, -1, visited)) {
    // return true;
    // }
    // }
    // }
    // return false;
    // }

    // public static boolean hasPath(ArrayList<Edge> arr[], int src, int dst,
    // boolean visited[]) {
    // if (src == dst)
    // return true;

    // visited[src] = true;
    // for (int i = 0; i < arr[src].size(); i++) {
    // Edge e = arr[src].get(i);
    // if (!visited[e.destination] && hasPath(arr, e.destination, dst, visited)) {
    // return true;
    // }
    // }
    // return false;

    // }

    // /// Depth First Search - Graph Traversal
    // public static boolean hashCycleUtil(ArrayList<Edge>[] arr, int curr, int par,
    // boolean visited[]) {
    // visited[curr] = true;

    // for (int i = 0; i < arr[curr].size(); i++) {
    // Edge e = arr[curr].get(i);

    // if (visited[e.destination] && curr != par) {
    // return true;
    // } else if (!visited[e.destination]) {
    // if (hashCycleUtil(arr, e.destination, curr, visited)) {
    // return true;
    // }
    // }
    // }
    // return false;
    // }

    // public static void bfs(ArrayList<Edge>[] adjList, boolean[] visited, int
    // start) {
    // Queue<Integer> q = new LinkedList<>();
    // q.add(start);

    // while (!q.isEmpty()) {
    // int val = q.remove();
    // if (visited[val] == false) {
    // System.out.println(val);
    // for (int i = 0; i < adjList[val].size(); i++) {
    // q.add(adjList[val].get(i).destination);
    // }
    // visited[val] = true;
    // }
    // }
    // }

    static class Edge {
        int source, destination, weight;

        public Edge(int s, int d, int w) {
            this.weight = w;
            this.source = s;
            this.destination = d;
        }
    }
}