package com.stack.test;

import com.tree.test.TreeUsingQueue.TreeNode;

public class StackUsingArray {

	public static class Stack {
		int size;
		int top = -1;
		TreeNode[] s;

		public Stack(int n) {
			this.size = n;
			this.s = new TreeNode[n];
		}
	}

	public static boolean isEmpty(Stack stack) {

		return stack.top == -1 ? true : false;
	}

	public static boolean isFull(Stack stack) {

		return stack.top == stack.size - 1 ? true : false;
	}

	public static TreeNode stackTop(Stack stack) {

		if (!isEmpty(stack))
			return stack.s[stack.top];

		return null;
	}

	public static void push(Stack stack, TreeNode node) {

		if (isFull(stack))
			throw new IllegalArgumentException("stack overflow");

		stack.top++;
		stack.s[stack.top] = node;

	}

	public static TreeNode pop(Stack stack) {

		if (isEmpty(stack))
			throw new IllegalArgumentException("stack underflow");

		TreeNode node = stack.s[stack.top];
		stack.top--;

		return node;

	}

	public static TreeNode peek(Stack stack, int index) {

		if (index <= 0)
			throw new IllegalArgumentException("invalid index");

		int stackIndex = stack.top - index + 1;

		if (stackIndex >= 0)
			return stack.s[stackIndex];

		return null;
	}

	public static void display(Stack stack) {

		if (!isEmpty(stack)) {

			for (int i = 0; i <= stack.top; i++)
				System.out.print(stack.s[i] + " ");

		}
	}

}
