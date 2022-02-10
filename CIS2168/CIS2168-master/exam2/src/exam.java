import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exam {

    private static class Node<E> {
        Node<E> left;
        Node<E> right;
        E item;

        public Node(E item){
            this.item = item;
        }


    }

    public static <E> int sizeTree(Node<E> root){
        if (root == null){
            return 0;
        } else {
            int rootSize = 1;
            int leftSize = sizeTree(root.left);
            int rightSize = sizeTree(root.right);
            return leftSize + rightSize + rootSize;
        }
    }
    public static <E> boolean isFull(Node<E> root){
        if (root == null){
            return true;
        } else{
            if (root.left == null && root.right ==null){
                return true;
            }else if (root.left != null && root.right ==null){
                return false;
            } else if (root.left == null && root.right !=null){
                return false;
            } else {//both are occupied
                return isFull(root.left) && isFull(root.right);
            }
        }
    }

    public static <E> boolean equals(Node<E> treeA, Node<E> treeB){
        if (treeA == null && treeB == null){
            return true;
        }
        else if (treeA !=null && treeB == null ){
            return false;
        } else  if (treeA == null && treeB !=null){
            return false;
        } else {
            if (!treeA.item.equals(treeB.item)){
                return false;
            }
            else {
                return equals(treeA.left, treeB.left) && equals(treeA.right, treeB.right);
            }
        }

    }

    public static Map<Character, Integer> count(String word){
        Map<Character, Integer> map = new HashMap<>();
        for (char letter: word.toCharArray()) {
            /*
            if (!map.containsKey(letter)){
                map.put(letter,1);
            } else{
                int sightings = map.get(letter);
                map.put(letter, sightings+1);
                //map.put(letter,map.get(letter)+1);
            }
             */
            int sightings = map.getOrDefault(letter, 0);
            map.put(letter, sightings+1);
        }
        return map;
    }


    public static Map<Integer, List<Integer>> SplitNum(int[]arr){
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int tt = 0;
        int three = 0;
        int five = 0;
        for (int num : arr) {
            if (num % 2 == 0){
                hm.put(2, new ArrayList<>());
                List<Integer> two = hm.get(num);//idk what I;m doing
                two.add(num);
            }
            if (num % 3 == 0){
                hm.put(3, new ArrayList<>());
                List<Integer> two = hm.get(num);//idk what I;m doing
                two.add(num);
            }
            if (num % 5 == 0){
                hm.put(5, new ArrayList<>());
                List<Integer> two = hm.get(num);//idk what I;m doing
                two.add(num);
            }
        }


        return hm;
    }

    public static void main(String[] args) {

    }
}
