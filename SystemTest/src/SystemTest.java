import java.util.*;
public class SystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> env = System.getenv();
		
		for(String one:env.keySet()){
			System.out.println(one+":"+env.get(one));
		}
		System.out.println("-------------------------------------------------");
		System.out.println("java_home : "+System.getenv("java_home"));
		System.out.println("-------------------------------------------------");
		
		
		String s1 = new String("eason");
		String s2 = new String("eason");
		
		System.out.println("s1 hashCode is "+System.identityHashCode(s1));
		System.out.println("s2 hashCode is "+System.identityHashCode(s2));
		
		
		System.out.println("s1的hashCode is "+s1.hashCode());
		System.out.println("s2的hashCode is "+s2.hashCode());

		System.out.println("-------------------------------------------------");
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
		
		

	}

}
