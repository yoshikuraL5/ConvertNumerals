package jp.level_five.careerup.RomaNumber;

import java.util.regex.Pattern;

public class RomaToNumber {

	public int convert(String string) {
		char[] charArray = new char[20];
		int number = 0;
		pushCharArray(string, charArray);
		for (int i = 0; i <= charArray.length - 1; i++) {
			number += valueI(charArray, i) + valueV(charArray, i)
					+ valueX(charArray, i) + valueL(charArray, i)
					+ valueC(charArray, i) + valueD(charArray, i)
					+ valueM(charArray, i);
		}
		checkString(number, string);
		return number;
	}

	protected void pushCharArray(String string, char[] charArray) {
		char[] charArray1 = string.toCharArray();
		for (int i = 0; i <= charArray1.length - 1; i++) {
			charArray[i] = charArray1[i];
		}
	}

	private int valueI(char[] charArray, int i) {
		if ('I' == charArray[i]) {
			if (charArray.length > i
					& ('V' == charArray[i + 1] | 'X' == charArray[i + 1])) {
				return -1;
			} else if (charArray.length > i + 1
					& ('V' == charArray[i + 2] | 'X' == charArray[i + 2])) {
				throw new RuntimeException();
			}
			return 1;
		}
		return 0;
	}

	protected int valueV(char[] charArray, int i) {
		if ('V' == charArray[i]) {
			return 5;
		}
		return 0;
	}

	private int valueX(char[] charArray, int i) {
		if ('X' == charArray[i]) {
			if (charArray.length > i
					& ('L' == charArray[i + 1] | 'C' == charArray[i + 1])) {
				return -10;
			} else if (charArray.length + 1 > i + 1
					& ('L' == charArray[i + 2] | 'C' == charArray[i + 2])) {
				throw new RuntimeException();
			}
			return 10;
		}
		return 0;
	}

	protected int valueL(char[] charArray, int i) {
		if ('L' == charArray[i]) {
			return 50;
		}
		return 0;
	}

	private int valueC(char[] charArray, int i) {
		if ('C' == charArray[i]) {
			if (charArray.length > i
					& ('D' == charArray[i + 1] | 'M' == charArray[i + 1])) {
				return -100;
			} else if (charArray.length + 1 > i + 1
					& ('D' == charArray[i + 2] | 'M' == charArray[i + 2])) {
				throw new RuntimeException();
			}
			return 100;
		}
		return 0;
	}

	protected int valueD(char[] charArray, int i) {
		if ('D' == charArray[i]) {
			return 500;
		}
		return 0;
	}

	protected int valueM(char[] charArray, int i) {
		if ('M' == charArray[i]) {
			return 1000;
		}
		return 0;
	}

	private void checkString(int i, String string) {
		if ((i < 1 || 3999 < i) || Pattern.matches(".*[IVXLD]M.*", string)
				|| Pattern.matches(".*[IVXL]D.*", string)
				|| Pattern.matches(".*[IVL]C.*", string)
				|| Pattern.matches(".*[IV]L.*", string)
				|| Pattern.matches(".*VX.*", string)
				|| Pattern.matches(".*I{4,}.*", string)
				|| Pattern.matches(".*V{2,}.*", string)
				|| Pattern.matches(".*X{4,}.*", string)
				|| Pattern.matches(".*L{2,}.*", string)
				|| Pattern.matches(".*C{4,}.*", string)
				|| Pattern.matches(".*D{2,}.*", string)
				|| Pattern.matches(".*M{4,}.*", string))
			throw new RuntimeException();
	}
}
