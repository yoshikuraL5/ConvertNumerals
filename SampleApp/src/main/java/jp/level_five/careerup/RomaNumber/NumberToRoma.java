package jp.level_five.careerup.RomaNumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NumberToRoma {

	public String convertNtoR(int i) {
		checkInput(i);
		String str = String.valueOf(i);
		char[] chararray = str.toCharArray();
		List<String> strarray = pushList(chararray);
		Iterator<String> iterator = strarray.iterator();
		str = replaceDigitsPlace(str, strarray, iterator);
		return str;
	}
	
	private void checkInput(int i) {
		if(!(0 < i & i < 4000))
		 throw new RuntimeException();
	}
	
	private List<String> pushList(char[] chararray) {
		List<String> strarray = new ArrayList<String>();
		for(int j = 0; j < chararray.length ; j++){
			strarray.add(String.valueOf(chararray[chararray.length-1-j]));
		}
		return strarray;
	}
	
	private String replaceDigitsPlace(String string, List<String> strarray, Iterator<String> iterator) {
		String[][] romanArray = new String[][]{
				{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
				{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
				{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
				{"", "M", "MM", "MMM", "", "", "", "", "", ""},};
		String str = replaceOnesPlace(strarray, iterator, romanArray, string);
		str = replaceTensPlace(strarray, iterator, romanArray, str);
		str = replaceHundredsPlace(strarray, iterator, romanArray, str);
		str = replaceThousandsPlace(strarray, iterator, romanArray, str);
		return str;
	}
	
	private String replaceOnesPlace(List<String> strarray, Iterator<String> iterator, String[][] romanArray, String str) {
		if(iterator.hasNext()){
			int number = Integer.parseInt(iterator.next());
			strarray.set(0, romanArray[0][number]);
			str = strarray.get(0);
			}
		return str;
	}
	
	private String replaceTensPlace(List<String> strarray, Iterator<String> iterator, String[][] romanArray, String str) {
		if(iterator.hasNext()){
		int number = Integer.parseInt(iterator.next());
		strarray.set(1, romanArray[1][number]);
		str = strarray.get(1) + str;
		}
		return str;
	}
	
	private String replaceHundredsPlace(List<String> strarray, Iterator<String> iterator, String[][] romanArray, String str) {
		if(iterator.hasNext()){
		int number = Integer.parseInt(iterator.next());
		strarray.set(2, romanArray[2][number]);
		str = strarray.get(2) + str;
		}
		return str;
	}
	
	private String replaceThousandsPlace(List<String> strarray, Iterator<String> iterator, String[][] romanArray, String str) {
		if(iterator.hasNext()){
		int number = Integer.parseInt(iterator.next());
		strarray.set(3, romanArray[3][number]);
		str = strarray.get(3) + str;
		}
		return str;
	}
}


	