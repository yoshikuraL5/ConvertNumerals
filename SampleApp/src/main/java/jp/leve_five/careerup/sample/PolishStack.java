package jp.leve_five.careerup.sample;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class PolishStack {
	private String[] array;
	ArrayList<Element> elementArray = new ArrayList<Element>();
	ArrayList<Element> arrangeElementArray = new ArrayList<Element>();

	public String[] split(String string){
		array = string.replaceAll("\\+", " + ").replaceAll("\\-", " - ")
				.replaceAll("\\*", " * ").replaceAll("\\/", " / ")
				.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").replaceAll("  ", " ")
				.trim().split(" ");
		return array;
	}
	

	public ArrayList<Element> convertStringToElement(){
		for(int i = 0; i < array.length; i++){
			elementArray.add(new Element(array[i]));
		}
		return elementArray;
	}


	public ArrayList<Element> arrangeElement() {
		ArrayList<Element> operator = new ArrayList<Element>();
		int max = elementArray.size();
		int Eleindex = 0;
		int opeindex = 0;
		for(int i = 0; i < max; i++){
			if(elementArray.get(i).elementTrue == true){
				arrangeElementArray.add(elementArray.get(i));
				Eleindex++;
			}else if(Pattern.matches("[¥*¥/]", elementArray.get(i).getData())){
				arrangeElementArray.add(elementArray.get(i+1));
				arrangeElementArray.add(elementArray.get(i));
				i++;
				Eleindex++;		
			}else if(elementArray.size() - i > 1 & Pattern.matches("[¥*¥/]", elementArray.get(i+2).getData())){
				arrangeElementArray.add(elementArray.get(i+1));
				arrangeElementArray.add(elementArray.get(i+3));
				arrangeElementArray.add(elementArray.get(i+2));
				arrangeElementArray.add(elementArray.get(i));
				i +=3;
			}else{
				arrangeElementArray.add(elementArray.get(i+1));
				arrangeElementArray.add(elementArray.get(i));
				i++;
			}
		}
		while(opeindex > 0){
			arrangeElementArray.add(operator.get(opeindex-1));
			opeindex--;
		}
		return arrangeElementArray;
	}
}
