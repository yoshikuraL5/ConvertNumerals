package jp.leve_five.careerup.sample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	Stk stk;
	@Before
	public void before(){
		stk = new Stk();
	}
	@Test
	public void test配列に値を入れなければ要素数が０で返ってくる(){
		int count = stk.count();
		assertEquals(0, count);
	}
	@Test
	public void testスタックにAを渡したらスタックが持ってる数は１になる(){
		stk.push("A");
		int count = stk.count();
		assertEquals(1, count);
	}
	@Test
	public void testスタックにBを渡したらスタックからBが返ってくる(){
		stk.push("B");
		String result = stk.get();
		assertEquals("B", result);
	}
	@Test
	public void testスタックにCを渡してスタックからCを取り出すとスタックが持ってる数は0になる(){
		stk.push("C");
		stk.get();
		int count = stk.count();
		assertEquals(0, count);
	}
	@Test
	public void testスタックにDとEを渡すとEとDの順で返ってくる(){
		stk.push("D");
		stk.push("E");
		String result = stk.get();
		assertEquals("E", result);
		result = stk.get();
		assertEquals("D", result);
	}
	@Test
	public void testスタックに10個の値を入れたとき入れたのと逆順に全部返ってくる(){
		stk.push("1");
		stk.push("2");
		stk.push("3");
		stk.push("4");
		stk.push("5");
		stk.push("6");
		stk.push("7");
		stk.push("8");
		stk.push("9");
		stk.push("10");
		
		String result = stk.get();
		assertEquals("10", result);
		
		result = stk.get();
		assertEquals("9", result);
		
		result = stk.get();
		assertEquals("8", result);
		
		result = stk.get();
		assertEquals("7", result);
		
		result = stk.get();
		assertEquals("6", result);
		
		result = stk.get();
		assertEquals("5", result);
		
		result = stk.get();
		assertEquals("4", result);
		
		result = stk.get();
		assertEquals("3", result);
		
		result = stk.get();
		assertEquals("2", result);
		
		result = stk.get();
		assertEquals("1", result);
	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testスタックに値を投げていない状態で値を返そうとすると例外が発生し値を入力してくださいとメッセージが表示される(){
		stk.get();
	}
	@Test
	public void testスタックに文字列を投げると受け取った文字列を確認する文章が表示される(){
		stk.push("HelloWorld");
	}
	@Test
	public void testスタックに入っているものの数を聞くと数が返ってなおかつ表示される(){
		stk.count();
	}
	@Test
	public void testスタックから値を取り出すとき取り出したものを表示する(){
		stk.push("元気？");
		stk.get();
	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test無限に値を入れ続けた時例外を返し容量オーバーですと表示される(){
		for(int i = 0;i >= 0;i++)
			stk.push("i");
	}
}
