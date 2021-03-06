import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainClass {
	
	private static String path = "C:\\Users\\Maciej\\Desktop\\PAI\\Zadanie1\\file";
	public static String nextLine = null;
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
		
		System.out.println("Single Thread");
		countTheNumberOfLineUsingOneThread(fileNameList);
		
	}

	private static void displayAllFileInPathFolder() {
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
				System.out.println("Total number of the line in file " + file + "equals " + lineCounter);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}

}
