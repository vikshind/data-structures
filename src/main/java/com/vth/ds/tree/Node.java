package com.vth.ds.tree;

/**
 * Node in a BinaryTree
 * @author vikshind
 *
 */
public class Node {

	int value;
	Node left;
	Node right;
	
	Node(int value){
		this.value = value;
		left = right = null;
	}
}
