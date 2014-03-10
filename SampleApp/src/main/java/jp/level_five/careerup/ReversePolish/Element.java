package jp.level_five.careerup.ReversePolish;

import java.util.regex.Pattern;

public class Element {
	private String data;
	private boolean isNumber;
	private boolean isLeftBracket = false;
	public Element(String string) {
		this.setUp(string);
	}

	public void setUp(String string) throws RuntimeException {
		if (Pattern.matches("-*[0-9]+", string)) {
			isNumber = true;
			data = string;
		} else if (Pattern.matches("[\\+\\-\\*\\/\\(\\)]", string)) {
			isNumber = false;
			data = string;
		} else {
			throw new RuntimeException();
		}
	}

	public String getData() {
		return data;
	}

	public boolean isNumber() {
		return isNumber;
	}

	public boolean isPriority(Element element) {
		if (Pattern.matches("[\\+\\-]", data)
				& Pattern.matches("[\\*\\/]", element.getData())) {
			return false;
		}
		return true;
	}

	public boolean isLeftBracket() {
		return "(".equals(data);
	}
	public boolean isRightBracket() {
		return ")".equals(data);
	}

}
