package com.queue.test;

public class CircularQueueUsingArray {

	public static class Queue {

		private int size;
		private int front = 0;
		private int rear = 0;
		private int[] q;

		public Queue(int size) {
			this.size = size;
			this.q = new int[size];
		}

	}

	public static boolean isFull(Queue queue) {
		if ((queue.rear + 1) % queue.size == queue.front)
			return true;

		return false;
	}

	public static boolean isEmpty(Queue queue) {
		if (queue.front == queue.rear)
			return true;

		return false;
	}

	public static void enqueue(Queue queue, int element) {

		if (isFull(queue))
			throw new IllegalStateException("Queue is full");

		queue.rear = (queue.rear + 1) % queue.size;
		queue.q[queue.rear] = element;
	}

	public static int dequeue(Queue queue) {

		if (isEmpty(queue))
			throw new IllegalStateException("Queue is empty");

		queue.front = (queue.front + 1) % queue.size;

		return queue.q[queue.front];

	}

	public static void display(Queue queue) {

		if (!isEmpty(queue)) {
			queue.front++;

			do {
				System.out.print(queue.q[queue.front] + " ");
				queue.front = (queue.front + 1) % queue.size;
			} while ((queue.rear + 1) % queue.size != queue.front);
		}
	}

	public static void main(String[] args) {

		Queue queue = new Queue(5);

		enqueue(queue, 3);
		enqueue(queue, 5);
		enqueue(queue, 7);
		enqueue(queue, 9);

		System.out.println(dequeue(queue));

		enqueue(queue, 12);
		
		System.out.println(dequeue(queue));
		
		enqueue(queue, 13);
		
		System.out.println(dequeue(queue));
		
		enqueue(queue, 15);
		
		System.out.println(dequeue(queue));
		System.out.println(dequeue(queue));
		
		enqueue(queue, 17);
		enqueue(queue, 19);

		display(queue);
	}
}
