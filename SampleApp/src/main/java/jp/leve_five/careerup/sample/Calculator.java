package jp.leve_five.careerup.sample;

public class Calculator {
	public int plus(int result1, int result2){
		return result1 + result2;
	}

	public int minus(int result1, int result2) {
		return result1 - result2;
	}

	public int multiply(int result1, int result2) {
		return result1 * result2;
	}

	public int divide(int result1, int result2) {
		return result1 / result2;
	}
	public int remainder(int result1, int result2){
		return result1 % result2;
	}

	public int operator(int i, int j, String string) {
		int result =0 ;
		if (string.equals("+")){
			result = plus(i, j);
		}else if(string.equals("-")){
			result = minus(i, j);
		}else if(string.equals("*")){
		    result = multiply(i, j);
		}else if(string.equals("/")){
			result = divide(i, j);
		}
		return result;
	}
	public int[] operator2(int i, int j, String string) {
		int[] result2 = new int[2];
		result2[0] = divide(i, j);
		result2[1] = remainder(i, j);
		return result2;
	}
	public int[] remaindercheck(int i, int j, String string){
		int[] result2 = new int[2];
		result2[0] = divide(i, j);
		result2[1] = remainder(i, j);
		return result2;
	
			
		
		}
	}
	

