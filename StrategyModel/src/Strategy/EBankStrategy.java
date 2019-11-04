package Strategy;

public class EBankStrategy implements Strategy {

	@Override
	public Double calRecharge(Double charge) {
		// TODO Auto-generated method stub
		return charge*0.85;
	}

}
