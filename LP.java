
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Vertex {
    private int v;
    private int weightToV;

    public Vertex(int v, int weightToReachVertex) {
        this.v = v;
        this.weightToV = weightToReachVertex;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getWeightToV() {
        return weightToV;
    }

    public void setWeightToV(int weightToReachVertex) {
        this.weightToV = weightToReachVertex;
    }

    @Override
    public String toString() {
        return v + " : " + weightToV;
    }

}

class DirectedWeightedGraph {

    private int vertices;
    private Map<Integer, ArrayList<Vertex>> adjList;

    /**
     * Graph methods
     */
    public DirectedWeightedGraph(int vertices) {
        this.vertices = vertices;
        adjList = new HashMap<>();
        for (int i = 1; i <= vertices; i++) {
            adjList.put(i, new ArrayList<Vertex>());
        }
    }

    public void addEdge(int src, int dest, int weightSrcToDest) {
        adjList.get(src).add(new Vertex(dest, weightSrcToDest));
    }

    public boolean hasEdge(int src, int dest) {
        ArrayList<Vertex> temp = adjList.get(src);
        for (Vertex vertex : temp) {
            if (vertex.getV() == dest) {
                return true;
            }
        }
        return false;
    }

    public void printGraph() {
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + " -> ");
            System.out.println(adjList.get(i));
        }
        System.out.println();
    }

    /**
     * Graph methods over
     */

    /**
     * Longest Path from Source to all other vertices in DAG
     */
    public void getLongestPathFromSourceToAllVertices(int source) {
        int[] distanceTo = new int[vertices + 1];
        Arrays.fill(distanceTo, Integer.MIN_VALUE);
        distanceTo[source] = 0;
        // Sort the vertices in topological order
        Stack<Integer> stack = topologicalSort();
        // Compute the distance from
        calculateMaximumDistanceForEachVertex(stack, distanceTo);
        printLongestDistance(distanceTo);
    }

    private void printLongestDistance(int[] distanceTo) {
        for (int i = 1; i <= vertices; i++) {
            System.out.println("Distance to " + i + " is: " + distanceTo[i]);
        }
        System.out.println();
    }

    private void calculateMaximumDistanceForEachVertex(Stack<Integer> stack, int[] distanceTo) {
        while (!stack.isEmpty()) {
            int currentV = stack.pop();
            if (distanceTo[currentV] != Integer.MIN_VALUE) {
                for (Vertex neighborOfVertex : adjList.get(currentV)) {
                    int v = neighborOfVertex.getV();
                    if (distanceTo[v] < distanceTo[currentV] + neighborOfVertex.getWeightToV()) {
                        distanceTo[v] = distanceTo[currentV] + neighborOfVertex.getWeightToV();
                    }
                }
            }
        }
    }

    /**
     * TopologicalSort https://w...content-available-to-author-only...s.org/topological-sorting/
     * https://w...content-available-to-author-only...e.com/watch?v=ddTC4Zovtbc
     */
    public Stack<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[vertices + 1];
        for (Integer vertex : adjList.keySet()) {
            if (!isVisited[vertex]) {
                topologicalSortUtil(vertex, isVisited, stack);
            }
        }

        return stack;
    }

    private void topologicalSortUtil(Integer vertex, boolean[] isVisited, Stack<Integer> stack) {
        isVisited[vertex] = true;
        for (Vertex neighbor : adjList.get(vertex)) {
            if (!isVisited[neighbor.getV()]) {
                topologicalSortUtil(neighbor.getV(), isVisited, stack);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args) {
        DirectedWeightedGraph g = new DirectedWeightedGraph(6);
        g.addEdge(1, 2, 5);
        g.addEdge(1, 3, 3);
        g.addEdge(2, 4, 6);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 5, 4);
        g.addEdge(3, 6, 2);
        g.addEdge(3, 4, 7);
        g.addEdge(4, 6, 1);
        g.addEdge(4, 5, -1);
        g.addEdge(5, 6, -2);
        g.printGraph();
        Stack<Integer> stack = g.topologicalSort();
        //System.out.println(stack);
        g.getLongestPathFromSourceToAllVertices(1);
    }

}
