package templateMethod;

public abstract class AbstractClass {
	
	public abstract double operate(double a, double b);
	public final void templateMethod(){
		double a = 20;
		double b = 30;
		double result = operate(a,b);
		show (result);
	}
	
	public void show(double s){
		System.out.println("result is "+s);
	}

}
