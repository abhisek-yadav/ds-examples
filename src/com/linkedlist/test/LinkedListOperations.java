package com.linkedlist.test;

import com.linkedlist.test.LinkedListOperations.LinkedList.Node;

public class LinkedListOperations {

	public static class LinkedList {

		static Node first;
		static Node second;
		static Node third;

		public static class Node {

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
	}

	public static void createLinkedList(int[] elements) {

		if (elements.length == 0)
			return;

		Node firstNode = new Node(elements[0]);

		LinkedList.first = firstNode;

		for (int i = 1; i < elements.length; i++) {

			Node node = new Node(elements[i]);
			firstNode.next = node;
			firstNode = node;

		}
	}

	public static void createLinkedList2(int[] elements) {

		Node firstNode = new Node(elements[0]);

		LinkedList.second = firstNode;

		for (int i = 1; i < elements.length; i++) {

			Node node = new Node(elements[i]);
			firstNode.next = node;
			firstNode = node;

		}
	}

	public static void displayLinkedList(Node node) {

		if (node == null)
			return;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

	}

	public static int count(Node node) {
		int count = 0;
		if (node == null)
			return count;

		while (node != null) {
			count += 1;
			node = node.next;

		}

		return count;
	}

	public static void mergeTwoSortedLinkedList() {

		Node p = null;
		Node q = null;
		Node last = null;

		if (count(LinkedList.first) == 0 || count(LinkedList.second) == 0)
			return;

		p = LinkedList.first;
		q = LinkedList.second;

		if (p.data < q.data) {
			LinkedList.third = last = p;
			p = p.next;
			last.next = null;
		} else if (p.data > q.data) {
			LinkedList.third = last = q;
			q = q.next;
			last.next = null;
		}

		while (p != null && q != null) {

			if (p.data < q.data) {

				last.next = p;
				last = p;
				p = p.next;
				last.next = null;

			} else {

				last.next = q;
				last = q;
				q = q.next;
				last.next = null;

			}
		}

		if (p != null)
			last.next = p;

		if (q != null)
			last.next = q;
	}

	public static int middleNode(Node node) {

		int data = -1;

		if (node == null)
			return data;

		Node p = node;

		while (p != null) {
			p = p.next;
			if (p != null) {
				p = p.next;
				node = node.next;
			}
		}

		return node.data;
	}

	public static void main(String[] args) {

		int[] elements = { 3, 5, 7, 9, 12, 15, 18 };

		createLinkedList(elements);

		/*
		 * int[] elements2 = { 2, 4, 6, 8, 10, 13, 16, 18, 21 };
		 * 
		 * createLinkedList(elements);
		 * 
		 * createLinkedList2(elements2);
		 * 
		 * mergeTwoSortedLinkedList();
		 * 
		 * displayLinkedList(LinkedList.third);
		 */

		System.out.println(middleNode(LinkedList.first));

	}

}
