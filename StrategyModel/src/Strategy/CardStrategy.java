package Strategy;

public class CardStrategy implements Strategy {

	@Override
	public Double calRecharge(Double charge) {
		// TODO Auto-generated method stub
		return charge*1.01;
	}

}
