
public class ThreadObj extends Thread {

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Thread.currentThread().getName()+" is running...");
		try{
			this.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" is finished");
	}
	

}
