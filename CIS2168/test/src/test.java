import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("redo");
        test.add("rewrite");
        test.add("review");
    }

    public static void removePrefixStrings(List<String> list, String prefix){
       int index = 0;

        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if(word.startsWith(prefix)){
                word = word.replaceAll(prefix, "");
            } else {

            }
            list.set(index,word);
            index++;
        }
    }
//    public void removeDuplicates(){
//        Node Current = head;
//
//        while (Current != null ){
//
//            Current1 = head;
//            while (Current1 = null) {
//                if (Current.next.item == Current1.item) {
//                    Current1.next == Current.next.next;
//                } else {
//                    Current1 = Current1.next;
//                }
//                Current = Current.next;
//            }
//        }
//    }
//
//    public static SortedLinkedList sortedIntersect(SortedLinkedList A, SortedLinkedList B){
//        int index = 0;
//
//        LinkedList<Integer> intersect = new LinkedList<>();
//        for (int i = 0; i < A.size(); i++) {
//            for (int j = 0; j < B.size(); j++) {
//                if (A.get(index) == B.get(index)){
//                    intersect.add(B.get(index));
//                }
//            }
//        }
//        intersect.removeDuplicates();
//        return intersect;
//    }

}
