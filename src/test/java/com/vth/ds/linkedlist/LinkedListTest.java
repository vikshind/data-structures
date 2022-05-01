package com.vth.ds.linkedlist;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListTest {
	
	@Test(enabled = true, description = "Testing printing of linkedList nodes")
	public void testAdd() {
		LinkedList linkedList = new LinkedList();
		linkedList.add(2004);
		linkedList.add(12);
		linkedList.add(15);
		
		Assert.assertEquals(linkedList.toString(), "15 12 2004 ");
	}

	@Test(enabled = true, description = "Testing printing of linkedList nodes")
	public void testDelete() {
		LinkedList linkedList = new LinkedList();
		linkedList.add(2004);
		linkedList.add(12);
		linkedList.add(15);
		
		linkedList.delete(12);
		Assert.assertEquals(linkedList.toString(), "15 2004 ");
	}
	
	@Test(enabled = true, description = "Testing printing of linkedList nodes")
	public void testDeleteNodeAt() {
		LinkedList linkedList = new LinkedList();
		linkedList.add(2004);
		linkedList.add(12);
		linkedList.add(15);
		linkedList.add(1974);
		linkedList.add(12);
		linkedList.add(18);
		
		linkedList.deleteNodeAt(0);	
		Assert.assertEquals(linkedList.toString(), "12 1974 15 12 2004 ");
		linkedList.deleteNodeAt(1);	
		Assert.assertEquals(linkedList.toString(), "12 15 12 2004 ");
		linkedList.deleteNodeAt(4);	
		Assert.assertEquals(linkedList.toString(), "12 15 12 2004 ");
		linkedList.deleteNodeAt(3);	
		Assert.assertEquals(linkedList.toString(), "12 15 12 ");
	}
}
