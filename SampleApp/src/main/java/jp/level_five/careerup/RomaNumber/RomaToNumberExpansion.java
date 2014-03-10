package jp.level_five.careerup.RomaNumber;

import java.util.regex.Pattern;

public class RomaToNumberExpansion extends RomaToNumber{
	
	public int convert(String str, String string) {
		char[] charArray = new char[20];
		int number = super.pushCharArray(string, charArray);
		for(int i=0; i <= charArray.length - 1; i++){
			number = valueIexpand(charArray, number, i);
			number = valueV(charArray, number, i);
			number = valueXexpand(charArray, number, i);
			number = valueL(charArray, number, i);
			number = valueCexpand(charArray, number, i);
			number = valueD(charArray, number, i);
			number = valueM(charArray, number, i);
		 }
		checkStringExpand(number, string);
		return number;
	}
	
	private int valueIexpand(char[] charArray, int number, int i) {
		if('I' == charArray[i]){
			number += 1;
			if(charArray.length > i & ('V' == charArray[i+1] | 'X' == charArray[i+1] | 'L' == charArray[i+1] | 'C' == charArray[i+1] | 'D' == charArray[i+1] | 'M' == charArray[i+1])){
				number -= 2;
			}else if(charArray.length+1 > i & ('V' == charArray[i+2] | 'X' == charArray[i+2] | 'L' == charArray[i+2] | 'C' == charArray[i+2] | 'D' == charArray[i+2] | 'M' == charArray[i+2])){
				number -= 2;
			}else if(charArray.length+2 > i & ('V' == charArray[i+3] | 'X' == charArray[i+3] | 'L' == charArray[i+3] | 'C' == charArray[i+3] | 'D' == charArray[i+3] | 'M' == charArray[i+3])){
				number -= 2;
			}else if(charArray.length+3 > i & ('V' == charArray[i+4] | 'X' == charArray[i+4] | 'L' == charArray[i+4] | 'C' == charArray[i+4] | 'D' == charArray[i+4] | 'M' == charArray[i+4])){	
				number -= 2;
			}else if(charArray.length+4 > i & ('V' == charArray[i+5] | 'X' == charArray[i+5] | 'L' == charArray[i+5] | 'C' == charArray[i+5] | 'D' == charArray[i+5] | 'M' == charArray[i+5])){
				throw new RuntimeException();
			}					
		}
		return number;
	}

	private int valueXexpand(char[] charArray, int number, int i) {
		if('X' == charArray[i]){
			number += 10;
			if(charArray.length > i  & ('L' == charArray[i+1] | 'C' == charArray[i+1] | 'D' == charArray[i+1] | 'M' == charArray[i+1])){
				number -= 20;				
			}else if(charArray.length+1 > i+1 & ('L' == charArray[i+2] | 'C' == charArray[i+2] | 'D' == charArray[i+2] | 'M' == charArray[i+2])){
				number -= 20;
			}else if(charArray.length+2 > i+1 & ('L' == charArray[i+3] | 'C' == charArray[i+3] | 'D' == charArray[i+3] | 'M' == charArray[i+3])){
				number -= 20;
			}else if(charArray.length+3 > i+1 & ('L' == charArray[i+4] | 'C' == charArray[i+4] | 'D' == charArray[i+4] | 'M' == charArray[i+4])){
				number -= 20;
			}else if(charArray.length+4 > i+1 & ('L' == charArray[i+5] | 'C' == charArray[i+5] | 'D' == charArray[i+5] | 'M' == charArray[i+5])){				
				throw new RuntimeException();
			}
		}
		return number;
	}	

	private int valueCexpand(char[] charArray, int number, int i) {
		if('C' == charArray[i]){
			number += 100;
			if(charArray.length > i  & ('D' == charArray[i+1] | 'M' == charArray[i+1])){
				number -= 200;
			}else if(charArray.length+1 > i+1  & ('D' == charArray[i+2] | 'M' == charArray[i+2])){
				number -= 200;
			}else if(charArray.length+2 > i+1  & ('D' == charArray[i+3] | 'M' == charArray[i+3])){
				number -= 200;
			}else if(charArray.length+3 > i+1  & ('D' == charArray[i+4] | 'M' == charArray[i+4])){
				number -= 200;
			}else if(charArray.length+4 > i+1  & ('D' == charArray[i+5] | 'M' == charArray[i+5])){
				throw new RuntimeException();
			}
		}
		return number;
	}

	private void checkStringExpand(int i, String string) {
		if((i < 1 || 3999 < i) 
			|| Pattern.matches(".*[VLD]M.*", string) 
			|| Pattern.matches(".*[VL]D.*", string)
			|| Pattern.matches(".*[VL]C.*", string)
			|| Pattern.matches(".*[V]L.*", string)
			|| Pattern.matches(".*VX.*", string)
			|| Pattern.matches(".*I{5,}.*", string)
			|| Pattern.matches(".*V{2,}.*", string)
			|| Pattern.matches(".*X{5,}.*", string)
			|| Pattern.matches(".*L{2,}.*", string)
			|| Pattern.matches(".*C{5,}.*", string)
			|| Pattern.matches(".*D{2,}.*", string)
			|| Pattern.matches(".*M{4,}.*", string))
			throw new RuntimeException();
	}
}
