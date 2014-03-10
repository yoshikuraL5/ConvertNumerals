package jp.level_five.careerup.ReversePolish;

import java.util.ArrayList;
import java.util.regex.Pattern;




public class StringSplit {
	
	

	public ArrayList<String> split(String string){
		String[] array;
		
		array = string.replaceAll("\\+", " + ").replaceAll("\\-", " - ")
				.replaceAll("\\*", " * ").replaceAll("\\/", " / ")
				.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ")
				.replaceAll("  ", " ").trim().split(" ");
		
		ArrayList<String> stringList = new ArrayList<String>();
		for (int i = 0; i <= array.length - 1; i++){
			stringList.add(array[i]);
		}
		
		if("-".equals(stringList.get(0))){
			System.out.println(stringList.get(0));
			stringList.remove(0);
			stringList.set(0, "-" + stringList.get(0));
			System.out.println(stringList.get(0));
		}
		for (int i = 0; i < stringList.size() - 1; i++){
			if(stringList.get(i).equals("(") && stringList.get(i+1).equals("-")){
				stringList.remove(i+1);
				stringList.set(i+1, "-" + stringList.get(i+1));
			}
		}
		
		return stringList;
	}

}
