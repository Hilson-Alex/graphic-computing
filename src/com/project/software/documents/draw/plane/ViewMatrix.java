package com.project.software.documents.draw.plane;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Creates a graphic with X weight and Y height.
 * The (0,0) coordinate is in the bottom-left side.
 */
public class ViewMatrix implements Plotable {

    /**
     * The graphic matrix
     */
    private final Integer[][] screen;

    /**
     * max weight of the graphic
     */
    private final int xSize;

    /**
     * max height of the graphic
     */
    private final int ySize;

    /**
     * Define the screen position by an imaginary
     * cartesian plane.
     */
    private Point index = new Point(0,0);

    /**
     * Create a graphic matrix.
     * @param xSize the weight of the matrix.
     * @param ySize the height of the matrix.
     */
    public ViewMatrix (int xSize, int ySize){
        screen = new Integer[ySize][xSize];
        this.xSize = xSize;
        this.ySize = ySize;
        clean();
    }

    /**
     * Create a graphic matrix with default values.
     */
    public ViewMatrix (){
        this(45, 30);
    }

    /**
     * prints the matrix on terminal.
     */
    public ViewMatrix print (){
        for (int i = ySize - 1; i >= 0; i--){
            for (int j = 0; j < xSize; j++){
                System.out.print((screen[i][j]==0 ? '.' : '@') + "  ");
            }
            System.out.println();
        }
        return this;
    }

    /**
     * cleans the matrix. ('.' is used as an empty
     * coordinate and '@' is used as a point).
     */
    public ViewMatrix clean (){
        for (int i = 0; i < ySize; i++){
            for (int j = 0; j < xSize; j++){
                 screen[i][j] = 0;
            }
        }
        return this;
    }

    /**
     * plot a point.
     * @param point A {@link Point} to be plotted;
     */
    public ViewMatrix plot (Point point){
        if (isBetweenEdge(point)) {
            screen[point.Y - index.Y][point.X - index.X] = 1;
        }
        return this;
    }

    /**
     * Plot an element.
     * @param element A {@link Plotable} element.
     */
    public ViewMatrix plot (Plotable element){
        element.getPoints().forEach(this::plot);
        return this;
    }

    /**
     * Verifies if a point is between the edges of the Matrix.
     * @param point The point to be verified.
     * @return True if the point is between the edges of the
     *          matrix.
     */
    private boolean isBetweenEdge (Point point){
        point = point.translate(-index.X, -index.Y);
        return point.Y < ySize && point.Y >= 0 &&
               point.X < xSize && point.X >=0;
    }

    @Override
    public Collection<Point> getPoints() {
        LinkedList<Point> points = new LinkedList<>();
        for (int i = 0; i < ySize; i++){
            for (int j = 0; j < xSize; j++){
                if (screen[i][j] == 1){
                    points.add(new Point(j + index.X, i + index.Y));
                }
            }
        }
        return points;
    }

    @Override
    public Plotable translate(int xAmount, int yAmount) {
        this.index = new Point(xAmount, yAmount);
        return this;
    }
}
