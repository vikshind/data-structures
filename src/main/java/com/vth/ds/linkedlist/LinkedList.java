package com.vth.ds.linkedlist;

/**
 * LinkedList dataStructure implementation
 * 
 * @author vikshind
 *
 */
public class LinkedList {
	// Head of the list
	Node head;

	// Node in the linked list, this class is static, so that we can access it in
	// main()
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * Adds new data / node to the front of LinkedList
	 * 
	 * @param data
	 */
	void add(int data) {
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
	}

	/**
	 * Deletes data / node from the LinkedList
	 * 
	 * @param data
	 */
	void delete(int data) {
		Node temp = head;
		Node prev = null;
		if (head != null && head.data == data) {
			head = head.next;
			return;
		}
		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.next;
		}

		// Unlink the node from linked list
		if (temp != null && prev != null) {
			prev.next = temp.next;
		}
	}

	/**
	 * Deletes the node at the given position
	 */
	void deleteNodeAt(int position) {
		// If linked list is empty
		if (head == null)
			return;

		// Store head node
		Node temp = head;

		// If head needs to be removed
		if (position == 0) {
			head = temp.next; // Change head
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}
		
		// If position is more than number of nodes
		if (temp == null || temp.next == null)
			return;

		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		Node next = temp.next.next;

		temp.next = next; // Unlink the deleted node from list
	}

	/**
	 * Prints linkedList
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = this.head;
		while (node != null) {
			sb.append(node.data + " ");
			node = node.next;
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();

		Node node1 = new Node(15);
		Node node2 = new Node(12);
		Node node3 = new Node(2004);

		linkedList.head = node3;
		node3.next = node2;
		node2.next = node1;

		System.out.println(linkedList.toString());

	}
}
