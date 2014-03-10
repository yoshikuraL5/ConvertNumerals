package jp.leve_five.careerup.sample;

import java.util.regex.Pattern;


public class Element {
	private String element ;
	public boolean elementTrue;
	
	public Element(String string){
		this.checker(string);
	}
	

	public void checker(String string)throws RuntimeException {
		if(Pattern.matches("-*[0-9]*", string)) {
			elementTrue = true;
			element = string;
		}else if(Pattern.matches("[¥+¥-¥*¥/()]", string)){
			elementTrue = false;
			element = string;
		}else{
			throw new RuntimeException();
		}
	}
	public String getData(){
		return element;
	}


}
