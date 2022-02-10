/*
 *Jiajin(Jackie) Gan
 * CIS 2168 Andrew Rosen
 * Arraylist Exercises Assignment 2
 *
 */

import java.util.*;

public class arraylist<returnType> {
    public static void main(String[] args) {
        //test variables for 1 2 and 4
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(5);
        list.add(30);
        list.add(1);
        //test variables for 4
        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(21);
        list4.add(2);
        list4.add(5);
        list4.add(30);
        list4.add(1);
        //test variable for 3
        List<String> list3 = new ArrayList<>();
        list3.add("I");
        list3.add("like");
        list3.add("to");
        list3.add("eat");
        list3.add("eat");
        list3.add("eat");
        list3.add("apples");
        list3.add("and");
        //test variable for 5
        String sentence = "Hello World! My name? is Jackie???";

        System.out.println("Question1: "+unique(list));
        System.out.println("Question2: "+allMultiples(list,5));
        System.out.println("Question3: "+allStringsOfSize(list3, 3));
        System.out.println("Question4: "+isPermutation(list, list4));
        System.out.println("Question5: "+stringToListOfWords(sentence));
        removeAllInstances(list,1);
        System.out.println("Question6: "+ list);
        System.out.println("hello World");


    }


    //2.1
    public static <E> boolean unique(List<E> list){
        //check all values to see if it's different
        //check all indexes

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0 ; j < list.size(); j++) {
                //System.out.println("i:" + i + "j:" + j);
                //this will check the output
                if (list.get(i)==list.get(j) && i != j){
                    //i and j will never check each other on the same index
                    return true;
                }
            }
        }
        return false;
    }

    //2.2
    public static List<Integer> allMultiples(List<Integer> list, int factor){
        //I have to find factors
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % factor == 0){
                list1.add(list.get(i));
            }
        }
        return list1;
    }

    //2.3
    public static List<String> allStringsOfSize(List<String> list, int length){
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
           if (list.get(i).length() == length){
               list1.add(list.get(i));
           }
        }
        return list1;
    }



    public static <E extends Comparable<E>> boolean isPermutationSorting(List<E> list, List<E> list1){
        Collections.sort(list);
        Collections.sort(list1);
        if(list.size() != list1.size()){
            return false;
        }

        return true;
    }



        //2.4
    public static <E > boolean isPermutation(List<E> list, List<E> list1){
        //I would have to check all index one by one
        //if at least one of them work or contains it then it would be fine

        //another way to do this is to sort both list before doing it
        // (might have a problem with string).
        //another way is to match every index and counting the total matched index

        if(list.size() != list1.size()){
            return false;
        }

        for (E item : list) {
            int contains = 0;
            int contains1 = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(item)) {
                    contains++;
                }
            }

            //System.out.println(contains + " C");
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).equals(item)) {
                    contains1++;
                }
            }
            //System.out.println(contains1 + " C1");
            if (contains1 != contains) {
                return false;
            }
        }

//        int contains = 0;
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list1.size(); j++) {
//                if (list.get(i).equals(list1.get(j)) && (list1.size()==list.size())){
//                    contains++;
//                }
//            }
//        }
//        if (contains >= list.size()){
//            return true;
//        }
        return true;
    }

    //2.5
    public static List<String> stringToListOfWords(String sentence){
        List<String> list;
        String str = sentence.replace("!","")
                .replace("?", "")
                .replace("'", "")
                .replace(";", "")
                .replace(":", "")
                .replace("'", "")
                .replace(",", "");
        list = Arrays.asList(str.split("\\s+"));
        return list;
    }

    //2.6
    public static void removeAllInstances(List<Integer> list, int remove){
        list.removeAll(Arrays.asList(remove));
    }

}