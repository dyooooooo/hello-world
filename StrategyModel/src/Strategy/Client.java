package Strategy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Context context = new Context();
		double money = context.calRecharge(100D, RechargeTypeEnum.BUSI_ACCOUNTS.getValue());
		System.out.println(money);
	}

}
