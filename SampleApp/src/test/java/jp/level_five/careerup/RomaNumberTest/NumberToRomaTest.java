package jp.level_five.careerup.RomaNumberTest;

import static org.junit.Assert.*;
import jp.level_five.careerup.RomaNumber.NumberToRoma;

import org.junit.Before;
import org.junit.Test;

public class NumberToRomaTest {
	NumberToRoma numberToRoma;

	@Before
	public void setUp(){
		numberToRoma = new NumberToRoma();	
	}
	
	//半角数字を入力しないとコンパイルも通らない
	@Test
	public void 半角数字で１を渡す文字列でIが返ってくる(){
		String str = numberToRoma.convertNtoR(1);
		assertEquals("I", str);
	}
	@Test
	public void test半角数字の２を渡すと文字列でIIが返ってくる(){
		String str = numberToRoma.convertNtoR(2);
		assertEquals("II", str);
	}
	@Test
	public void test半角数字の５を渡すと文字列でVが返ってくる(){
		String str = numberToRoma.convertNtoR(5);
		assertEquals("V", str);
	}
	@Test
	public void test半角数字の９を渡すと文字列でIXが返ってくる(){
		String str = numberToRoma.convertNtoR(9);
		assertEquals("IX", str);
	}
	@Test(expected = RuntimeException.class)
	public void test半角数字の０を渡すと例外が発生する(){
		numberToRoma.convertNtoR(0);
	}
	@Test
	public void test半角数字の１０を渡すと文字列でXが返ってくる(){
		String str = numberToRoma.convertNtoR(10);
		assertEquals("X", str);
	}
	@Test
	public void test半角数字1111を渡す文字列でMCXIが返ってくる(){
		String str = numberToRoma.convertNtoR(1111);
		assertEquals("MCXI", str);
	}
	@Test
	public void test半角数字3888を渡す文字列でMMMDCCCLXXXVIIIが返ってくる(){
		String str = numberToRoma.convertNtoR(3888);
		assertEquals("MMMDCCCLXXXVIII", str);
	}
	@Test
	public void test半角数字3999を渡す文字列でMMMCMXCIXが返ってくる(){
		String str = numberToRoma.convertNtoR(3999);
		assertEquals("MMMCMXCIX", str);
	}
	@Test(expected = RuntimeException.class)
	public void test半角数字の4000を渡すと例外が発生する(){
		numberToRoma.convertNtoR(4000);
	}
	@Test 
	public void test半角数字の1888を渡すとMDCCCLXXXVIIIが返ってくる(){
		String str = numberToRoma.convertNtoR(1888);
		assertEquals("MDCCCLXXXVIII", str);
	}
	@Test 
	public void test半角数字の31を渡すとXXXIが返ってくる(){
		String str = numberToRoma.convertNtoR(31);
		assertEquals("XXXI", str);
	}
}
