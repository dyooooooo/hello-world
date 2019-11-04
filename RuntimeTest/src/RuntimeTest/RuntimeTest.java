package RuntimeTest;
import java.io.*;

public class RuntimeTest {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Runtime rt = Runtime.getRuntime();
		System.out.println("available processor : "+rt.availableProcessors());
		System.out.println("free Memory : "+rt.freeMemory());
		
//		String command = "calc.exe";
//		rt.exec(command);
//		command="cmd /c md c:\\Eason";
//		rt.exec(command);

	}

}
