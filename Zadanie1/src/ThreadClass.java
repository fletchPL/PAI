import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ThreadClass implements Runnable {

	
	private Thread thread;
	private String threadName;
	private String fileName;
	

	public ThreadClass(String name, String fileName) {
		this.threadName = name;
		this.fileName = fileName;
		System.out.println("Creating " + threadName);
	}
	
	@Override
	public void run() {
		
		try{
			Path path = Paths.get(fileName);
			
			long countTheLineInFile = Files.lines(path).count();
			System.out.println("Number of lines in file " + fileName + "equals " + countTheLineInFile);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void start(){}

}
