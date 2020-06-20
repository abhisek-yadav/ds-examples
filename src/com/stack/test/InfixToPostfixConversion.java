package com.stack.test;

import com.stack.test.ParenthesisMatching.Stack;

public class InfixToPostfixConversion {

	public static int getPrecedence(char symbol) {

		if ('+' == symbol || '_' == symbol)
			return 1;

		if ('*' == symbol || '/' == symbol)
			return 2;

		return -1;
	}

	public static boolean isOperand(char c) {

		if ('+' == c || '-' == c || '*' == c || '/' == c)
			return true;

		return false;
	}

	public static String convertInfixToPostfix(String infix) {
		StringBuffer postfix = new StringBuffer();

		Stack stack = new Stack(20);

		char[] chars = infix.toCharArray();

		int i = 0;

		while (chars[i] != '\0') {

			if (!isOperand(chars[i]))
				postfix = postfix.append(chars[i++]);

			else {

				if (getPrecedence(ParenthesisMatching.stackTop(stack)) < getPrecedence(chars[i])) {
					ParenthesisMatching.push(stack, chars[i++]);
				} else {
					postfix.append(ParenthesisMatching.pop(stack));
				}
			}
		}

		while (!ParenthesisMatching.isEmpty(stack)) {
			postfix.append(ParenthesisMatching.pop(stack));
		}

		return postfix.toString();
	}

	public static void main(String[] args) {
		String infix = "a+b+c*d/e\0";

		System.out.println(convertInfixToPostfix(infix));
	}
}
