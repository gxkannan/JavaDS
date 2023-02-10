/**
 * Representing a Vertex object for use in an Edge and Graph.
 * @author Gaia Kannan
 * @version 1.0
 */
public class Vertex {
    private Integer data;
    private boolean visited = false;

    /**
     * Constructs a Vertex given a data value.
     * @param data The value of this Vertex.
     */
    public Vertex(Integer data){
        this.data = data;
    }

    /**
     * Returns the value of this Vertex.
     * @return The value of this Vertex.
     */
    public Integer value(){
        return data;
    }

    /**
     * Checks if this Vertex has been visited.
     * @return True if it has, False if not.
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Marks this Vertex as visited.
     */
    public void visit() {
        this.visited = true;
    }

    /**
     * Returns a String representation of this Vertex.
     * @return A String representation of this Vertex.
     */
    @Override
    public String toString() {
        String str = "";
        return str = str + data;
    }
}
