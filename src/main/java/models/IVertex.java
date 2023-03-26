package models;

/**
 * An interface representing a vertex (highest/lowest) point of a line on a graph
 *
 * Contains simple getter and setter for x- and y- coordinates
 *
 * @author Terence Lee
 * */
public interface IVertex {


    /**
     * Setter for the x-coordinate
     *
     * @param xCoordinate the x-coordinate of the vertex
     * */
    public void setXCoordinate(double xCoordinate);

    /**
     * Getter for the x-coordinate of the vertex
     * */
    public double getXCoordinate();


    /**
     * Setter for the y-coordinate of the vertex
     *
     * @param yCoordinate the y-coordinate of the vertex
     * */
    public void setYCoordinate(double yCoordinate);


    /**
     * Getter for the y-coordinate of the vertex
     * */
    public double getYCoordinate();
}
