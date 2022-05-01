package com.vth.ds.heap;

class BinaryHeapMain {
	public static void main(String[] args) {
		BinaryHeap maxHeap = new BinaryHeap(10);

		maxHeap.insert(1);
		maxHeap.insert(2);
		maxHeap.insert(3);
		maxHeap.insert(4);
		maxHeap.insert(5);
		maxHeap.insert(6);
		maxHeap.insert(7);
		maxHeap.printHeap();
		// maxHeap.delete(5);
		// maxHeap.printHeap();

	}
}
