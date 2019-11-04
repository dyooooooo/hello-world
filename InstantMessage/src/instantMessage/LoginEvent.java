package instantMessage;
import java.util.EventObject;

public class LoginEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	
	public LoginEvent(Object source, User user) {
		super(source);
		// TODO Auto-generated constructor stub
		this.user=user;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}


	
	
	

}
