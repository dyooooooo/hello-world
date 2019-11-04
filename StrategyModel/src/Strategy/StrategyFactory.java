package Strategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
	private static StrategyFactory factory = new StrategyFactory();
	
	private static Map<Integer,Strategy> strategyMap = new HashMap<>();
	
	static{
		strategyMap.put(RechargeTypeEnum.E_Bank.getValue(), new EBankStrategy());
		strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.getValue(), new BusiAcctStrategy());
		strategyMap.put(RechargeTypeEnum.MOBILE.getValue(), new MobileStrategy());
		strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.getValue(), new CardStrategy());		
	}
	
	public Strategy creator(Integer type){
		return strategyMap.get(type);		
	}
		
	public static StrategyFactory getInstance(){
		return factory;
	}	

}
