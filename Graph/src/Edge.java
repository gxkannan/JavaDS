/**
 * Representinga an Edge with two Vertices and a value.
 * @author Gaia Kannan
 * @version 1.0
 */
public class Edge {
    private Vertex x;
    private Vertex y;
    private int value;

    /**
     * Constructs an edge with two Vertices and a value.
     * @param x The first Vertex, representing an X coordinate.
     * @param y The second Vertex, representing a Y coordinate.
     * @param value This Edge's value.
     */
    public Edge (Vertex x, Vertex y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }

    /**
     * Get the X value for this Edge.
     * @return The Vertex representing this edge's X value.
     */
    public Vertex getX() {
        return x;
    }

    /**
     * Get the value of this Edge.
     * @return The value of this Edge.
     */
    public int getValue() {
        return value;
    }

    /**
     * Get the Y value for this Edge.
     * @return The Y value for this Edge.
     */
    public Vertex getY() {
        return y;
    }

    /**
     * Set the value of this Edge.
     * @param value The value for this Edge.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Set the X value for this edge.
     * @param x The Vertex representing the X value for this Edge.
     */
    public void setX(Vertex x) {
        this.x = x;
    }

    /**
     * Set the Y value for this edge.
     * @param y The Vertex representing the Y value for this Edge.
     */
    public void setY(Vertex y) {
        this.y = y;
    }

    @Override
    /**
     * Return a string representation of this Edge.
     */
    public String toString() {
        return "(" + x.toString() + ", " + y.toString() + "): " + value;
    }
}
