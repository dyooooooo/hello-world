package Strategy;

public enum RechargeTypeEnum {
	E_Bank(1,"����"),	BUSI_ACCOUNTS(2,"�̻��˺�"),	MOBILE(3,"�ֻ�����ֵ"),	CARD_RECHARGE(4,"��ֵ��");
	
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
