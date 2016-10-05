import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.Region;

public class MainClass {
	
	private static String path = "C:\\Users\\Maciej\\Desktop\\PAI\\Zadanie1\\file";
	public static String nextLine = null;
	public static long start, end, totalTime;
	public static void main(String[] args) {
		String [] fileNameList;
		String fileNameAsString;
		
		displayAllFileInPathFolder();
		
		System.out.println("Type the name of file with '.txt' separate ' ' ");
		Scanner inputFileName = new Scanner(System.in);
		fileNameAsString = inputFileName.nextLine();
		fileNameList = fileNameAsString.split(" ");
		
		System.out.println(" ");
		for (String fileName : fileNameList) {
			System.out.println(fileName);
			
		}
		
		start = System.currentTimeMillis();
		System.out.println("Single Thread");
		countTheNumberOfLineUsingOneThread(fileNameList);
		end = System.currentTimeMillis();
		totalTime = end - start;
		System.out.println("Time for counting line using ONE THREAD equals " + totalTime + " ms");
		
		System.out.println("\n\n\n");
		
		start = System.currentTimeMillis();
		countTheNumberOfLineUsingMultiThreadSeq(fileNameList);
		end = System.currentTimeMillis();
		totalTime = end - start;
		System.out.println("Time for counting line using MultiSeq THREAD equals " + totalTime + " ms");
	}

	private static void countTheNumberOfLineUsingMultiThreadSeq(String[] fileNameList) {
		
		ArrayList<ThreadClass> threadList = new ArrayList<>();
		String threadName;
		
		for (String file : fileNameList) {
			threadName = ("thread " + file);
			ThreadClass thread = new ThreadClass(threadName, file);
			threadList.add(thread);
		}
		for(ThreadClass thread : threadList)
		{
			thread.startSequency();
			
		}
		
	}

	private static void displayAllFileInPathFolder() {
		try
		{
			File folder = new File(path);
			File[] listOfFile = folder.listFiles();
			
			for (File file : listOfFile) {
				if(file.isFile())
				{
					System.out.println(file);
				}else 
				{
					System.out.println(file + " is not a file ");
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private static void countTheNumberOfLineUsingOneThread(String[] fileNameList) {
		
		for (String file : fileNameList) {
			
			try{
				countTheNumberOfLine(file);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	private static void countTheNumberOfLine(String file) throws Exception {
		
			LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream(path + "\\"+file)));
			try{
				while((nextLine = lineCounter.readLine())!= null)
				{
					if(nextLine.equals(null))
					break;
				}
				System.out.println("Total number of the line in file " + file + "equals " + lineCounter.getLineNumber());
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error with file");
			}
		
	}

}
