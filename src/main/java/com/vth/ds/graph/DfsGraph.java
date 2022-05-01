package com.vth.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * An Iterative Java program to do DFS traversal from a given source vertex.
 * DFS(int s) traverses vertices reachable from s. This class represents a
 * directed graph using adjacency list representation
 * 
 * Stack is used in DFS
 * 
 */
public class DfsGraph {
	int numOfVertices; // Number of Vertices

	LinkedList<Integer>[] adjacencyList; // adjacency lists

	// Constructor
	DfsGraph(int numVertex) {
		this.numOfVertices = numVertex;
		adjacencyList = new LinkedList[numVertex];

		for (int i = 0; i < adjacencyList.length; i++)
			adjacencyList[i] = new LinkedList<Integer>();

	}

	// To add an edge to graph
	void addEdge(int v, int w) {
		adjacencyList[v].add(w); // Add w to v’s list.
	}

	// prints all not yet visited vertices reachable from source
	void DFS(int source) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean[] visited = new boolean[numOfVertices];

		// Create a stack for DFS
		Stack<Integer> stack = new Stack<>();

		// Push the current source node
		stack.push(source);

		while (stack.empty() == false) {
			// Pop a vertex from stack and print it
			source = stack.pop();

			// Stack may contain same vertex twice. So
			// we need to print the popped item only
			// if it is not visited.
			if (!visited[source]) {
				System.out.print(source + " ");
				visited[source] = true;
			}

			// Get all adjacent vertices of the popped vertex s
			// If a adjacent has not been visited, then push it
			// to the stack.
			Iterator<Integer> itr = adjacencyList[source].iterator();

			while (itr.hasNext()) {
				int v = itr.next();
				if (!visited[v])
					stack.push(v);
			}

		}
	}

	// Driver program to test methods of graph class
	public static void main(String[] args) {
		// Total 5 vertices in graph
		DfsGraph graph = new DfsGraph(5);

		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);

		System.out.println("Following is the Depth First Traversal");
		
		graph.DFS(0);
	}
}
