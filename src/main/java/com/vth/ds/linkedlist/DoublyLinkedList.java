package com.vth.ds.linkedlist;

public class DoublyLinkedList {
    Node head;
    Node tail;
    public void insert(Node node){
        if (node == null)
            return;

        if (head == null){
            head = node;
        }
        if(tail != null){
            tail.next = node;
            node.prev = tail;
        }

        tail = node;
    }
    public void delete(){
        if(head == null){
            return;
        }
        head = head.next;
    }

    public Node newNode(int data){
        return new Node(data);
    }

    public void printFromHead(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    public void printFromTail() {
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }
    
    public class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String args[]){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node node1 = linkedList.newNode(1);
        linkedList.insert(node1);

        Node node2 = linkedList.newNode(0);
        linkedList.insert(node2);

        Node node3 = linkedList.newNode(7);
        linkedList.insert(node3);

        Node node4 = linkedList.newNode(3);
        linkedList.insert(node4);

        linkedList.printFromHead();
        System.out.println();
        linkedList.printFromTail();
    }
}
