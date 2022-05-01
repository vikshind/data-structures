package com.vth.ds.heap;

public class MinHeapMain {
	public static void main(String args[]) { //construct a min heap from given data
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(7); 
        minHeap.insert(12); 
        minHeap.insert(15); 
        minHeap.insert(30); 
        minHeap.insert(40); 
        minHeap.insert(50); 
        minHeap.insert(90); 
        minHeap.insert(45); 
        
        minHeap.minHeap(); 
        //display the min heap contents
        minHeap.display(); 
        //display root node of the min heap
        System.out.println("The Min val(root node):" + minHeap.remove()); }
}
