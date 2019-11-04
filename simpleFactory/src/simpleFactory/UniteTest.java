package simpleFactory;

public class UniteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperationFactory operFct= new AddFactory();
		Operation oper=operFct.CreateOperation();
		oper.setA(5);
		oper.setB(15);
		
		double result = oper.getResult();
		
		
		
		
		System.out.println(result);

	}

}
