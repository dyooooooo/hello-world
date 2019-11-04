package simpleFactory;

public class SubFactory implements OperationFactory {

	@Override
	public Operation CreateOperation() {
		// TODO Auto-generated method stub
		return new OperationSub();
	}

}
