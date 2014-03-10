package jp.level_five.careerup.ReversePolishTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import jp.level_five.careerup.ReversePolish.ElementArranger;
import jp.level_five.careerup.ReversePolish.Element;

import org.junit.Before;
import org.junit.Test;

public class ElementArrangerTest {
	ElementArranger elementArranger;
	@Before
	public void before(){
		elementArranger = new ElementArranger();
	}
	
	private ArrayList<Element> generateElementList(String[] values) {
		ArrayList<Element> elementArray = new ArrayList<Element>();
		for (int i = 0; i < values.length; ++i) {
			elementArray.add(new Element(values[i]));
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
	
	@Test 
	public void test１とプラスと2の情報を持ったリストをArrangeElementArrayに渡すと１と２とプラスの順になったリストが返ってくる(){
		ArrayList<Element> elementArray = generateElementList(new String[] { "1", "+", "2" });
		
		ArrayList<Element> result = elementArranger.arrangeByReversePolish(elementArray);
		
		assertTrue(checkEquivalence(new String[] { "1", "2", "+" }, result));
	}
	@Test
	public void test１かける２の順のリストをArrangeElementArrayは１２かけるの順のリストに変換して返す(){
		ArrayList<Element> elementArray = generateElementList(new String[] {"1", "*", "2"});
		ArrayList<Element> result = elementArranger.arrangeByReversePolish(elementArray);
		assertTrue(checkEquivalence(new String[] { "1", "2", "*" }, result));

	}
	@Test
	public void test２たす３ひく４の順のリストをArrangeElementArrayは２３４ひくたすの順のリストに変換して返す(){
		ArrayList<Element> elementArray = generateElementList(new String[]{"2", "+", "3", "-", "4"});
		ArrayList<Element> result = elementArranger.arrangeByReversePolish(elementArray);
		assertTrue(checkEquivalence(new String[]{"2", "3", "4", "-", "+"}, result));
	}
	@Test
	public void test2たす8かける5の順のリストをArrangeElementArrayは285かけるたすの順のリストに変換して返る(){
		ArrayList<Element> elementArray = generateElementList(new String[]{"2", "+", "8", "*", "5"});
		ArrayList<Element> result = elementArranger.arrangeByReversePolish(elementArray);
		assertTrue(checkEquivalence(new String[]{"2", "8", "5", "*", "+"}, result));
	}
	@Test
	public void test２アスタリスク８プラス５の順のリストをArrangeElementArrayは２８アスタリスク5プラスの順に変換して返る(){
		ArrayList<Element> elementArray = generateElementList(new String[]{"2", "*", "8", "+", "5"});
		ArrayList<Element> result = elementArranger.arrangeByReversePolish(elementArray);
		assertTrue(checkEquivalence(new String[]{"2", "8", "*", "5", "+"}, result));
	}
	@Test
	public void test３たす４かける５ひく６わる７の順にリストをArrageElementArrayは３４５かけるたす６７わるひくの順に変換して返る (){
		ArrayList<Element> elementArray = generateElementList(new String[]{"3", "+", "4", "*", "5", "-", "6", "/", "7"});
		ArrayList<Element> result = elementArranger.arrangeByReversePolish(elementArray);
		assertTrue(checkEquivalence(new String[]{"3", "4", "5", "*", "+", "6", "7", "/", "-"}, result));
	}
	
	@Test
	public void test括弧１プラス３アスタリスク５の順にリストをArrangeElementArrayは１３プラス５アスタリスクの順に変換して返る(){
		ArrayList<Element> elementArray = generateElementList(new String[]{"(", "1", "+", "3", ")", "*", "5"});
		ArrayList<Element> result = elementArranger.arrangeByReversePolish(elementArray);
		assertTrue(checkEquivalence(new String[]{"1", "3", "+", "5", "*"}, result));
	}
	@Test
	public void test４アスタリスク括弧３アスタリスク５プラス２の順にリストをArrangeElementArrayが逆ポーランド記法の順に変換して返る(){
		ArrayList<Element> elementArray = generateElementList(new String[]{"4", "*", "(", "3", "*", "5", "+", "2", ")"});
		ArrayList<Element> result = elementArranger.arrangeByReversePolish(elementArray);
		assertTrue(checkEquivalence(new String[]{"4", "3", "5", "*", "2", "+", "*"}, result));
	}
 } 
