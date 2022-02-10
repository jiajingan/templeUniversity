import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

import javax.swing.border.Border;
import java.util.*;

public class graphExample {
    public static void main(String[] args) {
        //System.out.println("yes");
//        SparseGraph<String, Integer> g = new SparseGraph<>();
//        g.addEdge(1, "A", "B");
//        g.addEdge(2, "A", "C");
//        g.addEdge(3, "B", "D");
//        g.addEdge(4, "C", "E");
//        g.addEdge(5, "C", "F");
//        System.out.println(g);
        //sparse graph - less edges
        //dense graph - graph with "fuck tons of edges"

        //Rosen Examples
        SparseGraph<Integer,String> g = new SparseGraph<>();
        g.addEdge("A", 0, 1);
        g.addEdge("B", 0, 3);
        g.addEdge("C", 1, 2);
        g.addEdge("D", 3, 2);
        g.addEdge("E", 2, 9);
        g.addEdge("F", 2, 8);
        g.addEdge("G", 1, 4);
        g.addEdge("H", 1, 6);
        g.addEdge("I", 1, 7);
        g.addEdge("J", 4, 5);
        g.addEdge("K", 4, 6);
        g.addEdge("L", 4, 7);
        g.addEdge("M", 7, 6);
        System.out.println(g);
        System.out.println();
        //expected output: visted 0 1 3 2 4 6 7 8 9


        Stack<Integer> discovery = new Stack<>();
        HashMap<Integer, List<Integer>> ancestor = new HashMap<>();
        SparseGraph<Integer,String> depth = new SparseGraph<>();
        ArrayList<Integer> visitedDF = new ArrayList<>();
        depth.addEdge("A", 0, 1);
        depth.addEdge("B", 0, 2);
        depth.addEdge("C", 0, 3);
        depth.addEdge("D", 0, 4);
        depth.addEdge("E", 1, 3);
        depth.addEdge("F", 1, 4);
        depth.addEdge("G", 3, 4);
        depth.addEdge("H", 2, 6);
        depth.addEdge("I", 2, 5);
        depth.addEdge("J", 5, 6);
        System.out.println(depth);
        System.out.println("DepthFirst Search");
        System.out.println(depthFirst(depth,0, visitedDF,discovery, ancestor));
        System.out.println();
        //BreadthFirst - queue
        //visited??
        //g is unvisited
        //BF is visited
        //q is identified
//        ArrayList<String> visitedBF = new ArrayList<>();
//        Queue<String> identified = new LinkedList<>();
//        identified.add("A"); //starting point
//        while(!identified.isEmpty()){
//            String current = identified.remove();
//            visitedBF.add(current);
//            for (String neighbor: g.getNeighbors(current)) {
//                if (!identified.contains(neighbor)&& !visitedBF.contains(neighbor)){
//                    //add back unvisited
//                    identified.add(neighbor);
//                }
//            }
////
////            for (int i = 0; i < visitedBF.size(); i++) {
////                if (!q.contains(visitedBF.get(i))){//if queue does not contain visited
////
////                }
////            }
//            System.out.println(identified);
//        }

        System.out.println("BreathFirstSearch");
        ArrayList<Integer> visitedBF = new ArrayList<>();
        Queue<Integer> identified = new LinkedList<>();
        identified.add(0); //starting point
        while(!identified.isEmpty()){
            //difference between poll and remove???
            int current = identified.poll();
            visitedBF.add(current);
            for (int neighbor: g.getNeighbors(current)) {
                if (!identified.contains(neighbor)&& !visitedBF.contains(neighbor)){
                    //add back unvisited
                    identified.add(neighbor);
                }
            }
            System.out.println(identified);
        }
        System.out.println(visitedBF);

    }

    public static ArrayList<Integer> depthFirst(
            Graph<Integer, String> graph, int starting, ArrayList<Integer> visited,
            Stack<Integer> discovery, HashMap<Integer, List<Integer>> ancestor){


        discovery.push(starting);

        for (int neighbor: graph.getNeighbors(starting)) {
            if (!discovery.contains(neighbor)){
//                List<Integer> temp = new ArrayList<>();
//                if (ancestor.containsKey(starting)){
//                    temp = ancestor.get(starting);
//                }
//                temp.add(neighbor);
//                ancestor.put(starting,temp);

                visited = depthFirst(graph, neighbor, visited, discovery, ancestor);
                //this means that its looking for the neighbor of the neighbor
            }
        }
        visited.add(starting);

        return visited;
    }
}
