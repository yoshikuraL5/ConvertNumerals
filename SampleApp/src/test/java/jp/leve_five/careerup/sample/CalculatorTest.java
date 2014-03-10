package jp.leve_five.careerup.sample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	Calculator calc ;
	
	@Before 
	public void initialize(){ 
	calc = new Calculator();
	}
	 
	@Test
	public void test１たす２は３になる() {
		int result = calc.plus(1, 2);
		assertEquals(3, result);
	}
	@Test
	public void test2たす3は５になる(){
	    int result = calc.plus(2, 3);
		assertEquals(result ,5);
	}
	@Test
	public void test２ひく１は１になる(){
		int result = calc.minus(2, 1);
		assertEquals(result ,1);		
	}
	@Test
	public void test10ひく５は５になる(){
		int result = calc.minus(10, 5);
		assertEquals(result, 5);
	}
	@Test
	public void test２かける３は６になる(){
		int result = calc.multiply(2, 3);
		assertEquals(6, result);
	}
	@Test
	public void test１０かける１０は１００になる(){
		int result = calc.multiply(10, 10);
		assertEquals(100, result);
	}
	@Test
	public void test４わる２は２になる(){
		int result = calc.divide(4, 2);
		assertEquals(2, result);
	}
	@Test
	public void test４５わる９は５になる(){
		int result = calc.divide(45, 9);
		assertEquals(5, result);
	}
	@Test
	public void test４５わる８は５あまり５になる(){
		int result = calc.divide(45, 8);
		int result2	= calc.remainder(45, 8);
		assertEquals(5, result);
		assertEquals(5, result2);
	}
	@Test
	public void test数字で１と２を与えて文字でプラスを入力すると数字で３を返す(){
		int result = calc.operator(1, 2, "+");
		assertEquals(3, result);
	}
	@Test
	public void test数字で２と３を与えて文字でアスタリスクを入力すると数字で６を返す(){
		int result = calc.operator(2, 3, "*");
		assertEquals(6, result);
	}
	@Test
	public void test数字で２と１を与えて文字でマイナスを入力すると数字で１を返す(){
		int result = calc.operator(2, 1, "-");
		assertEquals(1, result);
	}
	@Test
	public void test数字で１０と５を与えて文字でスラッシュを入力すると数字で２を返す(){
		int result = calc.operator(10, 5, "/");
		assertEquals(2, result);
	}
	@Test
	public void test数字の２３と４を与えて文字でスラッシュを入力するとあまり３になる(){
		int[] result = calc.operator2(23, 4, "/");
		assertEquals(5, result[0]);
		assertEquals(3, result[1]);
	}
	@Test(expected = ArithmeticException.class)
	public void test割り算で割る数が０のとき例外が発生する(){
		calc.operator(3, 0, "/");
	}
	@Test
	public void test２５と４と文字のスラッシュを入力してが割り切れないときオペレータ２を呼んで商とあまりをかえす(){
		int[] result = calc.remaindercheck(25, 4, "/");
		assertEquals(6, result[0]);
		assertEquals(1, result[1]);	
	}
	//public void testKKKKK(){
		
	//	CalcTera tera = new CalcTera();
	//	int[] result = tera.warizan(23,4,"/");
	//	assertEquals(5, result[0]);
	//	assertEquals(5, result[1]);
	
		/*
		 *  CalcTera.warizankekka() 23/4
		 *  CalcTera.amari()  mod(23/4)
		 *  calcTera.warizan()
		 */
	
}

