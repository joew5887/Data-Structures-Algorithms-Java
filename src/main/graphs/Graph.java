package main.graphs;

import java.util.Map;
import java.util.HashMap;
import main.linear.Queue;
import main.linear.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Vertex o2 = (Vertex) o;
        return label == o2.label;
    }
}

public class Graph {
    private int adjMatrix[][];
    private Map<Integer, LinkedList<Integer>> adjList;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
        adjList = new HashMap<Integer, LinkedList<Integer>>();

        for (int i = 0; i < numVertices; i++) {
            adjList.put(i, new LinkedList<Integer>());
        }
    }

    public void draw() {
        return;
    }

    public int getEdge(int from, int to) {
        return adjMatrix[from][to];
    }

    public void setEdge(int from, int to, int value) {
        adjMatrix[from][to] = value;
    }

    public void addEdge(int from, int to, int value) {
        adjMatrix[from][to] = value;

        adjList.get(from).add(to);
    }

    public void removeEdge(int from, int to) {
        adjMatrix[from][to] = 0;

        adjList.get(from).remove(to);
    }

    public LinkedList<Integer> getAdjVertices(int vertex) {
        return adjList.get(vertex);
    }

    // https://www.programiz.com/dsa/graph-adjacency-matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j : adjMatrix[i]) {
                if (j > 0) {
                    s.append(j + " ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void traverseDepthFirst(int rootNode) {
        Stack collection = new Stack();
        boolean visited[] = new boolean[numVertices];

        collection.add(rootNode);

        while (collection.isEmpty() == false) {
            int curr = collection.get();

            if (visited[curr] == false) {
                visited[curr] = true;
            }

            for (int dst : getAdjVertices(curr)) {
                if (visited[dst] == false) {
                    collection.add(dst);
                }
            }
            System.out.print(curr + " "); // action on visited
        }
        System.out.println("\n");
    }

    public void traverseBreadthFirst(int rootNode) {
        Queue collection = new Queue();
        boolean visited[] = new boolean[numVertices];

        collection.add(rootNode);

        while (collection.isEmpty() == false) {
            int curr = collection.get();

            if (visited[curr] == false) {
                visited[curr] = true;
            }

            for (int dst : getAdjVertices(curr)) {
                if (visited[dst] == false) {
                    collection.add(dst);
                }
            }
            System.out.print(curr + " "); // action on visited
        }
        System.out.println("\n");
    }

    public int[][] useFloydWarshallAlgorithm() {
        int[][] out = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if ((getEdge(i, j) == 0) && (i != j)) {
                    out[i][j] = 10000000;
                } else {
                    out[i][j] = getEdge(i, j);
                }
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (out[i][k] + out[k][j] < out[i][j])
                        out[i][j] = out[i][k] + out[k][j];
                }
            }
        }

        return out;
    }

    public static void main(String[] args) throws Exception {
        Graph x = new Graph(6);
        x.addEdge(0, 1, 1);
        x.addEdge(0, 2, 1);
        x.addEdge(1, 3, 1);
        x.addEdge(1, 4, 1);
        x.addEdge(2, 5, 1);
        // System.out.println(x);
        x.traverseBreadthFirst(0);
        x.traverseDepthFirst(0);
        System.out.println(Arrays.deepToString(x.useFloydWarshallAlgorithm()));
    }
}
