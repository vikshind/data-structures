package com.vth.ds.heap;

import java.util.ArrayList;

/**
 * MaxHeap implementation using ArrayList in Java
 * 
 * @author vikshind
 *
 */
public class MaxHeap {

	//ArrayList that maintains MaxHeap structure
	ArrayList<Integer> heap = new ArrayList<>();
	void heapify(int i) {
		int size = heap.size();
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < size && heap.get(l) > heap.get(largest))
			largest = l;
		if (r < size && heap.get(r) > heap.get(largest))
			largest = r;

		if (largest != i) {
			int temp = heap.get(largest);
			heap.set(largest, heap.get(i));
			heap.set(i, temp);

			heapify(largest);
		}
	}

	void insert(int newNum) {
		int size = heap.size();
		if (size == 0) {
			heap.add(newNum);
		} else {
			heap.add(newNum);
			for (int i = size / 2 - 1; i >= 0; i--) {
				heapify(i);
			}
		}
	}

	void deleteNode(int num) {
		int size = heap.size();
		int i;
		for (i = 0; i < size; i++) {
			if (num == heap.get(i))
				break;
		}

		int temp = heap.get(i);
		heap.set(i, heap.get(size - 1));
		heap.set(size - 1, temp);

		heap.remove(size - 1);
		for (int j = size / 2 - 1; j >= 0; j--) {
			heapify(j);
		}
	}

	void printArray() {
		for (Integer i : heap) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
