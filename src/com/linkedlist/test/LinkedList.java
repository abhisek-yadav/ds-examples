package com.linkedlist.test;

public class LinkedList {

	static Node head;

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

	public static void createLinkedList() {

		Node first = new Node(5);
		Node second = new Node(7);
		Node third = new Node(10);
		Node forth = new Node(12);
		Node fifth = new Node(15);

		head = first;
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;

	}

	public static void display(Node node) {

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void displayRecursive(Node node) {

		if (node == null)
			return;

		displayRecursive(node.next);

		System.out.print(node.data + " ");

	}

	static int max = 0;

	public static int max(Node node) {

		/*
		 * if (node == null) return max;
		 * 
		 * max = max(node.next);
		 * 
		 * return max > node.data ? max : node.data;
		 */

		if (node == null)
			return max;

		max(node.next);

		if (max < node.data)
			max = node.data;

		return max;

	}

	public static int sum(Node node) {

		if (node == null)
			return 0;

		return sum(node.next) + node.data;
	}

	public static int count(Node node) {

		if (node == null)
			return 0;

		return count(node.next) + 1;

	}

	public static Node search(Node node, int key) {

		if (node == null)
			return null;

		if (key == node.data)
			return node;

		return search(node.next, key);
	}

	// move to head search

	public static Node searchMTH(Node node, int key) {

		Node prev = null;

		while (node != null) {

			if (key == node.data) {

				if (prev == null) {
					System.out.println("node is found");

					return node;
				} else {

					prev.next = node.next;
					node.next = head;
					head = node;

					System.out.println("node is found");

					return node;
				}
			}

			prev = node;
			node = node.next;
		}

		System.out.println("Node not found");

		return null;
	}

	public static Node insert(Node node, int index, int data) {

		if (index < 0 || index > count(node) + 1) {

			System.out.println("invalid index");
			return null;
		}

		Node newNode = new Node(data);

		if (index == 1) {

			newNode.next = head;
			head = newNode;

		} else {

			if (node == null)
				return null;

			for (int i = 1; i < index - 1; i++)
				node = node.next;

			newNode.next = node.next;
			node.next = newNode;

		}

		return newNode;
	}

	public static void insertCreate(int data) {

		Node node = head;
		Node prev = null;
		Node newNode = new Node(data);

		if (count(head) == 0) {

			head = newNode;

		} else {

			while (node != null) {
				prev = node;
				node = node.next;
			}

			prev.next = newNode;
		}
	}

	public static boolean isSorted(Node node) {

		if (node == null)
			return false;

		int data = 0;

		while (node != null) {

			if (data > node.data) {
				return false;
			}
			data = node.data;
			node = node.next;
		}

		return true;
	}

	public static void insertSorted(Node node, int data) {

		if (node == null)
			return;

		Node prev = null;
		Node newNode = new Node(data);

		while (node != null && data > node.data) {
			prev = node;
			node = node.next;
		}

		if (node == head) {
			newNode.next = head;
			head = newNode;

		} else {
			newNode.next = prev.next;
			prev.next = newNode;

		}
	}

	public static int delete(Node node, int index) {
		int data = -1;

		if (node == null)
			return data;

		if (index <= 0 || index > count(node))
			return data;

		if (index == 1) {
			data = head.data;
			head = head.next;

			return data;
		}

		for (int i = 1; i < index - 1; i++) {
			node = node.next;
		}
		data = node.next.data;
		node.next = node.next.next;

		return data;
	}

	public static void removeDuplicate(Node node) {

		if (node == null || count(node) == 1)
			return;

		Node prev = null;

		while (node != null) {

			prev = node;
			node = node.next;

			if (prev.data == node.data) {

				prev.next = node.next;
				node = node.next;

			}
		}

	}

	public static void reverseUsingArray(Node node) {

		int count = count(node);

		if (count <= 1)
			return;

		int i = 0;
		int[] arr = new int[count(node)];

		while (node != null) {
			arr[i++] = node.data;
			node = node.next;
		}

		i--;
		node = head;

		while (node != null) {
			node.data = arr[i--];
			node = node.next;
		}

	}

	// using sliding pointer

	public static void reverseUsingReference(Node node) {

		int count = count(node);

		if (count <= 1)
			return;

		Node prev1 = null;
		Node prev2 = null;

		while (node != null) {

			prev2 = prev1;
			prev1 = node;
			node = node.next;
			prev1.next = prev2;
		}

		head = prev1;
	}

	public static void reverseUsingRecursion(Node prev, Node node) {

		if (node != null)
			reverseUsingRecursion(node, node.next);

		if (node == null)
			head = prev;
		else
			node.next = prev;

	}

	public static boolean isLoop(Node node) {
		if (node == null)
			return false;

		Node p = node;

		do {
			node = node.next;
			p = p.next;
			p = p != null ? p.next : null;

		} while (node != null && p != null && node != p);

		if (node == p)
			return true;
		else
			return false;

	}

	public static void reverseUsingRecursion(Node node) {

		if (node == null) {

			return;
		}
		Node q = node;
		Node p = node.next;
		reverseUsingRecursion(p);

		if (p == null)
			head = q;

		else {
			p.next = q;
			q.next = null;

		}

	}

	public static void main(String[] args) {

		createLinkedList();

		reverseUsingRecursion(head);

		display(head);
	}

}
