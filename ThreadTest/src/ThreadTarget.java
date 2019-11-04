
public class ThreadTarget implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" is running...");
		try{
			Thread.currentThread().sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" is finished");
	
	}

}
