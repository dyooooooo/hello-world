package instantMessageClient;

import java.util.Observable;
import java.util.Observer;
import java.net.*;
import java.io.*;

public class ClientLoginModel extends Observable {
	User user;
	Socket socket;
	

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
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

	public ClientLoginModel() throws UnknownHostException, IOException {
		super();
		// TODO Auto-generated constructor stub
		try {
			setSocket(new Socket("127.0.0.1", 7777));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}	
		
	}
	
	public int doJob() {
		try {
			 
			
			OutputStream os =this.socket.getOutputStream();
			 OutputStreamWriter osr= new OutputStreamWriter(os);
			 PrintWriter pw = new PrintWriter(osr,true);
			 
			 pw.println("l%"+user.getUserNameString()+"&"+user.getPassWordString());
			 
			 InputStream is = this.socket.getInputStream();
			 InputStreamReader isr= new InputStreamReader(is);
			 BufferedReader br = new BufferedReader(isr);
			
			
			 int answer = br.read();
			 return answer;
			 
				
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	
	
	
}
