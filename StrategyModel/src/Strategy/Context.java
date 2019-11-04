package Strategy;

public class Context {
	private Strategy strategy;	
	


	public double calRecharge(Double charge, Integer type){
		strategy = StrategyFactory.getInstance().creator(type);
		return strategy.calRecharge(charge);
	}
	

}
