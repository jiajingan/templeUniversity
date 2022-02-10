import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hangman {

    public static void main(String [] args){

        // mac
        String fileName = "/Users/jackiegan/IdeaProjects/CIS2168/Cheater's_Hangman/src/words.txt";
        // windows
        //String fileName = "C:\\Users\\Jacki\\IdeaProjects\\CIS2168\\trees\\src\\trees.txt";

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
//                line = line.replaceAll("'","")
//                        .replaceAll("\\W+", " ")
//                        .replaceAll("\\d", "");
//
//                String[] words = line.split("\\s+");
//                for (String word: words) {
//                    System.out.println(word);
//                }

                System.out.println(line);

            }
            //System.out.println(Arrays.toString(words));
            scanner.close();

        } catch (FileNotFoundException e1) {

            e1.printStackTrace();
        }

    }


}
