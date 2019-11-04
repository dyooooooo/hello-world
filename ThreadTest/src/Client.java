
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//way 1
		System.out.println(Thread.currentThread().getName()+" start ");
		
		for(int i=0;i<3;i++){
			new ThreadObj().start();
		}
		
		
		
		//way 2
		ThreadTarget tt = new ThreadTarget();
		
		for(int i=0;i<3;i++){
			new Thread(tt,"Thread"+(i+1)).start();
		}
		

	}

}
