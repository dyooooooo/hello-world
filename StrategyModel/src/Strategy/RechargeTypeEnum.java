package Strategy;

public enum RechargeTypeEnum {
	E_Bank(1,"网银"),	BUSI_ACCOUNTS(2,"商户账号"),	MOBILE(3,"手机卡充值"),	CARD_RECHARGE(4,"充值卡");
	
	public int getValue() {
		return value;
	}	

	public String getDescription() {
		return description;
	}


	

	private int value;
	private String description;
	
	
	private RechargeTypeEnum(int value, String description) {
		this.value = value;
		this.description = description;
	}
	

}
