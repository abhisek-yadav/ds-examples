package com.stack.test;

public class ParenthesisMatching {

	public static class Stack {
		int size;
		int top = -1;
		char[] s;

		public Stack(int n) {
			this.size = n;
			this.s = new char[n];
		}
	}

	public static boolean isEmpty(Stack stack) {

		return stack.top == -1 ? true : false;
	}

	public static boolean isFull(Stack stack) {

		return stack.top == stack.size - 1 ? true : false;
	}

	public static void push(Stack stack, char element) {

		if (isFull(stack))
			throw new IllegalArgumentException("stack overflow");

		stack.top++;
		stack.s[stack.top] = element;

	}

	public static char pop(Stack stack) {

		if (isEmpty(stack))
			throw new IllegalArgumentException("stack underflow");

		char element = stack.s[stack.top];
		stack.top--;

		return element;

	}

	public static char stackTop(Stack stack) {

		if (!isEmpty(stack))
			return stack.s[stack.top];

		return '0';
	}

	public static boolean isMatching(Stack stack, String expression) {

		char[] chars = expression.toCharArray();

		for (char c : chars) {

			if (c == '(')

				push(stack, c);

			else if (c == ')') {

				if (isEmpty(stack))
					throw new IllegalArgumentException("wrong expression");

				else
					pop(stack);
			}
		}

		return isEmpty(stack) ? true : false;

	}

	public static void main(String[] args) {

		String expression = "(((((a+b)+(c+d)))))";
		Stack stack = new Stack(15);

		System.out.println(isMatching(stack, expression));

	}

}
