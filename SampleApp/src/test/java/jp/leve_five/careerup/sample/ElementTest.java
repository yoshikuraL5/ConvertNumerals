package jp.leve_five.careerup.sample;

import org.junit.Test;

public class ElementTest {

//	@Test
//	public void test文字列で１を渡したとき数字の１が返ってくる(){
//		Element element = new Element("1");
//		int result = element.numberChange("１");
//		assertEquals(1, result);
//		
//	}
//	@Test
//	public void test文字列でマイナス１０を渡したとき数字のマイナス１０が返ってくる(){
//		Element element = new Element("-10");
//		int result = element.numberChange("-10");
//		assertEquals(-10, result);
//	}
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
	
	
}
