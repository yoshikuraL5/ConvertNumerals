package jp.level_five.careerup.ReversePolish;

import java.util.Stack;
import java.util.ArrayList;


public class Calculator {

	public Element calc(ArrayList<Element> reversepolish) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; reversepolish.size() - 1 >= i; i++) {
			Element element = reversepolish.get(i);
			if (element.isNumber()) {
				stack.push(Integer.parseInt(element.getData()));
			} else {
				calculate(stack, element);
			}
		}
		
		Element element = new Element(String.valueOf(stack.pop()));
		return element;
	}

	private void calculate(Stack<Integer> stack, Element element) {
		int v1 = stack.pop();
		int v2 = stack.pop();
		
		if ("+".equals(element.getData())) {
			stack.push(v2 + v1);
		} else if ("-".equals(element.getData())) {
			stack.push(v2 - v1);
		} else if ("*".equals(element.getData())) {
			stack.push(v2 * v1);
		} else if ("/".equals(element.getData())) {
			stack.push(v2 / v1);
		}
	}
}
