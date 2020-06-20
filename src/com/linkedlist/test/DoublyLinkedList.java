package com.linkedlist.test;

public class DoublyLinkedList {

	static Node first;

	static class Node {
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

		Node firstNode = new Node(elements[0]);
		DoublyLinkedList.first = firstNode;

		for (int i = 1; i < elements.length; i++) {

			Node node = new Node(elements[i]);

			firstNode.next = node;
			node.prev = firstNode;
			firstNode = node;

		}

	}

	public static void displayDoublyLinkedList(Node node) {

		if (node == null)
			return;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

	}

	public static int countDoublyLinkedList(Node node) {

		int count = 0;

		if (node == null)
			return count;

		while (node != null) {
			count += 1;
			node = node.next;
		}

		return count;

	}

	public static void insert(Node node, int index, int data) {

		if (index < 0 || index > countDoublyLinkedList(node))
			return;

		Node t = new Node(data);

		if (index == 0) {

			t.next = node;
			node.prev = t;
			first = t;

		} else {

			for (int i = 0; i < index - 1; i++)
				node = node.next;

			t.next = node.next;
			if (node.next != null)
				node.next.prev = t;
			t.prev = node;
			node.next = t;

		}

	}

	public static int deleteDoublyLinkedList(Node node, int index) {
		int data = -1;

		if (index < 0 || index >= countDoublyLinkedList(node))
			return data;

		if (index == 0) {

			data = node.data;
			node = node.next;

			if (node == null) {
				first = null;
			} else {
				node.prev = null;
				first = node;
			}

		} else {

			for (int i = 0; i < index; i++)
				node = node.next;

			data = node.data;
			node.prev.next = node.next;

			if (node.next != null)
				node.next.prev = node.prev;

		}

		return data;
	}

	public static void reverse(Node node) {

		if (node == null)
			return;
		Node temp = null;

		while (node != null) {

			temp = node.next;
			node.next = node.prev;
			node.prev = temp;
			node = node.prev;

			if (node != null && node.next == null)
				first = node;

		}

	}

	public static void main(String[] args) {

		int[] elements = { 3, 5, 7, 9, 11 };

		createDoublyLinkedList(elements);

//		System.out.println(deleteDoublyLinkedList(first, 0));

		reverse(first);

		displayDoublyLinkedList(first);
	}
}
