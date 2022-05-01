package com.vth.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Java program to print BFS traversal from a given source vertex. BFS(int s)
 * traverses vertices reachable from s. This class represents a directed graph
 * using adjacency list representation
 * 
 * Queue Data Structure is used in BFS
 * 
 * @author vikshind
 *
 */
public class BfsGraph {

	private int numOfVertices; // No. of vertices
	private LinkedList<Integer> adjacencyList[]; // Adjacency Lists

	// Constructor
	BfsGraph(int numVertex) {
		numOfVertices = numVertex;
		adjacencyList = new LinkedList[numVertex];
		for (int i = 0; i < numVertex; ++i) {
			adjacencyList[i] = new LinkedList();
		}
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adjacencyList[v].add(w);
	}

	// prints BFS traversal from a given source
	void breadthFirstSearch(int source) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean[] visited = new boolean[numOfVertices];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<>();

		// Mark the current node as visited and enqueue it
		visited[source] = true;
		queue.add(source);

		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue and print it
			source = queue.poll();
			System.out.print(source + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adjacencyList[source].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	// Driver method to
	public static void main(String args[]) {
		BfsGraph graph = new BfsGraph(4);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		graph.breadthFirstSearch(2);
	}
}
