package observer;

import java.util.Observable;
import java.util.Observer;


public class UndercoverA implements Observer {
	
	private String time;

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		time = (String)arg1;
		System.out.println("UndercoverA got message. action time is "+time);
	}

}
