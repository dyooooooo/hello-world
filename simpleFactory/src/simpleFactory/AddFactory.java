package simpleFactory;

public class AddFactory implements OperationFactory {

	@Override
	public Operation CreateOperation() {
		// TODO Auto-generated method stub
		return new OperationAdd();
	}

}
