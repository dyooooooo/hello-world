package observer;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Observable;


public class Police extends Observable {
	private String time;
	
	public Police(List<Observer> oblist){
		super();
		for(Observer ob: oblist){
			addObserver(ob);
		}
	}
	
	public void change(String time){
		this.time=time;
		setChanged();
		notifyObservers(this.time);
	}	

}
