/* Author: Caitlin Coulombe, T00756521
 * Date: November 19, 2024
 * Course: COMP 2231
 * Assignment 5, Question 2: PP 24.3 (pg. 902) Complete the implementation of Graph.java using an adjacency matrix 
 * that was presented in this chapter. Show test cases for all implemented methods, being sure to test all edge 
 * cases where possible.
 * 
 * Hint: Identify all of the missing implementations in Graph.java before you start. Some methods like size() and 
 * getIndex(T vertex) should be tackled first.
 * 
 * The following methods were implemented by me:
        // removeEdge(T vertex1, T vertex2)
        // removeEdge(int index1, int index2)
        // addVertex() --> not sure why
        // removeVertex(T vertex)
        // removeVertex(int index)
        // size() 
        // isEmpty() 
        // isConnected()
        // getIndex(T vertex) 
        // indexIsValid(int index) 
            // getVertices()
 */


import jsjf.ArrayUnorderedList;
import jsjf.GraphADT;
import jsjf.LinkedQueue;
import jsjf.LinkedStack;
import jsjf.QueueADT;
import jsjf.StackADT;
import jsjf.UnorderedListADT;
import jsjf.exceptions.*;
import java.util.*;

/**
 * Graph represents an adjacency matrix implementation of a graph.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Graph<T> implements GraphADT<T>
{
    protected final int DEFAULT_CAPACITY = 5;
    protected int numVertices;    // number of vertices in the graph
    protected boolean[][] adjMatrix;    // adjacency matrix
    protected T[] vertices;    // values of vertices
    protected int modCount;

    /**
     * Creates an empty graph.
     */
    @SuppressWarnings("unchecked")
    public Graph()
    {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1  the first vertex
     * @param vertex2  the second vertex
     */
    public void addEdge(T vertex1, T vertex2)
    {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1  the first index
     * @param index2  the second index
     */
    public void addEdge(int index1, int index2)
    {
        if (indexIsValid(index1) && indexIsValid(index2))
        {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
            modCount++;
        }
    }

    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param vertex1  the first vertex
     * @param vertex2  the second vertex
     */
    public void removeEdge(T vertex1, T vertex2)
    {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param index1  the first index
     * @param index2  the second index
     */
    public void removeEdge(int index1, int index2)
    {
        if(indexIsValid(index1) && indexIsValid(index2))
        {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
            modCount++;
        }
    }

    /**
    * Adds a vertex to the graph, expanding the capacity of the graph
    * if necessary. This method creates a placeholder vertex when no 
    * specific vertex is provided.
    */
    public void addVertex()
    {
        // If needed, expand the capacity of the graph to accommodate another vertex
        if ((numVertices + 1) == adjMatrix.length) {
            expandCapacity();
        }

        // Create a placeholder vertex (this is a generic placeholder, could be improved based on the graph's T type)
        @SuppressWarnings("unchecked")
        T placeholderVertex = (T) "";  // Placeholder, you can customize this based on the type T

        // Assign the placeholder vertex to the graph
        vertices[numVertices] = placeholderVertex;

        // Initialize the adjacency matrix for this new vertex
        for (int i = 0; i < numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }

        // Increment the number of vertices
        numVertices++;
        modCount++;
    }


    /**
     * Adds a vertex to the graph, expanding the capacity of the graph
     * if necessary.  It also associates an object with the vertex.
     *
     * @param vertex  the vertex to add to the graph
     */
    public void addVertex(T vertex)
    {        
        if ((numVertices + 1) == adjMatrix.length)
            expandCapacity();

        vertices[numVertices] = vertex;
        for (int i = 0; i < numVertices; i++)
        {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }        
        numVertices++;
        modCount++;
    }

    /**
     * Removes a single vertex with the given value from the graph.  
     *
     * @param vertex  the vertex to be removed from the graph
     */
    public void removeVertex(T vertex)
    {
        if(numVertices == 0)
        {
            throw new EmptyCollectionException("graph");
        }
        removeVertex(getIndex(vertex));
    }

    /**
     * Removes a vertex at the given index from the graph.  Note that 
     * this may affect the index values of other vertices.
     *
     * @param index  the index at which the vertex is to be removed from
     */
    public void removeVertex(int index)
    {
        if(numVertices == 0)
        {
            throw new EmptyCollectionException("graph");
        }
        
        // check that the index is valid
        if(!indexIsValid(index))
        {
            return;
        }

        // remove the corresponding edges
        for(int i = 0; i < numVertices; i++)
        {
            adjMatrix[index][i] = false;
            adjMatrix[i][index] = false;
        }

        // shift the vertices within the array
        for(int i = index; i < numVertices - 1; i++)
        {
            vertices[i] = vertices[i + 1];
        }

        // clear the last vertex to avoid stale references
        vertices[numVertices - 1] = null;

        // ensure edges are accurate
        for(int i = index; i < numVertices - 1; i++)
        {
            for(int j = 0; j < numVertices; j++)
            {
                adjMatrix[i][j] = adjMatrix[i + 1][j];  // shift row up
                adjMatrix[j][i] = adjMatrix[j][i + 1];  // shift columns left
            }
        }

        numVertices--;
        modCount++;

    }

    /**
     * Returns an iterator that performs a depth first traversal 
     * starting at the given index.
     *
     * @param startIndex the index from which to begin the traversal
     * @return an iterator that performs a depth first traversal
     */
    public Iterator<T> iteratorDFS(int startIndex)
    {
        Integer x;
        boolean found;
        StackADT<Integer> traversalStack = new LinkedStack<Integer>();
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex))
            return resultList.iterator();

        for (int i = 0; i < numVertices; i++)
            visited[i] = false;
        
        traversalStack.push(startIndex);
        // System.out.println("Initial stack: " + traversalStack);  // Debugging line

        resultList.addToRear(vertices[startIndex]);
        // System.out.println("Starting DFS with: " + vertices[startIndex]);  // Debugging line

        visited[startIndex] = true;
        
        while (!traversalStack.isEmpty())
        {
            // System.out.println("Stack at start of loop: " + traversalStack);  // Debugging line inside loop

            x = traversalStack.peek();
            found = false;

            //  Find a vertex adjacent to x that has not been visited
            //  and push it on the stack 
            // for (int i = 0; (i < numVertices) && !found; i++)
            // {
            //     if (adjMatrix[x.intValue()][i] && !visited[i])
            //     {
            //         traversalStack.push(i);
            //         resultList.addToRear(vertices[i]);
            //         visited[i] = true;
            //         found = true;
            //     }
            // }
            for (int i = 0; (i < numVertices) && !found; i++) {
                // System.out.println("Checking adjacency: " + x + " -> " + i + " = " + adjMatrix[x.intValue()][i]);
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalStack.push(i);
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    // System.out.println("Visiting: " + vertices[i]);
                    found = true;
                }
                // System.out.println("Visited array: " + Arrays.toString(visited));  // Debugging line
            }
            if (!found && !traversalStack.isEmpty())
                traversalStack.pop();
        }
        // System.out.println("Result list: " + resultList);  // Debugging line before returning iterator

        return new GraphIterator(resultList.iterator());
    }

    /**
     * Returns an iterator that performs a depth first search 
     * traversal starting at the given vertex.
     *
     * @param startVertex the vertex to begin the search from
     * @return an iterator that performs a depth first traversal
     */
    public Iterator<T> iteratorDFS(T startVertex)
    {        
        return iteratorDFS(getIndex(startVertex));
    }

    /**
     * Returns an iterator that performs a breadth first  
     * traversal starting at the given index.
     *
     * @param startIndex the index from which to begin the traversal
     * @return an iterator that performs a breadth first traversal
     */
    public Iterator<T> iteratorBFS(int startIndex)
    {
        Integer x;
        QueueADT<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();

        if (!indexIsValid(startIndex))
            return resultList.iterator();

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;
        
        traversalQueue.enqueue(startIndex);
        visited[startIndex] = true;
        
        while (!traversalQueue.isEmpty())
        {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);

            //  Find all vertices adjacent to x that have not been visited
            //  and queue them up 
            
            for (int i = 0; i < numVertices; i++)
            {
                if (adjMatrix[x.intValue()][i] && !visited[i])
                {
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        return new GraphIterator(resultList.iterator());
    }
    
    /**
     * Returns an iterator that performs a breadth first search 
     * traversal starting at the given vertex.
     *
     * @param startVertex the vertex to begin the search from
     * @return an iterator that performs a breadth first traversal
     */
    public Iterator<T> iteratorBFS(T startVertex)
    {        
        return iteratorBFS(getIndex(startVertex));
    }

    /**
     * Returns an iterator that contains the indices of the vertices 
     * that are in the shortest path between the two given vertices.
     *
     * @param startIndex the starting index
     * @param targetIndex the the target index
     * @return the an iterator containing the indices of the 
     *               of the vertices making the shortest path between
     *               the given indices
     */
    protected Iterator<Integer> iteratorShortestPathIndices
                                        (int startIndex, int targetIndex)
    {
        int index = startIndex;
        int[] pathLength = new int[numVertices];
        int[] predecessor = new int[numVertices];
        QueueADT<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedListADT<Integer> resultList = 
                                             new ArrayUnorderedList<Integer>();

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || 
                                                    (startIndex == targetIndex))
            return resultList.iterator();

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;
        
        traversalQueue.enqueue(startIndex);
        visited[startIndex] = true;
        pathLength[startIndex] = 0;
        predecessor[startIndex] = -1;

        while (!traversalQueue.isEmpty() && (index != targetIndex))
        {
            index = (traversalQueue.dequeue()).intValue();

            //Update the pathLength for each unvisited vertex adjacent 
            //     to the vertex at the current index. 
            for (int i = 0; i < numVertices; i++)
            {
                if (adjMatrix[index][i] && !visited[i])
                {
                    pathLength[i] = pathLength[index] + 1;
                    predecessor[i] = index;
                    traversalQueue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
        if (index != targetIndex)  // no path must have been found
            return resultList.iterator();

        StackADT<Integer> stack = new LinkedStack<Integer>();
        index = targetIndex;
        stack.push(index);
        do
        {
            index = predecessor[index];
            stack.push(index);
        } while (index != startIndex);
        
        while (!stack.isEmpty())
            resultList.addToRear(((Integer)stack.pop()));

        return new GraphIndexIterator(resultList.iterator());
    }

    /**
     * Returns an iterator that contains the shortest path between
     * the two vertices.
     *
     * @param startIndex the starting index
     * @param targetIndex the target index
     * @return an iterator that contains the shortest path
     *           between the given vertices
     */
    public Iterator<T> iteratorShortestPath(int startIndex, 
                                                         int targetIndex)
    {
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
            return resultList.iterator();

        Iterator<Integer> it = iteratorShortestPathIndices(startIndex, 
                                      targetIndex);        
        while (it.hasNext())
            resultList.addToRear(vertices[((Integer)it.next()).intValue()]);
        return new GraphIterator(resultList.iterator());
    }

    /**
     * Returns an iterator that contains the shortest path between
     * the two vertices.
     *
     * @param startVertex the starting vertex
     * @param targetVertex the target vertex
     * @return an iterator that contains the shortest path between
     *         the given vertices
     */
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex)
    {
        return iteratorShortestPath(getIndex(startVertex), 
                                             getIndex(targetVertex));
    }

    /**
     * Returns the weight of the least weight path in the network.  
     * Returns positive infinity if no path is found.
     *
     * @param startIndex the starting index
     * @param targetIndex the target index
     * @return the integer weight of the least weight path
     *                in the network
     */
    public int shortestPathLength(int startIndex, int targetIndex)
    {
        int result = 0;
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
            return 0;

        int index1, index2;
        Iterator<Integer> it = iteratorShortestPathIndices(startIndex, 
                                      targetIndex);

        if (it.hasNext())
            index1 = ((Integer)it.next()).intValue();
        else
            return 0;

        while (it.hasNext())
        {
            result++;
            it.next();
        }
        
        return result;
    }

    /**
     * Returns the weight of the least weight path in the network.  
     * Returns positive infinity if no path is found.
     *
     * @param startVertex the starting vertex
     * @param targetVertex the target vertex
     * @return the integer weight of the least weight path
     *            in the network
     */
    public int shortestPathLength(T startVertex, T targetVertex)
    {
        return shortestPathLength(getIndex(startVertex), getIndex(targetVertex));
    }

    /**
     * Returns a minimum spanning tree of the graph.
     *
     * @return a minimum spanning tree of the graph
     */
    @SuppressWarnings("unchecked")
    public Graph<T> getMST()
    {
        int x, y;
        int[] edge = new int[2];
        StackADT<int[]> vertexStack = new LinkedStack<int[]>();
        Graph<T> resultGraph = new Graph<T>();

        if (isEmpty() || !isConnected())
            return resultGraph;
        
        resultGraph.adjMatrix = new boolean[numVertices][numVertices];
        
        for (int i = 0; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
                resultGraph.adjMatrix[i][j] = false;
                
        resultGraph.vertices = (T[])(new Object[numVertices]);
        boolean[] visited = new boolean[numVertices];
        
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;        
        
        edge[0] = 0;
        resultGraph.vertices[0] = this.vertices[0];
        resultGraph.numVertices++;
        visited[0] = true;

        // Add all edges that are adjacent to vertex 0 to the stack. 
        for (int i = 0; i < numVertices; i++)
        {
            if (!visited[i] && this.adjMatrix[0][i])
            {
                edge[1] = i;
                vertexStack.push(edge.clone());
                visited[i] = true;
            }
        }

        while ((resultGraph.size() < this.size()) && !vertexStack.isEmpty())
        {
            // Pop an edge off the stack and add it to the resultGraph. 
            edge = vertexStack.pop();
            x = edge[0];
            y = edge[1];
            resultGraph.vertices[y] = this.vertices[y];
            resultGraph.numVertices++;
            resultGraph.adjMatrix[x][y] = true;
            resultGraph.adjMatrix[y][x] = true;
            visited[y] = true;

            // Add all unvisited edges that are adjacent to vertex y
            // to the stack. 
            for (int i = 0; i < numVertices; i++)
            {
                if (!visited[i] && this.adjMatrix[i][y])
                {
                    edge[0] = y;
                    edge[1] = i;
                    vertexStack.push(edge.clone());
                    visited[i] = true;
                }
            }
        }

        return resultGraph;
    }

    /**
     * Creates new arrays to store the contents of the graph with
     * twice the capacity.
     */
    protected void expandCapacity()
    {
        @SuppressWarnings("unchecked")
        T[] largerVertices = (T[])(new Object[vertices.length * 2]);
        boolean[][] largerAdjMatrix = 
                new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < numVertices; i++)
        {
            for (int j = 0; j < numVertices; j++)
            {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }

        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return the integer number of vertices in the graph
     */
    public int size()
    {
    	return numVertices;
    }

    /**
     * Returns true if the graph is empty and false otherwise. 
     *
     * @return true if the graph is empty
     */
    public boolean isEmpty()
    {
        return numVertices == 0;
    }

    /**
     * Returns true if the graph is connected and false otherwise. 
     *
     * @return true if the graph is connected
     */
    public boolean isConnected() {
        if (numVertices == 0) {
            return false;   // An empty graph cannot be connected
        }
    
        // Use a DFS iterator to check if everything is reachable
        Iterator<T> dfsIterator = iteratorDFS(0);   
        Set<T> visitedSet = new HashSet<>();
        
        // Debugging: print the start of the DFS traversal
        // System.out.println("Starting DFS traversal from vertex 0");
    
        while (dfsIterator.hasNext()) {
            T vertex = dfsIterator.next();
            // System.out.println("Visiting vertex: " + vertex);  // Debugging line
            visitedSet.add(vertex);
        }
    
        // Debugging: print the visited set after traversal
        // System.out.println("Visited vertices: " + visitedSet);  // Debugging line
    
        // Check if all vertices were visited
        if (visitedSet.size() == numVertices) {
            // System.out.println("Graph is connected");
            return true;
        }
    
        // System.out.println("Graph is not connected");
        return false;
    }
    
    

    /**
     * Returns the index value of the first occurrence of the vertex.
     * Returns -1 if the key is not found.
     *
     * @param vertex the vertex whose index value is being sought
     * @return the index value of the given vertex
     */
    public int getIndex(T vertex)
    {
        for(int i = 0; i < numVertices; i++)
        {
            if(vertices[i].equals(vertex))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if the given index is valid. 
     *
     * @param index the index whose validity is being queried
     * @return true if the given index is valid
     */
    protected boolean indexIsValid(int index)
    {
        return index >= 0 && index < numVertices;
    }

    /**
     * Returns a copy of the vertices array.
     *
     * @return a copy of the vertices array
     */
    public Object[] getVertices()
    {
        return Arrays.copyOf(vertices, numVertices);
    }
    
    /**
     * Returns a string representation of the adjacency matrix. 
     *
     * @return  a string representation of the adjacency matrix
     */
    public String toString()
    {
        if (numVertices == 0)
            return "Graph is empty";

        String result = "Adjacency Matrix\n";
        result += "----------------\n";
        result += "index\t";

        for (int i = 0; i < numVertices; i++) 
        {
            result += "" + i;
            if (i < 10)
                result += " ";
        }
        result += "\n\n";

        for (int i = 0; i < numVertices; i++)
        {
            result += "" + i + "\t";
        
            for (int j = 0; j < numVertices; j++)
            {
                if (adjMatrix[i][j])
                    result += "1 ";
                else
                    result += "0 ";
            }
            result += "\n";
        }

        result += "\n\nVertex Values";
        result += "\n-------------\n";
        result += "index\tvalue\n\n";

        for (int i = 0; i < numVertices; i++)
        {
            result += "" + i + "\t";
            result += vertices[i].toString() + "\n";
        }
        result += "\n";
        return result;
    }
    
    /**
     * Inner class to represent an iterator over the elements of this graph
     */
    protected class GraphIterator implements Iterator<T>
    {
        private int expectedModCount;
        private Iterator<T> iter;
        
        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a graph traversal
         */
        public GraphIterator(Iterator<T> iter)
        {
            this.iter = iter;
            expectedModCount = modCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();
            
            return (iter.hasNext());
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws NoSuchElementException
        {
            if (hasNext())
                return (iter.next());
            else 
                throw new NoSuchElementException();
        }
        
        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Inner class to represent an iterator over the indexes of this graph
     */
    protected class GraphIndexIterator implements Iterator<Integer>
    {
        private int expectedModCount;
        private Iterator<Integer> iter;
        
        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a graph traversal
         */
        public GraphIndexIterator(Iterator<Integer> iter)
        {
            this.iter = iter;
            expectedModCount = modCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();
            
            return (iter.hasNext());
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public Integer next() throws NoSuchElementException
        {
            if (hasNext())
                return (iter.next());
            else 
                throw new NoSuchElementException();
        }
        
        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}

