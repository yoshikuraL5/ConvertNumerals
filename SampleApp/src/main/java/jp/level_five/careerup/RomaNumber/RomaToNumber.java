package jp.level_five.careerup.RomaNumber;

import java.util.regex.Pattern;

public class RomaToNumber {

	public int convert(String string) {
		char[] charArray = new char[20];
		int number = pushCharArray(string, charArray);
		for(int i=0; i <= charArray.length - 1; i++){
			number = valueI(charArray, number, i);
			number = valueV(charArray, number, i);
			number = valueX(charArray, number, i);
			number = valueL(charArray, number, i);
			number = valueC(charArray, number, i);
			number = valueD(charArray, number, i);
			number = valueM(charArray, number, i);
		 }
		checkString(number, string);
		return number;
	}

	protected int pushCharArray(String string, char[] charArray) {
		char[] charArray1 = string.toCharArray();
		int number = 0;
		for(int i=0; i <= charArray1.length - 1; i++){
			charArray[i] = charArray1[i];
		}
		return number;
	}

	private int valueI(char[] charArray, int number, int i) {
		if('I' == charArray[i]){
			number += 1;
			if(charArray.length > i & ('V' == charArray[i+1] | 'X' == charArray[i+1])){
				number -= 2;
			}else if(charArray.length > i+1  & ('V' == charArray[i+2] | 'X' == charArray[i+2])){
				throw new RuntimeException();
			}					
		}
		return number;
	}
	

	protected int valueV(char[] charArray, int number, int i) {
		if('V' == charArray[i]){
			number += 5;
		}
		return number;
	}

	private int valueX(char[] charArray, int number, int i) {
		if('X' == charArray[i]){
			number += 10;
			if(charArray.length > i  & ('L' == charArray[i+1] | 'C' == charArray[i+1] )){
				number -= 20;
			}else if(charArray.length+1 > i+1 & ('L' == charArray[i+2] | 'C' == charArray[i+2] )){
				throw new RuntimeException();
			}
		}
		return number;
	}	
	
	protected int valueL(char[] charArray, int number, int i) {
		if('L' == charArray[i]){
			number += 50;
		}
		return number;
	}

	private int valueC(char[] charArray, int number, int i) {
		if('C' == charArray[i]){
			number += 100;
			if(charArray.length > i  & ('D' == charArray[i+1] | 'M' == charArray[i+1])){
				number -= 200;
			}else if(charArray.length+1 > i+1  & ('D' == charArray[i+2] | 'M' == charArray[i+2])){
				throw new RuntimeException();
			}
		}
		return number;
	}

	protected int valueD(char[] charArray, int number, int i) {
		if('D' == charArray[i]){
			number += 500;
		}
		return number;
	}

	protected int valueM(char[] charArray, int number, int i) {
		if('M' == charArray[i]){
			number += 1000;
		}
		return number;
	}

	private void checkString(int i, String string) {
		if((i < 1 || 3999 < i) 
			|| Pattern.matches(".*[IVXLD]M.*", string) 
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
