import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		String [] fileNameList;
		String fileNameAsString;
		System.out.println("Type the name of file with '.txt' separate ' ' ");
		Scanner inputFileName = new Scanner(System.in);
		fileNameAsString = inputFileName.nextLine();
		fileNameList = fileNameAsString.split(" ");
		
		for (String fileName : fileNameList) {
			System.out.println(fileName);
		}
		
	}

}
