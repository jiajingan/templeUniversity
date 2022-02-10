import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFromFileExample {
	
	public static void main(String [] args){

		// mac
		//String fileName = "/Users/jackiegan/IdeaProjects/CIS2168/trees/src/trees.txt";
		// windows
		String fileName = "C:\\Users\\Jacki\\IdeaProjects\\CIS2168\\trees\\src\\trees.txt";
		
		try {
//			Scanner scanner = new Scanner(new File(fileName));
//			while(scanner.hasNextLine()){
//				String line = scanner.nextLine();
//
//					line.replace("!","")
//						.replace("?", "")
//						.replace("'", "")
//						.replace(";", "")
//						.replace(":", "")
//						.replace("'", "")
//						.replace(",", "");
//				String[] words = line.split("\\s+");
//				for(String word : words){
//
//				}
//				System.out.println(words);
//			}
//			scanner.close();
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				line = line.replaceAll("'","")
						.replaceAll("\\W+", " ")
						.replaceAll("\\d", "");

				String[] words = line.split("\\s+");
				for (String word: words) {
					System.out.println(word);
				}
			}
			//System.out.println(Arrays.toString(words));
			scanner.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}


