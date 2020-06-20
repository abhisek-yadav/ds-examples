package com.queue.test;

import com.queue.test.QueueUsingLinkedList.Queue.Node;

public class QueueUsingLinkedList {

	public static class Queue {
		private Node front;
		private Node rear;

		public static class Node {
			private int data;
			private Node next;

			public Node(int data) {
				this.data = data;
			}
		}
	}

	public static boolean isEmpty(Queue queue) {
		if (queue.front == null && queue.rear == null)
			return true;

		return false;
	}

	public static void enqueue(Queue queue, int element) {

		Node t = new Node(element);

		if (isEmpty(queue)) {

			queue.front = t;
			queue.rear = t;

		} else {

			queue.rear.next = t;
			queue.rear = t;

		}
	}

	public static int dequeue(Queue queue) {

		if (isEmpty(queue))
			throw new IllegalStateException("Queue is empty");

		Node deleteNode = queue.front;
		queue.front = queue.front.next;

		return deleteNode.data;

	}

	public static void display(Queue queue) {

		if (!isEmpty(queue)) {
			Node p = queue.front;

			while (p != null) {
				System.out.print(p.data + " ");
				p = p.next;
			}
		}
	}

	public static void main(String[] args) {

		Queue queue = new Queue();

		enqueue(queue, 3);
		enqueue(queue, 5);
		enqueue(queue, 7);
		enqueue(queue, 9);
		dequeue(queue);
		enqueue(queue, 11);
		enqueue(queue, 13);

		dequeue(queue);

		enqueue(queue, 15);

		display(queue);
	}

}
