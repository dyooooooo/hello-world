import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.*;


public class QQServer {
   public static void main(String[] args){
	   
	   HashMap<String,Socket> hm = new HashMap<String,Socket>();
	   
	   try{
		   
		   //server monitor set
		   ServerSocket ss = new ServerSocket(7000);
		   while(true){
			   System.out.println("Server is monitoring at socket 7000...");
			   Socket s = ss.accept();	
			   MyService mt = new MyService();
			   mt.setSocket(s);
			   mt.setHmSocket(hm);
			   mt.start();
		   }	   		
		   
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{}
	   
	  
   }
}


class MyService extends Thread{
	
	
	private Socket socket;	
	private HashMap<String,Socket> hmSocket;
	
	
	
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void run(){
		try{
			//receive username and password
			InputStream is = this.socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info = br.readLine();
			
			
			//split into username and password
			String user = info.substring(2, info.indexOf("&"));
			String psd = info.substring(info.indexOf("&")+1);				   
			   
			System.out.println("user: "+user);
			System.out.println("password: "+psd);
			
			
			//database channel build
			File f = new File("c:/work/SQL.ini");
			FileReader fr = new FileReader(f);
			BufferedReader fbr= new BufferedReader(fr);
			
			String drive = fbr.readLine();
			String url=fbr.readLine();
			String username=fbr.readLine();
			String password=fbr.readLine();
			
			fbr.close();
			
			//database operation
			Class.forName(drive);
			Connection cn= DriverManager.getConnection(url,username,password);
			PreparedStatement ps = cn.prepareStatement("select * from account where username=? and password=?");
			ps.setString(1, user);
			ps.setString(2, psd);
			ResultSet rs=ps.executeQuery();
			
			
			//send verificaiton answer
			OutputStream os = this.socket.getOutputStream();
			OutputStreamWriter osr= new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osr,true);
			
			
			if(rs.next()){
				pw.write(1);
				pw.flush();
				
				
				for(Socket skt : hmSocket.values()){
					OutputStream tos = skt.getOutputStream();
					OutputStreamWriter tosr=new OutputStreamWriter(tos);
					PrintWriter tpw=new PrintWriter(tosr,true);
					
					tpw.println(user);
				}
				
				for(String tu: hmSocket.keySet()){
					pw.println(tu);
				}
				
				hmSocket.put(user, this.socket);
				
				while(true){
					String message = br.readLine().substring(2);
					System.out.println("Message: "+message);
					pw.write(1);
					pw.flush();
				}
			}else{
				pw.write(0);
				pw.flush();
			}		
			
			
		}catch(Exception e){}
	}

	public HashMap<String,Socket> getHmSocket() {
		return hmSocket;
	}

	public void setHmSocket(HashMap<String,Socket> hmSocket) {
		this.hmSocket = hmSocket;
	}
}