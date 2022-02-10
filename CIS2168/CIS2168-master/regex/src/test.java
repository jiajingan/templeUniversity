import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
//1. how many words contain the word cat or dog

        String fileName = "C:\\Users\\Jacki\\IdeaProjects\\CIS2168\\regex\\src\\test1.txt";
        Scanner scanner = new Scanner(new File(fileName));

//        //Pattern patternCDE = Pattern.compile("^[a-z]{4}$", Pattern.CASE_INSENSITIVE);
//        Pattern patternCD = Pattern.compile(".*(cat|dog).*", Pattern.CASE_INSENSITIVE);
//        //Pattern patternCD = Pattern.compile("([a-z](cat|dog)[a-z]) | ((cat|dog)[a-z]) | ([a-z](cat|dog))", Pattern.CASE_INSENSITIVE);
//        //Pattern patternD = Pattern.compile("[dog]", Pattern.CASE_INSENSITIVE);
//        int count1 = 0;
//        while(scanner.hasNext()){
//            String line = scanner.nextLine();
//            Matcher matcherC = patternCD.matcher(line);
//            //Matcher matcherD = patternD.matcher(line);
//            boolean matchFoundC = matcherC.find();
//            //boolean matchFoundD = matcherD.find();
////            if (matchFoundC || matchFoundD){
////                count1++;
////            }
//            if (matchFoundC){
//                count1++;
//            }
//        }
//        System.out.println("we found " + count1 + " words that contains cat or dog");


//        //2. How many four letter words are there?
//        int count2= 0;
//        //Pattern pattern4L = Pattern.compile("\b[a-z]{4}\b", Pattern.CASE_INSENSITIVE);
//        //this doesn't work I don't know why
//        Pattern pattern4L = Pattern.compile("^[a-z]{4}$", Pattern.CASE_INSENSITIVE);
//        while(scanner.hasNext()){
//            String line = scanner.nextLine();
//            Matcher matcher4L = pattern4L.matcher(line);
//            boolean matchFound4L = matcher4L.find();
//            if (matchFound4L){
//                count2++;
//            }
//        }
//        System.out.println("we found " + count2 + " 4 letter words");

////3. Do more works end in "ing" or "ion"?
//        int count_ing = 0;
//        int count_ion = 0;
//        Pattern pattern_ing = Pattern.compile("[^a-z]*ing", Pattern.CASE_INSENSITIVE);
//        //Pattern pattern_ing = Pattern.compile(".+[ing]$", Pattern.CASE_INSENSITIVE);
//        //Pattern pattern_ing = Pattern.compile("[^a-z]+ing", Pattern.CASE_INSENSITIVE);
//        //Pattern pattern_ion = Pattern.compile("[^a-z]*ion", Pattern.CASE_INSENSITIVE);
//        //this doesn't work, idk why
//        Pattern pattern_ion = Pattern.compile(".+[ion]$", Pattern.CASE_INSENSITIVE);
//
//        while(scanner.hasNext()){
//            String line = scanner.nextLine();
//            Matcher matcher_ing = pattern_ing.matcher(line);
//            boolean matchFound_ing = matcher_ing.find();
//            Matcher matcher_ion = pattern_ion.matcher(line);
//            boolean matchFound_ion = matcher_ion.find();
//            if (matchFound_ing){
//                count_ing++;
//            }
//            if (matchFound_ion){
//                count_ion++;
//            }
//        }
//        if (count_ion == count_ing){
//            System.out.println("they have the same amount");
//            System.out.println("ing: "+ count_ing);
//            System.out.println("ion: "+ count_ion);
//        } else if (count_ion > count_ing){
//            System.out.println("ion ending has more");
//            System.out.println("ing: "+ count_ing);
//            System.out.println("ion: "+ count_ion);
//        } else {
//            System.out.println("ing ending has more");
//            System.out.println("ing: "+ count_ing);
//            System.out.println("ion: "+ count_ion);
//        }

//        //4. How many words contains a "q" no immediately followed by a "u"
//        int count_q = 0;
//        Pattern pattern_q = Pattern.compile("q(?!u)", Pattern.CASE_INSENSITIVE);
//        while(scanner.hasNext()){
//            String line = scanner.nextLine();
//            Matcher matcher_q = pattern_q.matcher(line);
//            boolean matchFound_q = matcher_q.find();
//            if (matchFound_q){
//                count_q++;
//            }
//        }
//        System.out.println(count_q+" words that contains q and does not follow a u");

//        //5. How many words have no vowels?
//        int count_vowels = 0;
//        //Pattern pattern_vowels = Pattern.compile("[aieou]{0}", Pattern.CASE_INSENSITIVE);
//        //Pattern pattern_vowels = Pattern.compile(".*[^aeiou].*", Pattern.CASE_INSENSITIVE);
//        //Pattern pattern_vowels = Pattern.compile("[^aeiou]+$", Pattern.CASE_INSENSITIVE);
//        Pattern pattern_vowels = Pattern.compile("^[^aeiou]+$", Pattern.CASE_INSENSITIVE);
//        while(scanner.hasNext()){
//            String line = scanner.nextLine();
//            Matcher matcher_vowels = pattern_vowels.matcher(line);
//            boolean matchFound_vowels = matcher_vowels.find();
//            if (matchFound_vowels){
//                count_vowels++;
//            }
//        }
//        System.out.println(count_vowels+" words that does not have vowels");

//        //6. How many words with two vowels in a row are there?
//        //https://stackoverflow.com/questions/48878707/2-vowels-in-a-word-using-regex
//        int count_Two = 0;
//        Pattern pattern_Two = Pattern.compile("^.*[aeiou]{2}.*$", Pattern.CASE_INSENSITIVE);
//        //Pattern pattern_Two = Pattern.compile("[aeiou][^ ]*[aeiou]", Pattern.CASE_INSENSITIVE);
//        //this matches the first vowel then follows with any non white space and match with another vowel
//        while(scanner.hasNext()){
//            String line = scanner.nextLine();
//            Matcher matcher_Two = pattern_Two.matcher(line);
//            boolean matchFound_Two = matcher_Two.find();
//            if (matchFound_Two){
//                count_Two++;
//            }
//        }
//        System.out.println(count_Two + " words that contains two vowels");

        //7. How many words with at least two vowels are there, can not be adjacent?
        int count_TwoV = 0;
        Pattern pattern_TwoV = Pattern.compile("[aeiou]{1}[^aeiou][aeiou]{1}", Pattern.CASE_INSENSITIVE);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            Matcher matcher_TwoV = pattern_TwoV.matcher(line);
            boolean matchFound_TwoV = matcher_TwoV.find();
            if (matchFound_TwoV){
                count_TwoV++;
            }
        }
        System.out.println(count_TwoV + " two vowels not adjacent");

    }
}
