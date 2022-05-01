package com.vth.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BinaryTree data structure and common operations that gets performed on this
 * DS.
 * 
 * @author vikshind
 *
 */
public class BinaryTree {

	Node root = null;

	/**
	 * Add value to the BinaryTree
	 * 
	 * @param value
	 */
	public void add(int value) {
		root = addRecursive(root, value);
	}

	/**
	 * Check if value is present in the BinaryTree
	 * 
	 * @param value
	 * @return
	 */
	public boolean containsNode(int value) {
		return containsNode(root, value);
	}

	/**
	 * Delete value from BinaryTree
	 * 
	 * @param value
	 */
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	private boolean containsNode(Node current, int value) {
		if (current == null) {
			return false;
		}

		if (value == current.value) {
			return true;
		}

		return (value < current.value) ? containsNode(current.left, value) : containsNode(current.right, value);
	}

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
			// Node to delete found, so the code to delete the node will go here

			// Case 1: no children : this is the simplest case; we just need to replace this
			// node with null in its parent node
			if (current.left == null && current.right == null) {
				return null;
			}

			// Case 2: only 1 child : in the parent node, we replace this node with its only
			// child.
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}

			// Case 3: 2 children : this is the most complex case because it requires a tree
			// reorganization
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	/**
	 * Depth-First-Search :>> The in-order traversal consists of first visiting the
	 * left sub-tree, then the root node, and finally the right sub-tree
	 * 
	 * @param node
	 */
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			visit(node.value);
			traverseInOrder(node.right);
		}
	}

	/**
	 * Depth-First-Search :>> Pre-order traversal visits first the root node, then
	 * the left sub-tree, and finally the right sub-tree
	 * 
	 * @param node
	 */
	public void traversePreOrder(Node node) {
		if (node != null) {
			visit(node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	/**
	 * Depth-First-Search :>> Post-order traversal visits the left sub-tree, the
	 * right subt-tree, and the root node at the end
	 * 
	 * @param node
	 */
	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			visit(node.value);
		}
	}

	public void traverseLevelOrder() {
		if (root == null) {
			return;
		}

		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {

			Node node = nodes.remove();

			System.out.print(" " + node.value);

			if (node.left != null) {
				nodes.add(node.left);
			}

			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}

	public void traverseInOrderWithoutRecursion() {
		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			Node top = stack.pop();
			visit(top.value);
			current = top.right;
		}
	}

	public void traversePreOrderWithoutRecursion() {
		Stack<Node> stack = new Stack<>();
		Node current = root;
		stack.push(root);

		while (current != null && !stack.isEmpty()) {
			current = stack.pop();
			visit(current.value);

			if (current.right != null)
				stack.push(current.right);

			if (current.left != null)
				stack.push(current.left);
		}
	}

	public void traversePostOrderWithoutRecursion() {
		Stack<Node> stack = new Stack<>();
		Node prev = root;
		Node current = root;
		stack.push(root);

		while (current != null && !stack.isEmpty()) {
			current = stack.peek();
			boolean hasChild = (current.left != null || current.right != null);
			boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

			if (!hasChild || isPrevLastChild) {
				current = stack.pop();
				visit(current.value);
				prev = current;
			} else {
				if (current.right != null) {
					stack.push(current.right);
				}
				if (current.left != null) {
					stack.push(current.left);
				}
			}
		}
	}

	// Just for sysout of value
	private void visit(int value) {
		System.out.print(" " + value);
	}

	public boolean isBST(Node root) {
		boolean result = true;
		if (root.left != null) {
			if (root.value > root.left.value) {
				result = isBST(root.left);
			}
			else {
				result = false;
			}
		}
		if (result &&  root.right != null) {
			if (root.value < root.right.value) {
				result = isBST(root.right);
			}
			else {
				result = false;
			}
		}
		return result;
	}

	public Node buidlTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}
}
