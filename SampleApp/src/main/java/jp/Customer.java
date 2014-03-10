package jp;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	@SuppressWarnings("rawtypes")
	private Vector _rentals = new Vector();
	
	public Customer (String name){
		_name = name;
	}
	@SuppressWarnings("unchecked")
	public void addRental(Rental arg){
		_rentals.addElement(arg);	
	}
	public String getName(){
		return _name;
	}
	public String statement (){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		@SuppressWarnings("rawtypes")
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for "+getName() + "\n";
		while (rentals.hasMoreElements()){
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			
			//一行ごとに金額を計算
			switch (each.getMovie().getPriceCode()){
			case Movie.REGULAR:
				thisAmount += 2;
				if(each.getDayRented() > 2)
					thisAmount += (each.getDayRented() -2 )*1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDayRented()*3;
				break;
			case Movie .CHILDRENS:
				thisAmount += 1.5;
				if(each.getDayRented() >3)
                     thisAmount += (each.getDayRented() -3)*1.5;
				break;
                  
			}
			//レンタルポイントを加算
			frequentRenterPoints ++;
			//新作を二日以上借りた場合はボーナスポイント
//			if((each.getMoive().getPriceCode() == Moive.NEW_RELEASE)&&
//					each.getDayRented() > 1)frequentRenterPoints ++;
			//この貸し出しに関する数値の表示
		}
		return "";				
	}
}	
