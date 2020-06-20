package com.hash.test;

public class ChainingHash {

	static final int size = 10;
	static final Node[] hashtable = new Node[size];

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		public void insertSorted(Node node) {

			int hash = ChainingHash.hash(node.data);

			Node existingNode = ChainingHash.hashtable[hash];

			if (existingNode == null) {
				ChainingHash.hashtable[hash] = node;

			} else {

				Node prevNode = null;

				if (node.data < existingNode.data) {

					node.next = existingNode;
					ChainingHash.hashtable[hash] = node;

				} else if (node.data == existingNode.data) {

					throw new IllegalArgumentException("key : " + node.data + " already present");

				} else {

					while (existingNode != null && node.data > existingNode.data) {
						prevNode = existingNode;
						existingNode = existingNode.next;
					}

					node.next = prevNode.next;
					prevNode.next = node;
				}

			}

		}
	}

	public static int hash(int key) {

		return key % size;
	}

	public static void insertKey(int key) {
		Node node = new Node(key);
		node.insertSorted(node);

	}

	public static void main(String[] args) {

		insertKey(12);

		insertKey(32);

		insertKey(22);

	}
}
