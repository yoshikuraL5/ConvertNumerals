package jp;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	
	private String _title;
	@SuppressWarnings("unused")
	private int _priceCode;
	
	public Movie(String title , int priceCode){
		_title = title;
		_priceCode = priceCode;	
	}
	public int getPriceCode(){
		return 0;
//		return _priceCode = arg;
	}
	public String getTitle(){
		return _title;
	}

}
