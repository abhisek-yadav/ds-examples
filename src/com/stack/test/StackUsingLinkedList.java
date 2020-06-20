package com.stack.test;

import com.stack.test.StackUsingLinkedList.Stack.Node;

public class StackUsingLinkedList {

	public static class Stack {

		Node top;

		public static class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}

		}
	}

	public static boolean isEmpty(Stack stack) {

		return stack.top == null ? true : false;

	}

	public static Node stackTop(Stack stack) {
		if (!isEmpty(stack))
			return stack.top;

		return null;
	}

	public static void push(Stack stack, int element) {

		Node t = new Node(element);

		if (isEmpty(stack))
			stack.top = t;
		else {
			t.next = stack.top;
			stack.top = t;
		}
	}

	public static Node pop(Stack stack) {

		if (isEmpty(stack))
			throw new IllegalArgumentException("stack underflow");

		Node node = stack.top;
		stack.top = stack.top.next;

		return node;
	}

	public static Node peek(Stack stack, int index) {

		if (isEmpty(stack))
			throw new IllegalArgumentException("stack underflow");

		if (index <= 0)
			throw new IllegalArgumentException("invalid index");

		Node peekNode = stack.top;

		for (int i = 1; i < index && peekNode != null; i++)
			peekNode = peekNode.next;

		return peekNode;

	}

	public static void display(Stack stack) {

		if (!isEmpty(stack)) {
			Node node = stack.top;
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}
	}

	public static void main(String[] args) {

		Stack stack = new Stack();

		System.out.println("isEmpty: " + isEmpty(stack));

		push(stack, 3);

		push(stack, 5);

		push(stack, 7);

		push(stack, 9);

		push(stack, 12);

		push(stack, 15);

		/*
		 * System.out.println(pop(stack).data);
		 * 
		 * System.out.println(pop(stack).data);
		 * 
		 * System.out.println(pop(stack).data);
		 * 
		 * System.out.println(pop(stack).data);
		 */

		System.out.println("peek: " + peek(stack, 1).data);

		System.out.println("stackTop: " + stackTop(stack).data);

		display(stack);
	}
}
