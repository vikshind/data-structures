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
    public void deleteNodeAt(int index) {
        if (index < 0 ) {
            System.out.println("\nInvalid input to insert node in an linked list.");
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while(currentIndex < index &&  temp!= null){
            temp = temp.next;
            currentIndex++;
        }
        if(currentIndex == 0){
            if(head != null){
                head = head.next;
                head.prev = null;
            }
        }
        if(temp == null){
            System.out.println("\nIndex outside the linkedList");
        }
        else{
            if(temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if(temp.prev != null){
                temp.prev.next = temp.next;
            }

        }
    }
    public void insertNodeAt(int index, Node node){
        if(index < 0 || node == null){
            System.out.println("\nInvalid input to insert node in an linked list.");
            return;
        }
        int currentIndex = 0;
        Node temp = head;
        while(currentIndex < index &&  temp!= null){
            temp = temp.next;
            currentIndex++;
        }
        if(currentIndex == 0){
            if(head != null){
                node.prev = null;
                node.next = head;
            }
            head = node;
        }
        if(temp == null){
            if(tail != null){
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
        }
        else{
            node.next = temp;
            node.prev = temp.prev;
            temp.prev.next = node;
        }

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
        System.out.println("\n");
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

        System.out.println("Insert element at index 2 : ");
        linkedList.insertNodeAt(2, linkedList.newNode(8));
        linkedList.printFromHead();

        System.out.println("Insert element at index 10 : ");
        linkedList.insertNodeAt(10, linkedList.newNode(10));
        linkedList.printFromHead();

        //Delete NodeAt tests
        linkedList.deleteNodeAt(2);
        linkedList.printFromHead();
        linkedList.deleteNodeAt(11);
        linkedList.deleteNodeAt(4);
        linkedList.printFromHead();
        linkedList.deleteNodeAt(2);
        linkedList.printFromHead();
        linkedList.deleteNodeAt(2);
        linkedList.printFromHead();
        linkedList.deleteNodeAt(0);
        linkedList.printFromHead();
//        linkedList.printFromTail();
    }
}
