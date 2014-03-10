package jp.level_five.careerup.ReversePolishTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import jp.level_five.careerup.ReversePolish.Calculator;
import jp.level_five.careerup.ReversePolish.Element;

public class CalculatorTest{
	Calculator calculator;
	@Before
	public void before(){
		calculator = new Calculator();
	}
	
	private ArrayList<Element> generateElementList(String[] values) {
		ArrayList<Element> elementArray = new ArrayList<Element>();
		for (int i = 0; i < values.length; ++i) {
			elementArray.add(new Element(values[i]));
		}
		return elementArray;
	}
	@Test
	public void test３５プラスのElement型のリストに対してCalculatorクラスは８のオブジェクトで返す(){
		ArrayList<Element> arrangedArray = generateElementList(new String[] { "3", "5","+" });
		Element result = calculator.calc(arrangedArray);
		assertEquals("8", result.getData());
	}
	@Test
	public void test104プラスのElement型のリストに対してCalculatorクラスは14のオブジェクトを返す(){
		ArrayList<Element> arrangendArray = generateElementList(new String[]{"10", "4", "+"});
		Element result = calculator.calc(arrangendArray);
		assertEquals("14", result.getData());
	}
	@Test 
	public void test５３マイナスのElement型のリストに対してCalculatorクラスは２のオブジェクトを返す(){
		ArrayList<Element> arrangendArray = generateElementList(new String[]{"5", "3", "-"});
		Element result = calculator.calc(arrangendArray);
		assertEquals("2", result.getData());
	}
	@Test 
	public void test５３アスタリスクのElement型のリストに対してCalculatorクラスは１５オブジェクトを返す(){
		ArrayList<Element> arrangendArray = generateElementList(new String[]{"5", "3", "*"});
		Element result = calculator.calc(arrangendArray);
		assertEquals("15", result.getData());
	}
	@Test
	public void test105スラッシュのElement型のリストに対してCalculatorクラスは２のオブジェクトを返す(){
		ArrayList<Element> arrangendArray = generateElementList(new String[]{"10", "5", "/"});
		Element result = calculator.calc(arrangendArray);
		assertEquals("2", result.getData());
	}
	@Test
	public void test５３２プラスプラスのElement型のリストに対してCalculatorクラスは１０のオブジェクトを返す (){
		ArrayList<Element> arrangedArray = generateElementList(new String[]{"5", "3", "2", "+", "+"});
		Element result = calculator.calc(arrangedArray);
		assertEquals("10", result.getData());
	}
	@Test
	public void test８４５アスタリスクプラスのElement型のリストに対してCalculatorクラスは２８のオブジェクトを返す (){
		ArrayList<Element> arrangedArray = generateElementList(new String[]{"8", "4", "5", "*", "+"});
		Element result = calculator.calc(arrangedArray);
		assertEquals("28", result.getData());
	}
	@Test
	public void test３のElement型のリストに対してCalculatorクラスは３を返す(){
		ArrayList<Element> arrangedArray = generateElementList(new String[]{"3"});
		Element result = calculator.calc(arrangedArray);
		assertEquals("3", result.getData());
	}
	@Test (expected = ArithmeticException.class)
	public void test３０スラッシュのElement型のリストに対してCalculatorクラスは例外を返す(){
		ArrayList<Element> arrangedArray = generateElementList(new String[]{"3", "0", "/"});
		calculator.calc(arrangedArray);
	}
	@Test
	public void test７８９アスタリスクプラスのElement型のリストに対してCalculatorクラスは７９のオブジェクトを返す (){
		ArrayList<Element> arrangedArray = generateElementList(new String[]{"7", "8", "9", "*", "+"});
		Element result = calculator.calc(arrangedArray);
		assertEquals("79", result.getData());
	}
	@Test(expected = EmptyStackException.class)
	public void test４プラスプラスのElement型のリストに対してCalculatorクラスはオペレーターが足りないので例外が発生する(){
		ArrayList<Element> arrangedArray = generateElementList(new String[]{"4", "3", "+", "+"});
		calculator.calc(arrangedArray);	
	}
}

