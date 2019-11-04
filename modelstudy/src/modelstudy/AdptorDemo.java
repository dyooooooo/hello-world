package modelstudy;

public class AdptorDemo {
	public static void main(String[] args){
		Window w = new WindowImpl();
		w.open();
		w.close();
		
	}
}

interface Window{
	void open();
	void close();
	void activated();
	void maximize();
	void minimize();	
}


abstract class WindowAdaptor implements Window{

	@Override
	public void activated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void maximize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minimize() {
		// TODO Auto-generated method stub
		
	}
	
}


class WindowImpl extends WindowAdaptor{
	public void open(){
		System.out.println("open window");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("close window");
		
	}
	
}