import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree {

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;

	// Make your constructor
	// It doesn't need to do anything
	
	// complete the methods below
	public IndexTree()
	{

	}

	// this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
		root = add(this.root, word, lineNumber);
	}
	
	
	
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if (root == null){
			return new IndexNode(word,lineNumber);
		}
		int comparison = word.compareToIgnoreCase(root.word);
		if (comparison == 0){
			//if it already exist add it to the index node that already exist
			root.occurences++;
			root.list.add(lineNumber);
		} else if(comparison < 0){
			root.left = add(root.left, word, lineNumber);
			return root;
		} else {
			root.right = add(root.right, word, lineNumber);
			return root;
		}
		return root;
	}
	
	
	
	
	// returns true if the word is in the index
	public boolean contains(String word){
		//if (word == null){
		//	return false;
		//} else {
			return contains(root, word);
		//}
	}

	public boolean contains(IndexNode root, String word){
		if (root == null){
			return false;
		}
		int comparison = word.compareToIgnoreCase(root.word);
		if (comparison == 0){
			return true;
		} else if (comparison < 0){
			return contains(root.left, word);
		} else {
			return contains(root.right, word);
		}
	}
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
		this.root = this.delete(this.root, word);
	}
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.
	private IndexNode delete(IndexNode root, String word){
		if (root == null) {
			return null;
		}
		int comparsion = word.compareToIgnoreCase(root.word);
		if (comparsion < 0){
			root.left = delete(root.left, word);
			return root;
		} else if (comparsion > 0 ){
			root.right = delete(root.right, word);
			return root;
		} else {
			if (root.left == null && root.right == null){
				return null;
			} else if (root.left != null && root.right == null){
				return root.left;
			} else if (root.left == null && root.right != null){
				return root.right;
			} else{
				IndexNode current = root.left;
				while(current.right != null){
					current = current.right;
				}
				root.word = current.word;
				root.left = delete(root.left, root.word);
				return root;
			}
		}
	}
	
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){


//		StringBuilder sb = new StringBuilder();
//		InOrderTraverse(this.root, 1, sb);
		printIndex(this.root);
	}

	private void printIndex(IndexNode root){
		if (root == null){
//
//			System.out.println();
//			System.out.println();
//			System.out.println();
			return;
		}

		printIndex(root.left);
		System.out.println(root);
		printIndex(root.right);



//		String empty = "";
//		if(root == null){
//			System.out.print(empty);
//		}
//		String output = "";
//		output += root.left;
//		output += root.word + " ";
//		output += root.right;
//
//		System.out.print(output);
	}

//		private void InOrderTraverse(IndexNode root, int depth, StringBuilder sb){
//		for (int i = 0; i < depth; i++) {
//			sb.append(" ");
//		}
//		if (root == null){
//			sb.append("null\n");
//		} else {
//			InOrderTraverse(root.left, depth+1 ,sb);
//			sb.append("\n");
//			sb.append(root.toString());
//			InOrderTraverse(root.right, depth+1 ,sb);
//		}
//	}

	
	public static void main(String[] args){
		IndexTree index = new IndexTree();
		// add all the words to the tree
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
			int count  = 0;
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				line = line.replaceAll("'","")
						.replaceAll("\\W+", " ")
						.replaceAll("\\d", "");

				String[] words = line.split("\\s+");
				count++;
				for (String word:words) {
					index.add(word, count);
				}


			}


			System.out.println("Before");
			index.printIndex();
			System.out.println(index.contains("brown"));
			index.delete("brown");
			System.out.println();
			System.out.println("After");
			index.printIndex();
			System.out.println(index.contains("brown"));
			scanner.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// print out the index
		//index.printIndex();
		// test removing a word from the index
		//index.printIndex();
	}
}
