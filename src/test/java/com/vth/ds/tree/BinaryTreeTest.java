package com.vth.ds.tree;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BinaryTreeTest {

	BinaryTree bt = null;

	@BeforeMethod
	public void setup() {
		bt = new BinaryTree();
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
	}

	@Test(enabled = true, description = "Tests binary tree contains node")
	public void testBinaryTreeContainsNode() {
		Assert.assertEquals(false, bt.containsNode(1));
		Assert.assertEquals(true, bt.containsNode(5));
	}

	@Test(enabled = true, description = "Tests binary tree delete node")
	public void testBinaryTreeDeleteNode() {
		Assert.assertTrue(bt.containsNode(9));
		bt.delete(9);
		Assert.assertFalse(bt.containsNode(9));
	}

	@Test(enabled = true, description = "Tests binary tree traversal")
	public void testTraversal() {
		bt.traverseInOrder(bt.root);
		System.out.println();
		bt.traversePreOrder(bt.root);
		System.out.println();
		bt.traversePostOrder(bt.root);
		System.out.println();
	}

	@Test(enabled = true, description = "Tests if input Node is BinarySearchTree or Not")
	public void testIsBST() {
		//Test the BinaryTree created in setup()
		Assert.assertTrue(bt.isBST(bt.root));

		//Test the BinaryTree created using buildTree(), success case
		Node testNode = bt.buidlTree("5 3 7 1 N N 9");
		Assert.assertTrue(bt.isBST(testNode));
		
		//Test the BinaryTree created using buildTree(), failure case
		testNode = bt.buidlTree("5 3 1 N 7 N 9");
		Assert.assertFalse(bt.isBST(testNode));
	}
}
