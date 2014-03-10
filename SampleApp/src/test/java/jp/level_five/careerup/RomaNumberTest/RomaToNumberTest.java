package jp.level_five.careerup.RomaNumberTest;

import static org.junit.Assert.*;

import jp.level_five.careerup.RomaNumber.RomaToNumberExpansion;

import org.junit.Before;
import org.junit.Test;
public class RomaToNumberTest {
	RomaToNumberExpansion convertRtoN;
	
	@Before
	public void setUp(){
		convertRtoN = new RomaToNumberExpansion();
	}
/*--【拡張機能】
    IIII等の４文字の表記（I,X,Cに限る）、
    IM,IL,IIV等の減算の特例(I,X,Cに限る)IIIIVのような使い方は４つまで
    （ただし、V,L,Dは１回のみの使用、Mは３回までの使用しか認めない）
    上記を使用した１〜３９９９までの数字を表す場合には
    メソッドのconvertにexを入力してから、数字に変えたい文字を入力
    (例えばconvert("ex", "ローマ数字"))してください。 --*/
	@Test
	public void testストリング型の文字列Iを渡すと数字型の数値1が返ってくる() {
		int number = convertRtoN.convert("I");
		assertEquals(1,number);
	}
	@Test
	public void test文字列のIIを渡すと数字で２が返ってくる (){
		int number = convertRtoN.convert("II");
		assertEquals(2, number);
	}
	@Test
	public void test文字列のVを渡すと数字で５が返ってくる(){
		int number = convertRtoN.convert("V");
		assertEquals(5, number);
	}
	@Test
	public void test文字列のXを渡すと数字で１０が返ってくる(){
		int number = convertRtoN.convert("X");
		assertEquals(10, number);
	}
	@Test
	public void test文字列のLを渡すと数字で５０が返ってくる(){
		int number = convertRtoN.convert("L");
		assertEquals(50, number);
	}
	@Test
	public void test文字列のCを渡すと数字で１００が返ってくる(){
		int number = convertRtoN.convert("C");
		assertEquals(100, number);
	}
	@Test
	public void test文字列のDを渡すと数字で５００が返ってくる(){
		int number = convertRtoN.convert("D");
		assertEquals(500, number);
	}
	@Test
	public void test文字列のMを渡すと数字で１０００が返ってくる(){
		int number = convertRtoN.convert("M");
		assertEquals(1000, number);
	}
	@Test
	public void test文字列のVIを渡すと数字で６が返ってくる(){
		int number = convertRtoN.convert("VI");
		assertEquals(6, number);
	}
	@Test
	public void test文字列のIVを渡すと数字で4が返ってくる(){
		int number = convertRtoN.convert("IV");
		assertEquals(4, number);
	}
	@Test(expected = RuntimeException.class)
	public void test文字列のIIVを渡すと例外が発生する(){
		convertRtoN.convert("IIV");
	}
	@Test
	public void test拡張機能をつけるとIIVは３を返す(){
		int number = convertRtoN.convert("ex", "IIV");
		assertEquals(3, number);
	}
	@Test(expected = RuntimeException.class)
	public void test拡張機能をつけてもIIIIIXを渡すと例外が発生する(){
		convertRtoN.convert("ex", "IIIIIX");
	}
	@Test(expected = RuntimeException.class)
	public void test文字列のIMを渡すと例外が発生する(){
		convertRtoN.convert("IM");
	}
	@Test
	public void test拡張機能をつけるとIMは９９９を返す(){
		int number = convertRtoN.convert("ex", "IM");
		assertEquals(999, number);
	}
	@Test
	public void test文字列のXLを渡すと数字で４０が返ってくる(){
		int number = convertRtoN.convert("XL");
		assertEquals(40, number);
	}
	@Test
	public void test文字列のLXを渡すと数字で６０が返ってくる(){
		int number = convertRtoN.convert("LX");
		assertEquals(60, number);
	}
	@Test
	public void test文字列のDCCCを渡すと数字で８００が返ってくる(){
		int number = convertRtoN.convert("DCCC");
		assertEquals(800, number);
	}
	@Test(expected = RuntimeException.class)
	public void test文字列のAを渡すと例外が発生する(){
		convertRtoN.convert("A");
	}
	@Test(expected = RuntimeException.class)
	public void test文字列の1を渡すと例外が発生する(){
		convertRtoN.convert("1");
	}
	@Test(expected = RuntimeException.class)
	public void test文字列のIIIIを渡すと例外が発生する(){
		convertRtoN.convert("IIII");
	}
	@Test
	public void test拡張機能をつけるとIIIIは４を返す(){
		int number = convertRtoN.convert("ex", "IIII");
		assertEquals(4, number);
	}
	@Test
	public void test文字列のMMMDCCCLXXXVIIIを渡すと数字で3888が返ってくる (){
		int number = convertRtoN.convert("MMMDCCCLXXXVIII");
		assertEquals(3888, number);
	}
	@Test
	public void test文字列のMMMCMXCIXを渡すと数字で3999が返ってくる (){
		int number = convertRtoN.convert("MMMCMXCIX");
		assertEquals(3999, number);
	}
	@Test(expected = RuntimeException.class)
	public void test文字列のMMMMを渡すと例外が発生する (){
		convertRtoN.convert("MMMM");
	}
	@Test
	public void test拡張機能をつけるとIIMは９９８を返す(){
		int number = convertRtoN.convert("ex", "IIM");
		assertEquals(998, number);
	}
	@Test
	public void test拡張機能をつけるXDは490を返す(){
		int number = convertRtoN.convert("ex", "XD");
		assertEquals(490, number);
	}
	@Test
	public void test拡張機能をつけるとXXXXDは460を返す(){
		int number = convertRtoN.convert("ex", "XXXXD");
		assertEquals(460, number);
	}
	@Test
	public void test拡張機能をつけるとCCDは300を返す(){
		int number = convertRtoN.convert("ex", "CCD");
		assertEquals(300, number);
	}	
	@Test(expected = RuntimeException.class)
	public void test文字列のMCCMを渡すと例外が発生する(){
		convertRtoN.convert("MCCM");
	}
}
