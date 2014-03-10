package jp.level_five.careerup.ReversePolishTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import jp.level_five.careerup.ReversePolish.Element;


import org.junit.Test;

public class ElementTest {
	
	@Test(expected = RuntimeException.class)
	public void test文字列であを渡したときに例外が発生する() {
		 new Element("あ");
	}
	
	@Test(expected = RuntimeException.class)
	public void test文字列でaを渡したときに例外が発生する() {
		new Element("a");
	}
	
	@Test
	public void test文字列でプラスを渡したとき例外が発生しない(){
		new Element("+");
	}
	@Test(expected = RuntimeException.class)
	public void test文字列でプラスアスタリスクを渡したときに例外が発生する(){
		new Element("+*");
	}
	@Test
	public void test9を持ったElementオブジェクトのisNumberはtrueを返す(){
		Element element = new Element("9");
		boolean isNumber = element.isNumber();
		assertTrue(isNumber);
	}
	@Test
	public void testマイナス9を持ったElementオブジェクトのisNumberはtrueを返す(){
		Element element = new Element("-9");
		boolean isNumber = element.isNumber();
		assertTrue(isNumber);
	}
	@Test
	public void testプラスを持ったElementオブジェクトのisNumberはfalseを返す(){
		Element element = new Element("+");
		boolean isNumber = element.isNumber();
		assertEquals(false, isNumber);
	}
	@Test
	public void testマイナスを持ったElementオブジェクトのisNumberはfalseを返す(){
		Element element = new Element("-");
		boolean isNumber = element.isNumber();
		assertEquals(false, isNumber);
	}
	@Test
	public void test100を持ったElementオブジェクトのisNumberはtrueを返す(){
		Element element = new Element("100");
		boolean isNumber = element.isNumber();
		assertTrue(isNumber);
	}
	@Test
	public void testアスタリスクを持ったElementオブジェクトのisPriorityはプラスを持ったElementオブジェクトを引数に与えるとtrueを返す(){
		Element element = new Element("*");
		Element newoperator = new Element("+");
		boolean goOut = element.isPriority(newoperator);
		assertTrue(goOut);
	}
	
	@Test
	public void test開き括弧のElementはisLeftBracketはtrueを返す() {
		Element element = new Element("(");
		assertTrue(element.isLeftBracket());
	}	
	@Test
	public void test数字のElementはisLeftBracketはfalseを返す() {
		Element element = new Element("0");
		assertTrue(!element.isLeftBracket());
	}
	@Test
	public void test演算子のElementはisLeftBracketはfalseを返す() {
		Element element = new Element("+");
		assertTrue(!element.isLeftBracket());
	}
	@Test
	public void test開き括弧のElementはisRightBracketはtrueを返す() {
		Element element = new Element(")");
		assertTrue(element.isRightBracket());
	}	
	@Test
	public void test数字のElementはisRightBracketはfalseを返す() {
		Element element = new Element("0");
		assertTrue(!element.isRightBracket());
	}
	@Test
	public void test演算子のElementはisRightBracketはfalseを返す() {
		Element element = new Element("+");
		assertTrue(!element.isRightBracket());
	}
	@Test(expected=RuntimeException.class)
	public void testXXX() {
		new Element("+*");
	}
	
}
