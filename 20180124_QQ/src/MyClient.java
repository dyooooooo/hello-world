import java.net.*;
import java.io.*;

public class MyClient{
	public static void main(String[] args){
		
		try{
			Socket s = new Socket("127.0.0.1",8000);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw= new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw,true);
			
			pw.println("Eason");
			
			InputStream is = s.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			
			System.out.println(br.readLine());			
			
			
		}catch(Exception e){}
		
		
	}
}