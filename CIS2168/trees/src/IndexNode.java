import java.util.ArrayList;
import java.util.List;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list;
	IndexNode left;
	IndexNode right;
	
	
	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1
	public IndexNode(String word, int linenum)
	{
		this.word = word;
		this.list = new ArrayList<>();
		list.add(linenum);
		this.occurences = 1;

	}
	
	
	
	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line

	public String toString(){
		return word + ":" + occurences + " occurences" +  list.toString();
	}


//	public String toString(){
//		StringBuilder sb = new StringBuilder();
//		preOrderTraverse(this.root, 1, sb);
//		return sb.toString();
//	}
//
//	private String toString(IndexNode root){
//
//		if(root == null){
//			return "";
//		}
//		String output = "";
//		output += toString(root.left) + "Occurences"+ root.occurences;
//		output += root.word + " ";
//		output += toString(root.right) + "Occurences: "+ root.occurences;
//		return output;
//	}
//
//	private void preOrderTraverse(IndexNode root, int depth, StringBuilder sb){
//		for (int i = 0; i < depth; i++) {
//			sb.append(" ");
//		}
//		if (root == null){
//			sb.append("null\n");
//		} else {
//			sb.append(root.toString());
//			sb.append("\n");
//			preOrderTraverse(root.left, depth+1 ,sb);
//			preOrderTraverse(root.right, depth+1 ,sb);
//		}
//	}
//
	
	
}
