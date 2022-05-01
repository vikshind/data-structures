package com.vth.ds.heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * To represent the max heap in Java using the Priority queue, we have to use
 * Collections.reverseOrder to reverse the min-heap. The priority queue directly
 * represents a min-heap in Java.
 * 
 * @author vikshind
 *
 */
public class PriorityQueueMaxHeap {
	public static void main(String args[]) {
		// Create empty priority queue
		// with Collections.reverseOrder to represent max heap
		PriorityQueue<Integer> pQueueHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		// Add items to the pQueue using add()
		pQueueHeap.add(10);
		pQueueHeap.add(90);
		pQueueHeap.add(20);
		pQueueHeap.add(40);

		// Printing all elements of max heap
		System.out.println("The max heap represented as PriorityQueue:");
		Iterator iter = pQueueHeap.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");

		// Print the highest priority element (root of max heap)
		System.out.println("\n\nHead value (root node of max heap):" + pQueueHeap.peek());

		// remove head (root node of max heap) with poll method
		pQueueHeap.poll();
		// print the max heap again
		System.out.println("\n\nMax heap after removing root: ");
		Iterator<Integer> iter2 = pQueueHeap.iterator();
		while (iter2.hasNext())
			System.out.print(iter2.next() + " ");
	}
}
