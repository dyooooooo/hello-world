package modelstudy;

public class ProxyDemo {
	public static void main(String[] args){	
		Network nr = new Real();
		Network np = new Proxy(nr);
		
		np.online();
	}
}

interface Network{
	void online();
}

class Real implements Network{
	public void online(){
		System.out.println("Happy online");
	}
}

class Proxy implements Network{
	private Network network;
	
	public Proxy(Network network){
		this.network = network;
	}
	
	private void check(){
		System.out.println("check before online");
	}
	
	public void online(){
		this.check();
		this.network.online();
	}
	
}