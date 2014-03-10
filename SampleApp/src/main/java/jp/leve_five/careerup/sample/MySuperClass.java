package jp.leve_five.careerup.sample;

public class MySuperClass {
		public void message(){
			System.out.println("From the super class!");
			
		}
}
	 class MySubClass extends MySuperClass{
		public void message(){
			System.out.println("From the subclass!");
		}
	 
		public  static void  main (String[] args){
			MySubClass mysub = new MySubClass(); 
			mysub.message();
	}
}