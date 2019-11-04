package simpleFactory;

public class OperationAdd implements Operation {
	
	double a;
	double b;
	

	@Override
	public double getResult() {
		// TODO Auto-generated method stub
		double result=0;
		result=a+b;
		return result;
	}

	@Override
	public void setA(double value) {
		// TODO Auto-generated method stub
		a=value;
		
	}

	@Override
	public void setB(double value) {
		// TODO Auto-generated method stub
		b=value;
		
	}	
	
	

	

}
