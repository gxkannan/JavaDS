/**
 * Representing a Graph with a list of Edges and a list of Vertices.
 * @author Gaia Kannan
 * @version 1.0
 */

import java.util.LinkedList;

public class Graph {
    private LinkedList<Edge> edgeList = new LinkedList<>();
    private LinkedList<Vertex> vertexList = new LinkedList<>();

    /**
     * The default constructor.
     */
    public Graph(){
    }

    /**
     * Returns the number of Vertices in this Graph.
     * @return The number of Vertices in this Graph.
     */
    public int vertices(){
        return vertexList.size();
    }

    /**
     * Returns the number of Edges in this Graph.
     * @return The number of Edges in this Graph.
     */
    public int edges(){
        return edgeList.size();
    }

    /**
     * Return the value of an Edge given that Edge's Vertices.
     * @param a The first Vertex of the Edge.
     * @param b The second Vertex of the Edge.
     * @return The value of this Edge.
     */
    public int getValue(Vertex a, Vertex b){
        return getEdge(a, b).getValue();
    }

    /**
     * Return the value of an Edge given that Edge.
     * @param edge The Edge to return the value of.
     * @return The value of the given Edge.
     */
    public int getValue(Edge edge){
        return edge.getValue();
    }
    /**
     * Add an Edge to this Graph given two Vertices and a value.
     * @param a The first Vertex to create an Edge with.
     * @param b THe second Vertex to create an Edge with.
     * @param value The value of this Edge.
     */
    public void addEdge(Vertex a, Vertex b, int value){
        Edge edge = new Edge(a, b, value);
        edgeList.add(edge);
        getVertex(a.value());
        getVertex(b.value());
    }

    /**
     * Add an Edge to this Graph given an Edge object.
     * @param edge The Edge to add to this Graph.
     */
    public void addEdge(Edge edge){
        edgeList.add(edge);
    }

    /**
     * Remove a given Edge.
     * @param edge The Edge to remove.
     */
    public void removeEdge(Edge edge){
        edgeList.remove(edge);
    }

    /**
     * Get an Edge given its two Vertices.
     * @param a The Edge's first Vertex.
     * @param b The Edge's second Vertex.
     * @return The Edge with these two Vertices.
     */
    public Edge getEdge(Vertex a, Vertex b){
        int i = 0;
        while (i < edges()){
            if (edgeList.get(i).getX() == a && edgeList.get(i).getY() == b){
                return edgeList.get(i);
                }
            if (edgeList.get(i).getY() == a && edgeList.get(i).getX() == b){
                return edgeList.get(i);
            }
            i++;
        }
        return null;
    }

    /**
     * Get the index of the Vertex which stores a given value.
     * @param data Data to search for in vertices.
     * @return The index of the Vertex containing a given value.
     */
    public int getVertex(int data){
        int i = 0;
        while (i < vertices()){
            if (vertexList.get(i).value().equals(data)){
                return i;
            }
            i++;
        }
        Vertex vertex = new Vertex(data);
        vertexList.add(vertex);
        return vertices()-1;
    }

    /**
     * Sort Edges according to the Integer values of their Vertices.
     */
    public void sortEdges() {
        for (int i = 0; i < edges(); ++i) {
            for (int j = i + 1; j < edges() - 1; ++j) {
                if (edgeList.get(j).getX().value() < (edgeList.get(i).getX().value())) {
                    Edge temp = edgeList.get(j);
                    edgeList.set(j, edgeList.get(i));
                    edgeList.set(i, temp);
                }
                if (edgeList.get(j).getX().value().equals(edgeList.get(i).getX().value()) &&
                        edgeList.get(j).getY().value() < (edgeList.get(i).getY().value())) {
                    Edge temp = edgeList.get(j);
                    edgeList.set(j, edgeList.get(i));
                    edgeList.set(i, temp);
                }
            }
        }
    }

    /**
     * Check to see if another object is equal to this graph.
     * @param o
     * @return False if they are not equal, true if they are.
     */
    public boolean equals(Object o){
        if(o.getClass() != this.getClass()) {
            return false;
        }
        else if (((Graph) o).vertices() != this.vertices() ||
                ((Graph) o).edges() != this.edges()){
            return false;
        }
        else if ((((Graph) o).vertexList.equals(this.vertexList)) &&
                    ((Graph) o).edgeList.equals(this.edgeList)){
            return true;
        }
        else return false;
    }

    /**
     * Get the list of all edges.
     * @return The list of all edges.
     */
    public LinkedList<Edge> getEdgeList() {
        return edgeList;
    }

    /**
     * Get the list of all vertices.
     * @return The list of all vertices.
     */
    public LinkedList<Vertex> getVertexList() {
        return vertexList;
    }

    /**
     * Creates a String representation of this Graph.
     * @return A String representation of this Graph.
     */
    @Override
    public String toString() {
        sortEdges();
        String str = "";
        int i = 0;
        while (i < edgeList.size()-1){
            str = str + edgeList.get(i).toString();
            str = str + "\t|\t";
                if (edgeList.get(i).getX().value() != edgeList.get(i+1).getX().value()) {
                    str = str + "\n";
                }
            i++;
        }
        return str;
    }
}
