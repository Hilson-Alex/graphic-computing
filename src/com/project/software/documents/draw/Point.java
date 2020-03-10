package com.project.software.documents.draw;

/**
 * Represents a coordinate.
 */
public class Point {

    /**
     * X coordinate.
     */
    public final int X;

    /**
     * Y coordinate.
     */
    public final int Y;

    /**
     * default constructor.
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    public Point(int x, int y){
        this.X = x;
        this.Y = y;
    }

    /**
     * Verifies if a point have an greater y coordinate.
     * @param point a point to be compared.
     * @return true if this y coordinate is greater.
     */
    public boolean isHigherThan (Point point) {
        return this.Y > point.Y;
    }

    /**
     * Verifies if a point have an greater x coordinate.
     * @param point a point to be compared.
     * @return true if this x coordinate is greater.
     */
    public boolean isLongerThan (Point point){
        return this.X > point.X;
    }

    /**
     * Verifies if a point have an greater or equal y
     * coordinate.
     * @param point a point to be compared.
     * @return true if this y coordinate is greater or
     * equal.
     */
    public boolean isHigherOrEqual(Point point){
        return isHigherThan(point) || this.Y == point.Y;
    }

    /**
     * Verifies if a point have an greater or equal x
     * coordinate.
     * @param point a point to be compared.
     * @return true if this x coordinate is greater or
     * equal.
     */
    public boolean isLongerOrEqual(Point point){
        return isLongerThan(point) || this.X == point.X;
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
