package modelstudy;

public class FoctoryDemo {
	public static void main(String[] args){
		Fruit f1 = Factory.getInstance("apple");
		Fruit f2 = Factory.getInstance("orange");
		Fruit f3 = Factory.getInstance("good");
		
		try{
			f1.eat();
			f2.eat();
			f3.eat();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

interface Fruit{
	void eat();
}

class Apple implements Fruit{
	public void eat(){
		System.out.println("Eating Apple");
	}
}

class Orange implements Fruit{
	public void eat(){
		System.out.println("Eating Orange");
	}
}

class Factory{
	public static Fruit getInstance(String classname){
		Fruit f = null;
		if("apple".equals(classname)){
			f = new Apple();
		}
		
		if("orange".equals(classname)){
			f = new Orange();
		}
		
		return f;
	}
}