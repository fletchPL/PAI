import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		String [] fileNameList;
		String fileNameAsString;
		
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

	private static void countTheNumberOfLineUsingOneThread(String[] fileNameList) {
		// TODO Auto-generated method stub
		
	}

}
