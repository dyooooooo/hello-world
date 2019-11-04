import java.sql.*;
import java.io.*;



public class TestSQL {
	public static void main(String[] args){
		Connection cn = null;
		//Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		String user = "Eason";
		String psd = "dy1023";
		
		
		try{
		    File f = new File("c:/work/SQL.ini");
		    FileReader fr = new FileReader(f);
		    BufferedReader br= new BufferedReader(fr);
		    
		    String driver = br.readLine();
		    String url = br.readLine();
		    String username = br.readLine();
		    String password = br.readLine();
		    
		    br.close();
		    
			Class.forName(driver);
			cn = DriverManager.getConnection(url, username, password);
			//st = cn.createStatement();
			ps = cn.prepareStatement("select * from account where username=? and password=?");
			ps.setString(1, user);
			ps.setString(2, psd);
			//rs = st.executeQuery("select * from employee");
			rs = ps.executeQuery();
			
			if(rs.next()){
				System.out.println("success");
			}else{
				System.out.println("fail");
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				cn.close();
				//st.close();
				ps.close();
				rs.close();
				
			}catch(Exception ex){}
			
		}
	}
}
