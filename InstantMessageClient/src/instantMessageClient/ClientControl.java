package instantMessageClient;

import java.io.IOException;

public class ClientControl implements LoginListener {	
	
	private ClientLoginView  clv;
	private ClientLoginModel clm;
	
	//User user;
	
	

	public ClientControl() {
		super();
		// TODO Auto-generated constructor stub
		clv=new ClientLoginView();
		clv.addLoginListener(this);
		
		try {
			clm = new ClientLoginModel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void loginPerformed(LoginEvent event) {
		// TODO Auto-generated method stub
		System.out.println("User Name : "+event.getUser().getUserNameString());
		System.out.println("Password : "+event.getUser().getPassWordString());
		
		clm.setUser(event.getUser());
		int response= clm.doJob();
		
		
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientControl ccClientControl = new ClientControl();
		
		
		
		
	}
	

}
