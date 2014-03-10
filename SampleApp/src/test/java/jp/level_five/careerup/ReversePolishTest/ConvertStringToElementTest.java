package jp.level_five.careerup.ReversePolishTest;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import jp.level_five.careerup.ReversePolish.Element;
import jp.level_five.careerup.ReversePolish.ConvertStringToElement;

import org.junit.Before;
import org.junit.Test;

public class ConvertStringToElementTest {
	ConvertStringToElement cste ;
	
	private ArrayList<String> generateStringList(String[] values) {
		ArrayList<String> elementArray = new ArrayList<String>();
		for (int i = 0; i < values.length; ++i) {
			elementArray.add(new String(values[i]));
		}
		return elementArray;
	}
	
	private boolean checkEquivalence(String[] expected, ArrayList<Element> elementArray) {
		if (expected.length != elementArray.size()) {
			return false;
		}
		for (int i = 0; i < expected.length; ++i) {
			if (!expected[i].equals(elementArray.get(i).getData())) {
				return false;
			}
		}
		return true;
	}
	
	@Before
	public void before(){
		cste = new ConvertStringToElement();
	}
	
	@Test
	public void test文字列型の配列に入った５を渡すとElementのリストに入って返ってくる(){
		ArrayList<Element> elementArray = cste.convert(generateStringList(new String[]{"5"}));
		assertEquals("5", elementArray.get(0).getData());
	}
	@Test
	public void test２プラス３を渡すと２とプラスと３の順番で情報を持ったElementオブジェクトのリストに入って返ってくる(){
		ArrayList<Element> elementArray = cste.convert(generateStringList(new String[]{"2","+","3"}));
		assertEquals("2", elementArray.get(0).getData());
		assertEquals("+", elementArray.get(1).getData());
		assertEquals("3", elementArray.get(2).getData());
		}
	@Test
	public void test３まいなす１を渡すと３とマイナスと１の順番で情報を持ったElementオブジェクトのリストに入って返ってくる(){
		ArrayList<Element> elementArray = cste.convert(generateStringList(new String[]{"3","-","1"}));
		assertEquals("3", elementArray.get(0).getData());
		assertEquals("-", elementArray.get(1).getData());
		assertEquals("1", elementArray.get(2).getData());
		}
	@Test
	public void test３マイナス４かける３２割る９を入力すると入れた順番でElementオブジェクトのリストで返る(){
		ArrayList<Element> elementArray = cste.convert(generateStringList(new String[]{"4","*","32","/","9"}));
		assertEquals("4", elementArray.get(0).getData());
		assertEquals("*", elementArray.get(1).getData());
		assertEquals("32", elementArray.get(2).getData());
		assertEquals("/", elementArray.get(3).getData());
		assertEquals("9", elementArray.get(4).getData());
	}
	@Test
	public void test３かける前括弧４プラス５後括弧を入力すると入れた順のElementオブジェクトのリストで返す(){
		ArrayList<Element> elementArray = cste.convert(generateStringList(new String[]{"3","*","(","4","+","5",")"}));
		assertEquals("3", elementArray.get(0).getData());
		assertEquals("*", elementArray.get(1).getData());
		assertEquals("(", elementArray.get(2).getData());
		assertEquals("4", elementArray.get(3).getData());
		assertEquals("+", elementArray.get(4).getData());
		assertEquals("5", elementArray.get(5).getData());
		assertEquals(")", elementArray.get(6).getData());
	}
	@Test
	public void testマイナス前括弧マイナス１０かける前括弧マイナス２０後ろ括弧後括弧を入力をすると入れた順のElementオブジェクトのリストを返す(){
			ArrayList<Element> elementArray = cste.convert(generateStringList(new String[]{"-","(","-","10","*","(","-","20",")",")"}));
			assertEquals("-", elementArray.get(0).getData());
			assertEquals("(", elementArray.get(1).getData());
			assertEquals("-", elementArray.get(2).getData());
			assertEquals("10", elementArray.get(3).getData());
			assertEquals("*", elementArray.get(4).getData());
			assertEquals("(", elementArray.get(5).getData());
			assertEquals("-", elementArray.get(6).getData());
			assertEquals("20", elementArray.get(7).getData());
			assertEquals(")", elementArray.get(8).getData());
			assertEquals(")", elementArray.get(9).getData());
	}
	@Test
	public void testマイナスマイナスマイナスと入力するといれた順でElementオブジェクトのリストで返ってくる(){
		ArrayList<Element> elementArray = cste.convert(generateStringList(new String[]{"-","-","-"}));
		assertEquals("-", elementArray.get(0).getData());
		assertEquals("-", elementArray.get(1).getData());
		assertEquals("-", elementArray.get(2).getData());
	}
}
