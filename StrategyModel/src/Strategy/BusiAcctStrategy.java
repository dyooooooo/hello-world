package Strategy;

public class BusiAcctStrategy implements Strategy {

	@Override
	public Double calRecharge(Double charge) {
		// TODO Auto-generated method stub
		return charge*0.9;
	}

}
