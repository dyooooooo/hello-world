package templateMethod;

public class Client {
	public static void main(String[] args){
		AbstractClass c1 = new AddClass();
		c1.templateMethod();
		AbstractClass c2 = new SubClass();
		c2.templateMethod();
	}
}
