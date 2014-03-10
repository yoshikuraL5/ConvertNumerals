package jp.level_five.careerup.ReversePolish;

import java.util.ArrayList;
import jp.level_five.careerup.ReversePolish.Element;



public class ConvertStringToElement {
	private ArrayList<String> array;
	ArrayList<Element> elementArray = new ArrayList<Element>();
	
	public ArrayList<Element> convert(ArrayList<String> stringarray){
		array = stringarray;
		for(int i = 0; i < array.size(); i++){
			elementArray.add(new Element(array.get(i)));
		}
		for(Element ele: elementArray){
		System.out.print(ele.getData()+" ");
		}
		System.out.println();
		
		
		return elementArray;
	}


}
