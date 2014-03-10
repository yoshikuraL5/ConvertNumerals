package jp.level_five.careerup.ReversePolish;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class CopyClass {
	private ArrayList<Element> arrangedList = new ArrayList<Element>();
	private ArrayList<Element> operator = new ArrayList<Element>();
    boolean kakkonai = false;

	public ArrayList<Element> arrangeByReversePolish(ArrayList<Element> elementArray) {
		ArrayList<Element> kakkoOperator = new ArrayList<Element>();

		for (int i = 0; i < elementArray.size(); i++) {
			if (elementArray.get(i).isNumber()) {
				arrangedList.add(elementArray.get(i));
			} else {
				
				if(Pattern.matches("\\(", elementArray.get(i).getData())){
					kakkonai = true;
					//continue;
				}
				if(Pattern.matches("\\)", elementArray.get(i).getData())){
					kakkonai = false;
					for (int j = kakkoOperator.size() - 1; j >= 0; j--) {
						arrangedList.add(kakkoOperator.get(j));
						kakkoOperator.remove(j);
					}
					//continue;
				}
					
				if (operator.isEmpty()|| elementArray.get(i).isPriority(operator.get(operator.size() - 1))) {
					if(kakkonai == true){
						kakkoOperator.add(elementArray.get(i));
					}else {
					operator.add(elementArray.get(i));
					}
				} else {
					for (int j = operator.size() - 1; j >= 0; j--) {
						arrangedList.add(operator.get(j));
						operator.remove(j);
					}
					operator.add(elementArray.get(i));
				}
			}
		}
		for (int j = operator.size() - 1; j >= 0; j--) {
			arrangedList.add(operator.get(j));
			operator.remove(j);
		}
		
		return arrangedList;
	}
}

