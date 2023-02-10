/**
 * A class for the testing of the Vertex, Edge, Graph, and Iterator classes.
 * @author Gaia Kannan
 * @version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) throws FileNotFoundException {
        start();
    }
    public static void start() throws FileNotFoundException {
        Graph graph = new Graph();
        GraphIterator graphIterator = new GraphIterator(graph);
        create(graph, graphIterator);
        display(graph, graphIterator);
    }

    /**
     * Display the graph in the form of (Vertex a, Vertex b): Weight
     * @param graph The graph we're displaying
     * @param graphIterator The iterator
     * @throws FileNotFoundException
     */
    public static void create(Graph graph, GraphIterator graphIterator) throws FileNotFoundException {
        File file = new File("edges.txt");
        Scanner filescan = new Scanner(file);
        filescan.nextLine();
        filescan.useDelimiter("\t|\n");
        while (filescan.hasNext()){
            Vertex a = new Vertex(filescan.nextInt());
            Vertex b = new Vertex(filescan.nextInt());
            graph.addEdge(a, b, filescan.nextInt());
        }
        graphIterator.BFS();
    }
    public static void display(Graph graph, GraphIterator graphIterator){
        System.out.println(graphIterator.toString());
        System.out.println(graph.toString());
    }
}
