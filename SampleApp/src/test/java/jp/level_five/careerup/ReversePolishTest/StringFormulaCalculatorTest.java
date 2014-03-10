package jp.level_five.careerup.ReversePolishTest;

import static org.junit.Assert.*;
import jp.level_five.careerup.ReversePolish.StringFormulaCalculator;

import org.junit.Test;

public class StringFormulaCalculatorTest {

	@Test
	public void test文字列で１プラス２を入力すると３が文字列で返ってくる() {
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		String answer = stringFormulaCalculator.resultOutput("1+2");
		assertEquals("3", answer);
	}
	@Test
	public void test文字列で4アスタリスク5マイナス１０を入力すると１０が返ってくる(){
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		String answer = stringFormulaCalculator.resultOutput("4*5-10");
		assertEquals("10", answer);
	}
	@Test(expected = ArithmeticException.class)
	public void test文字列で４スラッシュ０を入力すると例外が発生する(){
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		stringFormulaCalculator.resultOutput("4/0");
	}
	@Test
	public void test文字列でマイナス３プラス８を入力すると５が返ってくる(){
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		String answer = stringFormulaCalculator.resultOutput("-3+8");
		assertEquals("5", answer);
	}
	@Test
	public void test文字列で括弧１プラス３アスタリスク５を入力すると20が返ってくる(){
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		String answer = stringFormulaCalculator.resultOutput("(1+3)*5");
		assertEquals("20", answer);
	}
	@Test
	public void test文字列でマイナス５アスタリスク括弧マイナス６を入力すると30が返ってくる(){
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		String answer = stringFormulaCalculator.resultOutput("-5*(-6)");
		assertEquals("30", answer);
	}
	@Test
	public void test文字列で括弧１プラス括弧２アスタリスク３マイナス４アスタリスク５を入力すると15が返ってくる(){
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		String answer = stringFormulaCalculator.resultOutput("(1+(2*3-4))*5");
		assertEquals("15", answer);
	}
	@Test
	public void test５スラッシュ３を入力すると１が返ってくる(){
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		String answer = stringFormulaCalculator.resultOutput("5/3");
		assertEquals("1", answer);
	}
//	@Test
//	public void test５スラッシュ３アスタリスク３を入力すると１が返ってくる(){
//		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
//		String answer = stringFormulaCalculator.resultOutput("5/3*3");
//		assertEquals("3", answer);
//	}
	@Test(expected = ArithmeticException.class)
	public void test５スラッシュ括弧３マイナス３括弧を入力すると例外エラーが返ってくる(){
		StringFormulaCalculator stringFormulaCalculator = new StringFormulaCalculator();
		stringFormulaCalculator.resultOutput("5/(3-3)");
	}
}
