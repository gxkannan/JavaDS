/**
 * Representing a Graph Iterator using the Java Iterator interface.
 * @author Gaia Kannan
 * @version 1.0
 */

import java.util.Iterator;
import java.util.LinkedList;

public class GraphIterator {
    private Graph graph;
    private LinkedList<Vertex> queue = new LinkedList<Vertex>();
    private LinkedList<Vertex> list = new LinkedList<Vertex>();
    private int i = 0;
    private Iterator<Vertex> iterator = new Iterator<Vertex>() {
        /**
         * Does this graph have a next Vertex?
         * @return True if there is a next Vertex, false if not.
         */
        @Override
        public boolean hasNext() {
            if (i < graph.vertices()) return true;
            else return false;
        }

        /**
         * Returns the next Vertex in this graph.
         * @return The next vertex in this graph.
         */
        @Override
        public Vertex next() {
            if (!iterator.hasNext()) return null;
            Vertex v = graph.getVertexList().get(i);
            i++;
            return v;
        }
    };

    /**
     * Constructs a Graph Iterator given a Graph.
     * @param graph Graph to iterate with this Graoh Iterator.
     */
    public GraphIterator(Graph graph){
        this.graph = graph;
    }

    /**
     * Performs a Breadth-First Search on this graph.
     */
    public void BFS (){
        Vertex vertex = graph.getVertexList().get(0);
        vertex.visit();
        queue.add(vertex);
        list.add(vertex);
        while (queue.size() != 0){
            vertex = queue.poll();
            while (iterator.hasNext()){
                Vertex v = iterator.next();
                if (!v.isVisited()){
                    v.visit();
                    list.add(v);
                    queue.add(v);
                }
            }
        }
    }

    /**
     * Returns a String representation of the List of vertices.
     * @return
     */
    @Override
    public String toString(){
        return list.toString();
    }
}
