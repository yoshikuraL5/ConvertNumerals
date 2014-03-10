package jp.leve_five.careerup.sample;

public class Stk {
	private int count = 0;
	String[] stack = new String[100];
	
	public int count(){
		System.out.println("今持っている値の数は"+count+"です");
		return count;
	}
	
	public void push(String string) {
		count += 1;
		stack[count - 1] = string;
		System.out.println("受け取った文字列は"+string+"です");
	}
	public String get() {
		count -= 1;
		if(count < 0){
			System.out.println("エラー出てますけど、大丈夫ですか？");
			throw new ArrayIndexOutOfBoundsException();
		}
		System.out.println("取り出したデータは"+stack[count]+"です");
		return stack[count];
	}
}


