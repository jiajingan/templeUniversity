import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class password {
    public static void main(String[] args) throws FileNotFoundException {
        //SparseGraph<Integer, String> g = new SparseGraph<>();
        //linux
        String path = "/home/jackie/IdeaProjects/CIS2168/password/src/p079_keylog.txt";
        //http://alexmic.net/password-derivation-project-euler/
        String password = "";
        DirectedSparseGraph<Integer,String> g = new DirectedSparseGraph<>();
        //scan all the integers
        Scanner scan = new Scanner(new File(path));
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            //System.out.println(line);
            int first = Integer.parseInt(String.valueOf(line.charAt(0)));
            int second = Integer.parseInt(String.valueOf(line.charAt(1)));
            int third = Integer.parseInt(String.valueOf(line.charAt(2)));

            g.addEdge(first+""+second,first,second);
            g.addEdge(second+""+third, second, third);
            //storing all the inputs for first, second, third
        }

        while (g.getEdgeCount() != 1){
            //keep going until it reaches on connections
            for (int adjacency: g.getVertices()) {
                if (g.inDegree(adjacency) == 0){
                    //this will check all the same in degree with other vertices
                    password +=adjacency;
                    break;
                }
            }
            int code = Integer.parseInt(String.valueOf(password.charAt(password.length()-1)));
            //remove the redundant
            g.removeVertex(code);
        }
        password += g.getEdges().toArray()[0];
        //add us the code
        System.out.println(password);

        //procedure
        /*
        if something comes before it add before it
        know when to add before after, middle
         */

//        g.addEdge("A", 0, 1);
//        g.addEdge("B", 0, 3);
//        g.addEdge("C", 1, 2);
//        g.addEdge("D", 3, 2);
//        g.addEdge("E", 2, 9);
//        g.addEdge("F", 2, 8);
//        g.addEdge("G", 1, 4);
//        g.addEdge("H", 1, 6);
//        g.addEdge("I", 1, 7);
//        g.addEdge("J", 4, 5);
//        g.addEdge("K", 4, 6);
//        g.addEdge("L", 4, 7);
//        g.addEdge("M", 7, 6);
//        System.out.println(g);
//        System.out.println();
//
//        System.out.println(breathFirst(g, 0));

    }



}
