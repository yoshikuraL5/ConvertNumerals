package jp.level_five.careerup.ReversePolish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ElementArranger {
	public ArrayList<Element> arrangeByReversePolish(
			ArrayList<Element> elementArray) {
		ArrayList<Element> arrangedList = new ArrayList<Element>();
		Iterator<Element> iterator = elementArray.iterator();
		arrange(iterator, arrangedList);
		for (Element str : arrangedList) {
			System.out.print(str.getData());
		}
		System.out.println();
		return arrangedList;
	}

	public ArrayList<Element> arrange(Iterator<Element> iterator,
			ArrayList<Element> arrangedList) {
		ArrayList<Element> operator = new ArrayList<Element>();
		while (iterator.hasNext()) {
			Element element = iterator.next();
			if (element.isLeftBracket()) {
				ArrayList<Element> tempArrangedList = new ArrayList<Element>();
				arrange(iterator, tempArrangedList);
				arrangedList.addAll(tempArrangedList);
			} else if (element.isRightBracket()) {
				break;
			} else {
				pushElement(element, arrangedList, operator, iterator);
			}
		}
		pushOperator(operator, arrangedList);
		return arrangedList;
	}

	private void pushElement(Element element, ArrayList<Element> arrangedList,
			ArrayList<Element> operator, Iterator<Element> iterator) {
		if (element.isNumber()) {
			arrangedList.add(element);
		} else {
			if (!operator.isEmpty()
					&& !element.isPriority(operator.get(operator.size() - 1))) {
				pushOperator(operator, arrangedList);
			}
			operator.add(element);
		}
	}

	private void pushOperator(ArrayList<Element> operator,
			ArrayList<Element> arrangedList) {
		for (int i = operator.size() - 1; i >= 0; i--) {
			arrangedList.add(operator.get(i));
			operator.remove(i);
		}
	}
}
