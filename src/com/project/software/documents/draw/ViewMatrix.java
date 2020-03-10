package com.project.software.documents.draw;

import com.project.software.documents.draw.components.Plotable;

/**
 * Creates a graphic with X weight and Y height.
 * The (0,0) coordinate is in the bottom-left side.
 */
public class ViewMatrix {

    /**
     * The graphic matrix
     */
    private final Character[][] screen;

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
        screen = new Character[ySize][xSize];
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
                System.out.print(screen[i][j] + " ");
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
                 screen[i][j] = '.';
            }
        }
    }

    /**
     * plot a point.
     * @param point A {@link Point} to be plotted;
     */
    public void plot (Point point){
        if (point.Y < ySize && point.X < xSize) {
            screen[point.Y][point.X] = '@';
        }
    }

    /**
     * Plot an element.
     * @param element A {@link Plotable} element.
     */
    public void plot (Plotable element){
        element.getPoints().forEach(this::plot);
    }

}
