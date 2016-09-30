
public class ThreadClass implements Runnable {

	
	private Thread thread;
	private String threadName;
	
	public void  ThreadClass(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void start(){}

}
