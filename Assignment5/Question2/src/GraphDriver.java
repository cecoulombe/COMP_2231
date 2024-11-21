/* Author: Caitlin Coulombe, T00756521
 * Date: November 19, 2024
 * Course: COMP 2231
 * Assignment 5, Question 2: PP 24.3 (pg. 902) Complete the implementation of Graph.java using an adjacency matrix 
 * that was presented in this chapter. Show test cases for all implemented methods, being sure to test all edge 
 * cases where possible.
 * 
 * Hint: Identify all of the missing implementations in Graph.java before you start. Some methods like size() and 
 * getIndex(T vertex) should be tackled first.
 */

import java.util.Arrays;

public class GraphDriver {
    public static void main(String[] args) throws Exception {
        // each of the following need to be completed (must showcase the functionality and edge cases for all of these)
            // for all remove, test that its a valid and invalid index or vertex
            // removeEdge(T vertex1, T vertex2)
            // removeEdge(int index1, int index2)
            // addVertex()
            // removeVertex(T vertex)
            // removeVertex(int index)
            // size()   empty, not empty
            // isEmpty()     true, false
            // isConnected()    true, false
            // getIndex(T vertex)   valid vertex, invalid vertex
            // indexIsValid(int index)  middle, max, above, below
            // getVertices()    empty vertices, not empty,              modify the vertices list and then call it again to show that its getting a copy

        // create an integer graph and populate it with some elements per the already existing methods.
        Graph<String> graph = new Graph<>();

        // populate the graph using existing addVertex(vertex) and addEdge(vertex1, vertex2) methods
        System.out.println("***** Testing Empty(), Size(), getVertices() on an graph when empty and when populated *****");
        System.out.println("Empty() before adding vertices: " + graph.isEmpty());
        System.out.println("Size() before adding vertices: " + graph.size());
        System.out.println("Current list of vertices: " + Arrays.toString(graph.getVertices()));
        System.out.println("Adding four vertices: A, B, C, and D.");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        System.out.println("Empty() after adding vertices: " + graph.isEmpty());
        System.out.println("Size() after adding vertices: " + graph.size());
        System.out.println("Current list of vertices: " + Arrays.toString(graph.getVertices()));
        System.out.println();

        // test modifying getVertices
        System.out.println("***** Showing that getVertices returns a copy, not the original array. *****");
        Object[] arr = graph.getVertices();
        System.out.println("Initial call to getVertices, stored in arr: " + Arrays.toString(arr));
        arr[0] = 'Z';
        System.out.println("Modified arr: " + Arrays.toString(arr));
        arr = graph.getVertices();
        System.out.println("Re-calling getVertices, stored in arr: " + Arrays.toString(arr));
        System.out.println();

        // add edges using existing method addEdge(vertex1, vertex2) and create a connected graph
        System.out.println("***** Test isConnected() *****");
        System.out.println("Adjacecy matrix before adding edges: \n" + graph.toString());
        System.out.println("isConnected() before adding edges: " + graph.isConnected());
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        System.out.println("Adjacecy matrix after adding edges: \n" + graph.toString());
        System.out.println("isConnected() after adding edges: " + graph.isConnected());
        System.out.println();

        // test removeEdge(vertex1, vertex2) functionality
        System.out.println("***** test removeEdge(vertex1, vertex2) *****");
        System.out.println("Is graph connected before removing edge? " + graph.isConnected());
        graph.removeEdge("A", "B");
        System.out.println("Adjacecy matrix after removal: \n" + graph.toString());
        System.out.println("Is graph connected after removing edge? " + graph.isConnected());
        System.out.println("Reconnecting the graph");
        graph.addEdge("A", "B");
        System.out.println();

        // testing getIndex
        System.out.println("***** test getIndex() *****");
        int index1 = graph.getIndex("A");
        int index2 = graph.getIndex("B");
        System.out.println("The index of vertex 'A' using getIndex('A') is: " + index1);
        System.out.println("The index of vertex 'Z' (invalid vertex) is " + graph.getIndex("Z"));
        System.out.println();

        // test removeEdge(index1, index2)
        System.out.println("***** test removeEdge(vertex1, vertex2) *****");
        System.out.println("Is graph connected before removing edge? " + graph.isConnected());
        graph.removeEdge(index1, index2);
        System.out.println("Adjacecy matrix after removal: \n" + graph.toString());
        System.out.println("Is graph connected after removing edge? " + graph.isConnected());
        System.out.println();

        // test indexIsValid
        System.out.println("***** test indexIsValid() *****");
        System.out.println("testing indexIsValid() with a valid index (1): " + graph.indexIsValid(1));
        System.out.println("testing indexIsValid() with a valid index (max value (size() - 1)): " + graph.indexIsValid(graph.size() - 1));
        System.out.println("testing indexIsValid() with an invalid index (over max value (size())): " + graph.indexIsValid(graph.size()));
        System.out.println("testing indexIsValid() with an invalid index (-1): " + graph.indexIsValid(-1));
        System.out.println();

        // test removeVertex(vertex)
        System.out.println("***** test removeVertex(vertex)  *****");
        System.out.println("Vertices before the removal of B: " + Arrays.toString(graph.getVertices()));
        graph.removeVertex("B");
        System.out.println("Vertices after the removal: " + Arrays.toString(graph.getVertices()));
        System.out.println("Attempting an invalid vertex (Z)");
        graph.removeVertex("Z");
        System.out.println("Vertices after the attempted removal: " + Arrays.toString(graph.getVertices()));
        System.out.println();

        // test removeVertex(index)
        System.out.println("***** test removeVertex(index)  *****");
        System.out.println("Vertices before the removal of index 0: " + Arrays.toString(graph.getVertices()));
        graph.removeVertex(0);
        System.out.println("Vertices after the removal: " + Arrays.toString(graph.getVertices()));
        System.out.println("Attempting an invalid index (99)");
        graph.removeVertex(99);
        System.out.println("Vertices after the attempted removal: " + Arrays.toString(graph.getVertices()));
        System.out.println();

        // test removeVertex(vertex) and removeVertex(index) on an empty array
        System.out.println("***** test removeVertex(vertex) and removeVertex(index) on an empty graph (will throw exceptions)  *****");
        System.out.println("Emptying the array to test removal on an empty array");
        graph.removeVertex("C");
        graph.removeVertex("D");
        System.out.println("Graph size after removal: " + graph.size());
        try {
            graph.removeVertex("A");
        } catch (Exception e) {
            System.out.println("removeVertex(A) : " + e);
        }
        try {
            graph.removeVertex(0);
        } catch (Exception e) {
            System.out.println("removeVertex(0) : " + e);
        }
        System.out.println();

        // test isConnected on empty
        System.out.println("***** test isConnected on an empty graph *****");
        System.out.println("Is the graph currently empty? " + graph.isEmpty());
        System.out.println("Is an empty graph connected? " + graph.isConnected());
        System.out.println();
        
        // test addVertex()
        System.out.println("***** test addVertex() with no parameter *****");
        System.out.println("Graph size before using addVertex() with no associated object: " + graph.size());
        graph.addVertex();
        System.out.println("Is the graph empty after addVertex? " + graph.isEmpty());
        System.out.println("Graph size after using addVertex() with no associated object: " + graph.size());
        System.out.println("The current adjacency matrix: \n" + graph.toString());
        System.out.println();
    }
}
