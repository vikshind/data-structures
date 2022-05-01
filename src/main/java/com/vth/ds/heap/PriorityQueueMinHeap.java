package com.vth.ds.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * PriorityQueue in Java is actual implementation of MinHeap dataStructure Lets
 * take a look at it.
 * 
 * @author vikshind
 *
 */
public class PriorityQueueMinHeap {

	public static void main(String[] args) {
		// Create priority queue object
		PriorityQueue<Integer> pQueueHeap = new PriorityQueue<>();
		// Add elements to the pQueue_heap using add()
		pQueueHeap.add(100);
		pQueueHeap.add(30);
		pQueueHeap.add(20);
		pQueueHeap.add(40);

		// Print the head (root node of min heap) using peek method
		System.out.println("Head (root node of min heap):" + pQueueHeap.peek());
		// Print min heap represented using PriorityQueue
		System.out.println("\n\nMin heap as a PriorityQueue:");
		Iterator iter = pQueueHeap.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");

		// remove head (root of min heap) using poll method
		pQueueHeap.poll();
		System.out.println("\n\nMin heap after removing root node:");
		// print the min heap again
		Iterator<Integer> iter2 = pQueueHeap.iterator();
		while (iter2.hasNext())
			System.out.print(iter2.next() + " ");
	}
}
