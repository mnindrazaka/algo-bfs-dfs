import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Integer>> adjList;

    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge.destination);
            adjList.get(edge.destination).add(edge.source);
        }
    }
}
