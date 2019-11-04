package observer;

import java.util.Observable;
import java.util.Observer;

public class UndercoverB implements Observer {
	
	private String time;

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		time = (String)arg1;
		System.out.println("UndercoverB got message. action time is "+time);
	}

}
