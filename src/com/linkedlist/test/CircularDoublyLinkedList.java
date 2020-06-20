package com.linkedlist.test;

public class CircularDoublyLinkedList {

	static Node first;

	public static class Node {

		Node prev;
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

	public static void createDoublyLinkedList(int[] elements) {

		if (elements.length == 0)
			return;

		Node node = new Node(elements[0]);
		first = node;

		if (elements.length == 1)
			node.prev = node.next = node;

		for (int i = 1; i < elements.length; i++) {

			Node t = new Node(elements[i]);
			t.next = first;
			first.prev = t;
			t.prev = node;
			node.next = t;
			node = t;
		}
	}

	public static void displayDoublyLinkedList(Node node) {

		if (node == null)
			return;

		do {

			System.out.print(node.data + " ");
			node = node.next;

		} while (node != first);

	}

	public static void main(String[] args) {

		int[] elements = { 2, 3, 5, 7, 9 };

		createDoublyLinkedList(elements);

		displayDoublyLinkedList(first);
	}

}
