package com.linkedlist.test;

public class CircularLinkedList {

	static Node first;

	static class Node {
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

	public static void createCircularLinkedList(int[] elements) {

		if (elements.length == 0)
			return;

		Node firstNode = new Node(elements[0]);
		CircularLinkedList.first = firstNode;

		if (elements.length == 1) {
			CircularLinkedList.first.next = CircularLinkedList.first;

		}

		for (int i = 1; i < elements.length; i++) {

			Node node = new Node(elements[i]);
			firstNode.next = node;
			firstNode = node;
			firstNode.next = CircularLinkedList.first;
		}

	}

	public static void displayCircularLinkedList(Node node) {

		if (node == null)
			return;

		do {

			System.out.print(node.data + " ");
			node = node.next;
		}

		while (node != first);

	}

	public static int countCircularLinkedList(Node node) {

		int count = 0;

		if (node == null)
			return count;

		do {
			count += 1;
			node = node.next;

		} while (node != first);

		return count;

	}

	public static void insert(Node node, int index, int data) {

		if (index < 0 || index > countCircularLinkedList(node))
			return;

		Node t = new Node(data);
		Node last = null;

		if (index == 0) {

			/*
			 * do { last = node; node = node.next; } while (node != first);
			 */

			while (node.next != first)
				node = node.next;

			node.next = t;
			t.next = first;
			first = t;

		} else {

			for (int i = 0; i < index - 1; i++)
				node = node.next;

			t.next = node.next;
			node.next = t;
		}

	}

	public static int deleteCircularLinkedList(Node node, int index) {

		int data = -1;

		if (index < 0 || index >= countCircularLinkedList(node))
			return data;

		if (index == 0) {

			while (node.next != first)
				node = node.next;

			data = first.data;
			if (first.next == first)
				first = null;
			else {
				node.next = first.next;
				first = node.next;
			}
		} else {

			for (int i = 0; i < index - 1; i++)
				node = node.next;

			data = node.next.data;
			node.next = node.next.next;

		}

		return data;
	}

	public static void main(String[] args) {

		int[] elements = { 3, 5, 7, 9 };

		createCircularLinkedList(elements);

		deleteCircularLinkedList(first, 0);

		displayCircularLinkedList(first);

	}
}
