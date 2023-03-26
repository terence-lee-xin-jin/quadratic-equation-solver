package models;



/**
 * An implementation of the IVertex interface
 * This class represents a vertex (highest/lowest) point of a line on a graph
 *
 * Contains simple getter and setter for x- and y- coordinates
 *
 * @author Terence Lee
 * */
public class Vertex implements IVertex{

    private double xCoordinate;
    private double yCoordinate;


    public Vertex(){

    }


    /**
     * Setter for the x-coordinate of the vertex
     *
     * @param xCoordinate the x-coordinate of the vertex
     * */
    @Override
    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }


    /**
     * Getter for the x-coordinate of the vertex
     * */
    @Override
    public double getXCoordinate() {
        return this.xCoordinate;
    }


    /**
     * Setter for the y-coordinate of the vertex
     *
     * @param yCoordinate the y-coordinate of the vertex
     * */
    @Override
    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }


    /**
     * Getter for the y-coordinate of the vertex
     * */
    @Override
    public double getYCoordinate() {
        return this.yCoordinate;
    }
}
