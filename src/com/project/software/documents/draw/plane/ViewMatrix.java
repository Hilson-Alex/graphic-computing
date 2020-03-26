package com.project.software.documents.draw.plane;

/**
 * Creates a graphic with X weight and Y height.
 * The (0,0) coordinate is in the bottom-left side.
 */
public class ViewMatrix {

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
    public void print (){
        for (int i = ySize - 1; i >= 0; i--){
            for (int j = 0; j < xSize; j++){
                System.out.print((screen[i][j]==0 ? '.' : '@') + " ");
            }
            System.out.println();
        }
    }

    /**
     * cleans the matrix. ('.' is used as an empty
     * coordinate and '@' is used as a point).
     */
    public void clean (){
        for (int i = 0; i < ySize; i++){
            for (int j = 0; j < xSize; j++){
                 screen[i][j] = 0;
            }
        }
    }

    /**
     * plot a point.
     * @param point A {@link Point} to be plotted;
     */
    public void plot (Point point){
        if (isBetweenEdge(point)) {
            screen[point.Y][point.X] = 1;
        }
    }

    /**
     * Plot an element.
     * @param element A {@link Plotable} element.
     */
    public void plot (Plotable element){
        element.getPoints().forEach(this::plot);
    }

    /**
     * Verifies if a point is between the edges of the Matrix.
     * @param point The point to be verified.
     * @return True if the point is between the edges of the
     *          matrix.
     */
    private boolean isBetweenEdge (Point point){
        return point.Y < ySize && point.Y >= 0 &&
               point.X < xSize && point.X >=0;
    }

}
