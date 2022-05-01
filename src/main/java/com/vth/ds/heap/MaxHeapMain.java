package com.vth.ds.heap;

/**
 * Main class demonstrating MaxHeap
 * 
 * @author vikshind
 *
 */
public class MaxHeapMain {
	public static void main(String[] args) {
		MaxHeap h = new MaxHeap();
		h.insert(3);
		h.insert(4);
		h.insert(9);
		h.insert(5);
		h.insert(2);
		System.out.println("Max-Heap array: ");
		h.printArray();
		h.deleteNode(4);
		System.out.println("After deleting an element: ");
		h.printArray();
	}
}
