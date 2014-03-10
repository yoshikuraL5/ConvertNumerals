package jp.level_five.careerup.ReversePolishTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import jp.level_five.careerup.ReversePolish.StringSplit;

import org.junit.Before;
import org.junit.Test;

public class StringSplitTest {
	StringSplit stringsplit;
	@Before
	public void before(){
		stringsplit = new StringSplit();
	}
	@Test
	public void test文字列で１プラス２を渡すと文字列型の配列で１とプラスと２が返ってくる() {
		ArrayList<String> array =  stringsplit.split("1+2");
		assertEquals("1", array.get(0));
		assertEquals("+", array.get(1));
		assertEquals("2", array.get(2));
	}
	@Test
	public void test文字列マイナス３プラス８を渡すと文字列型の配列でマイナス３とプラスと８が返ってくる() {
		ArrayList<String> array =  stringsplit.split("-3+8");
		assertEquals("-3", array.get(0));
		assertEquals("+", array.get(1));
		assertEquals("8", array.get(2));
	}
	@Test
	public void test文字列マイナス5アスタリスクマイナス3を渡すと文字列型の配列でマイナス３とプラスと８が返ってくる() {
		ArrayList<String> array =  stringsplit.split("-5*(-3)");
		assertEquals("-5", array.get(0));
		assertEquals("*", array.get(1));
		assertEquals("(", array.get(2));
		assertEquals("-3", array.get(3));
		assertEquals(")", array.get(4));
	}

}
