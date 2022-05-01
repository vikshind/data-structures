package com.vth.ds.queue.priorityqueue;

/**
 * Priority Queue implementation using Array
 * 
 * @author vikshind
 *
 */
public class PQueueUsingArray {
	private static final int MAX = 100000;

	Item pQueue[] = new Item[MAX];
	// Pointer to the last index
	int size = -1;

	class Item {
		int value;
		int priority;
		
		public Item(int value, int priority) {
			this.value = value;
			this.priority = priority;
		}
	}

	// Function to insert a new element
	// into priority queue
	void enqueue(int value, int priority) {
		// Increase the size
		size++;
		Item item = new Item(value, priority);
		// Insert the element
		pQueue[size] = item;
	}

	// Function to remove the element with
	// the highest priority
	void dequeue() {
		// Find the position of the element
		// with highest priority
		int ind = peek();

		// Shift the element one index before
		// from the position of the element
		// with highest priority is found
		for (int i = ind; i < size; i++) {
			pQueue[i] = pQueue[i + 1];
		}

		// Decrease the size of the
		// priority queue by one
		size--;
	}

	// Function to check the top element
	int peek() {
		int highestPriority = -1;
		int index = -1;

		// Check for the element with
		// highest priority
		for (int i = 0; i <= size; i++) {

			// If priority is same choose
			// the element with the
			// highest value
			if ((highestPriority == pQueue[i].priority && index > -1 && pQueue[index].value < pQueue[i].value)
					|| (highestPriority < pQueue[i].priority)) {
				highestPriority = pQueue[i].priority;
				index = i;
			} 
		}

		// Return position of the element
		return index;
	}
	
	public void printItemAtIndex(int index) {
		System.out.println("Priority : " + pQueue[index].priority + ", Value : " + pQueue[index].value);
	}
	public static void main(String[] args) {
		PQueueUsingArray pQueue = new PQueueUsingArray();
		   // Function Call to insert elements
	    // as per the priority
		pQueue.enqueue(10, 2);
		pQueue.enqueue(14, 4);
		pQueue.enqueue(16, 4);
		pQueue.enqueue(12, 3);
	 
	    // Stores the top element
	    // at the moment
	    int ind = pQueue.peek();
	 
	    pQueue.printItemAtIndex(ind);
	 
	    // Dequeue the top element
	    pQueue.dequeue();
	 
	    // Check the top element
	    ind = pQueue.peek();
	    pQueue.printItemAtIndex(ind);
	 
	    // Dequeue the top element
	    pQueue.dequeue();
	 
	    // Check the top element
	    ind = pQueue.peek();
	    pQueue.printItemAtIndex(ind);

	}

}
