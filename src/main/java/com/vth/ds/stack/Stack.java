package com.vth.ds.stack;

public class Stack {
	private static final int MAX = 5;
	private int stack[] = new int[MAX];
	private int top = -1;

	public Stack() {
	}

	void push(int x) {
		if (top < MAX-1) {
			stack[++top] = x;
		}
	}

	int pop() {
		if (top > -1) {
			return stack[top--];
		}
		return -1;
	}

	boolean isEmpty() {
		return top == -1 ? true : false;
	}

	int top() {
		return this.top;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		stack.push(4);
		stack.push(5);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
}
