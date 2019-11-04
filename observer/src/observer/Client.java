package observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndercoverA a = new UndercoverA();
		UndercoverB b = new UndercoverB();
		
		List<Observer> oblist = new ArrayList<>();
		oblist.add(a);
		oblist.add(b);
		
		Police p = new Police(oblist);
		p.change("08:30");
		System.out.println("-------------------message compromised, action time is advanced-------------------------");
		p.change("07:00");		

	}

}
