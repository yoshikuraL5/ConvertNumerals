package jp.level_five.careerup.ReversePolish;

import java.util.ArrayList;

public class StringFormulaCalculator {

	public String resultOutput(String string) {
		StringSplit stringSplit = new StringSplit();
		ArrayList<String> array = stringSplit.split(string);

		ConvertStringToElement convertStringToElement = new ConvertStringToElement();
		ArrayList<Element> elementArray = convertStringToElement.convert(array);

		ElementArranger elementArranger = new ElementArranger();
		elementArray = elementArranger.arrangeByReversePolish(elementArray);

		Calculator calculator = new Calculator();
		string = calculator.calc(elementArray).getData();

		return string;
	}

}
