import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexFinal {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/home/jackie/IdeaProjects/CIS2168/regex/src/regexFinal.txt";
        Scanner scanner = new Scanner(new File(fileName));

        //all patterns statements
        //Question 1
        Pattern patternCD = Pattern.compile(".*(cat|dog).*", Pattern.CASE_INSENSITIVE);
        int count1 = 0;

        //Question 2
        Pattern pattern4L = Pattern.compile("^[a-z]{4}$", Pattern.CASE_INSENSITIVE);
        int count2= 0;

        //Question 3
        Pattern pattern_ing = Pattern.compile("[a-z]*ing$", Pattern.CASE_INSENSITIVE);
        Pattern pattern_ion = Pattern.compile(".+ion$", Pattern.CASE_INSENSITIVE);
        int count_ing = 0;
        int count_ion = 0;

        //Question 4
        Pattern pattern_q = Pattern.compile("q(?!u)", Pattern.CASE_INSENSITIVE);
        int count_q = 0;

        //Question 5
        Pattern pattern_vowels = Pattern.compile("^[^aeiou]+$", Pattern.CASE_INSENSITIVE);
        int count_vowels = 0;

        //Question 6
        Pattern pattern_Two = Pattern.compile("^.*[aeiou]{2}.*$", Pattern.CASE_INSENSITIVE);
        int count_Two = 0;

        //Question 7
        Pattern pattern_TwoV = Pattern.compile("[aeiou][^aeiou]+[aeiou]", Pattern.CASE_INSENSITIVE);
        int count_TwoV = 0;


        while(scanner.hasNext()){
            //Question 1
            String line = scanner.next();
            Matcher matcherC = patternCD.matcher(line);
            boolean matchFoundC = matcherC.find();
            if (matchFoundC){
                count1++;
            }
            //Question 2
            Matcher matcher4L = pattern4L.matcher(line);
            boolean matchFound4L = matcher4L.find();
            if (matchFound4L){
                count2++;
            }
            //Question 3
            Matcher matcher_ing = pattern_ing.matcher(line);
            boolean matchFound_ing = matcher_ing.find();
            Matcher matcher_ion = pattern_ion.matcher(line);
            boolean matchFound_ion = matcher_ion.find();
            if (matchFound_ing){
                count_ing++;
            }
            if (matchFound_ion){
                count_ion++;
            }
            //Question 4
            Matcher matcher_q = pattern_q.matcher(line);
            boolean matchFound_q = matcher_q.find();
            if (matchFound_q){
                count_q++;
            }
            //Question 5
            Matcher matcher_vowels = pattern_vowels.matcher(line);
            boolean matchFound_vowels = matcher_vowels.find();
            if (matchFound_vowels){
                count_vowels++;
            }
            //Question 6
            Matcher matcher_Two = pattern_Two.matcher(line);
            boolean matchFound_Two = matcher_Two.find();
            if (matchFound_Two){
                count_Two++;
            }
            //Question 7
            Matcher matcher_TwoV = pattern_TwoV.matcher(line);
            boolean matchFound_TwoV = matcher_TwoV.find();
            if (matchFound_TwoV){
                count_TwoV++;
            }

        }
        //all print statements
        System.out.println("we found " + count1 + " words that contains cat or dog");
        System.out.println("we found " + count2 + " 4 letter words");
        if (count_ion == count_ing){
            System.out.println("they have the same amount");
            System.out.println("ing: "+ count_ing);
            System.out.println("ion: "+ count_ion);
        } else if (count_ion > count_ing){
            System.out.println("ion ending has more");
            System.out.println("ing: "+ count_ing);
            System.out.println("ion: "+ count_ion);
        } else {
            System.out.println("ing ending has more");
            System.out.println("ing: "+ count_ing);
            System.out.println("ion: "+ count_ion);
        }
        System.out.println(count_q+" words that contains q and does not follow a u");
        System.out.println(count_vowels+" words that does not have vowels");
        System.out.println(count_Two + " words that contains two vowels");
        System.out.println(count_TwoV + " two vowels not adjacent");
    }
}
