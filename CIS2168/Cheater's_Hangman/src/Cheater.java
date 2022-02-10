import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Cheater {

    public static HashMap<Integer, List<String>> readFile(String filename) throws FileNotFoundException {
        /*
        Hashmap <key, value>
        key is number of letters
        value is the words that are key letters long
         */
        HashMap<Integer, List<String>> wordLists = new HashMap<>();
        Scanner scan = new Scanner(new File(filename));
        while(scan.hasNextLine()){

            String line = scan.nextLine().toLowerCase();
            int length = line.length();
            if(!wordLists.containsKey(length)) {
                wordLists.put(length, new ArrayList<>());
            }
            List<String> wordList = wordLists.get(length);
            wordList.add(line);
        }

        return wordLists;
    }

    public static HashMap<String, List<String>> WordFamilies(List<String> words, Set<Character> guess){
        HashMap<String, List<String>> families = new HashMap<>();
        //key is family
        //value is words
        //this method will go into every letter placement and find each
        /*
        ____
        e___
        _e__
        __e_
        ___e
         */
        for (String word : words) {
            String family = "";
            for (Character c : word.toCharArray()) {
                if (guess.contains(c)) {
                    family+=c;
                } else {
                    family+="_";
                }
            }
            //make another foreach loop to input family into families
            //searching for the words?
            if (!families.containsKey(family)) {
                families.put(family, new ArrayList<>());
            }
            List<String> fam = families.get(family);
            fam.add(word);
        }
        //System.out.println(families);
//        for (String key: families.keySet()) {
//            System.out.println(key);
//        }

        return families;
    }

    public static String getBestFamily(HashMap<String, List<String>> Families){
        //HashMap<String, List<String>> bestFam = new HashMap<>();
        //int best= 0;

        int biggest = -1;
        String best = "";
        for (String family: Families.keySet()) {
            if (Families.get(family).size() > biggest){
                best = family;
                biggest = Families.get(best).size();
            }
        }

        return best;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //wordList.get
        // mac
        //String fileName = "/Users/jackiegan/IdeaProjects/CIS2168/Cheater's_Hangman/src/words.txt";
        // windows
        //String fileName = "C:\\Users\\Jacki\\IdeaProjects\\CIS2168\\trees\\src\\trees.txt";
        //linux
        String fileName = "/home/jackie/IdeaProjects/CIS2168/Cheater's_Hangman/words.txt";


        int chances = 10;
        //System.out.println(readFile(fileName));
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the word length: ");
        int wordLength = input.nextInt();

        for (int i = 0; i < wordLength; i++) {
            System.out.print("_");
        }
        System.out.println();

        Set<Character> guesses = new HashSet<>();

        System.out.println("Enter a Letter: ");
        char guess = input.next().charAt(0);
        guesses.add(guess);

        //every round creating a new word family map
        //creating a filter!!!!
        List<String> wordLists = readFile(fileName).get(wordLength); //got the initial list
        HashMap<String, List<String>> hm = WordFamilies(wordLists, guesses);

        String possibility = getBestFamily(hm);
        System.out.println(possibility);
        System.out.println("Guesses already used" + guesses);
        String answer = hm.get(possibility).get(0);

        if (possibility.contains("" + guess)) {
            System.out.println("correct guess");
        } else {
            System.out.println("wrong guess");
            chances--;
        }

        //String answer = WordFamilies(hm.get(wordLength), guesses).get(possibility).get(0);

        while(true){
            System.out.println("remaining chances: " + chances);
            System.out.println("Enter a Letter: ");

            guess = input.next().charAt(0);


            if (guesses.contains(guess)){
                //guesses.add(guess);
                System.out.println("Please Enter another letter:");
                guess = guess;
                chances++;
                //Map<String, List<String>> fam= WordFamilies(hm.get(wordLength), guesses);
            } else {
                guesses.add(guess);
            }

            //make the map from string of character (user guesses) to the list of words user has left
            //make it inside the while loop
                //List<String> newWordLists = new ArrayList<>();

                hm = WordFamilies(hm.get(possibility), guesses);
                //key learned don't initialize in while loop if you want to modify from previous
                /*

                 */

                possibility = getBestFamily(hm);
                System.out.println(possibility);
                System.out.println("Guesses already used" + guesses);
                //make a handling that checks same letter entered, chances doesn't go up
                answer = hm.get(possibility).get(0);


                if (possibility.contains("" + guess)) {
                    System.out.println("correct guess");
                } else {
                    System.out.println("wrong guess");
                    chances--;
                }

//                if (possibility.contains("")){
//                    System.out.println("you won");
//                    break;
//                }


            if (chances == 0) {
                System.out.println("You ran out of guesses");
                System.out.println("The word was: " + answer);
                break;
            }

        }
    }
}
