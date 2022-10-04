import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5),
                new Edge(2, 6), new Edge(5, 9), new Edge(5, 10), new Edge(4, 7),
                new Edge(4, 8), new Edge(7, 11), new Edge(7, 12)
                // vertex 0, 13, and 14 are single nodes
        );

        // total number of nodes in the graph (labelled from 0 to 14)
        int n = 15;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];

        // Perform BFS traversal from all undiscovered nodes to
        // cover all connected components of a graph
        for (int i = 0; i < n; i++) {
            if (discovered[i] == false) {
                DFS(graph, i, discovered);
            }
        }
    }

    public static void BFS(Graph graph, int v, boolean[] discovered) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(v);
        discovered[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            v = queue.poll();

            for (int u : graph.adjList.get(v)) {
                if (!discovered[u]) {
                    discovered[u] = true;
                    queue.add(u);
                    System.out.print(u + " ");
                }
            }
        }
    }

    public static void DFS(Graph graph, int v, boolean[] discovered) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();
            System.out.print(v + " ");
            discovered[v] = true;

            for (int i = graph.adjList.get(v).size() - 1; i >= 0; i--) {
                int u = graph.adjList.get(v).get(i);
                if (!discovered[u]) {
                    stack.push(u);
                }
            }
        }
    }
}