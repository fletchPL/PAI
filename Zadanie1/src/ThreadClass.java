import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ThreadClass implements Runnable {

	
	private Thread thread;
	private String threadName;
	private String fileName;
	private static String pathAsString = "C:\\Users\\Maciej\\Desktop\\PAI\\Zadanie1\\file\\";

	public ThreadClass(String name, String fileName) {
		this.threadName = name;
		this.fileName = fileName;
		System.out.println("Creating " + threadName);
	}
	
	@Override
	public void run() {
		
		try{
			Path path = Paths.get(pathAsString + fileName);
			System.out.println("Path " + path);
			long countTheLineInFile = Files.lines(path).count();
			System.out.println("Number of lines in file " + fileName + "equals " + countTheLineInFile);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void startSequency(){
		
		System.out.println("Start thread " + threadName);
		
		if(thread == null)
		{
			try{
				thread = new Thread(this, threadName);
				thread.start();
				thread.join();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
