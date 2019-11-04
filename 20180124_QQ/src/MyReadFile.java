import java.io.*;

public class MyReadFile{
	
	public static void main(String[] args){
		try{
			
			//locate resource
			File fin = new File("c:/work/test.txt");
			File fout = new File("c:/work/test1.txt");	
			
			//build up pipe
			FileReader fins = new FileReader(fin);
			BufferedReader br = new BufferedReader(fins);
			
			
			FileWriter fouts = new FileWriter(fout);
			PrintWriter pw = new PrintWriter(fouts);
							
						
			//operate pipe
			while(br.ready()){
				pw.println(br.readLine());
			}
			
			pw.close();
			br.close();
			
			
		}catch(Exception e){}
		
		
	}
}