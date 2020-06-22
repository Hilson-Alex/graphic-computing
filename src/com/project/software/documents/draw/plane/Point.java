package com.project.software.documents.draw.plane;

import java.util.Collection;
import java.util.List;

/**
 * Represents a coordinate.
 *
 * @implNote X and Y of Point are final. This
 * means that {@link Plotable} methods like
 * translate will return a new Point, and not
 * change the actual point.
 */
public class Point implements Plotable {

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

    /**
     * Rotate a point by the (0, 0) coordinate. Note that point does not implements
     * the {@link com.project.software.documents.draw.plane.components.Rotatable}
     * interface cause the point doesn't rotates by itself, but by the origin.
     * this method is not like Rotatable.rotate.
     * @param point the reference point that the position will be changed.
     * @param degrees the degrees of the position change
     * @return a new point with an position rotated by the origin from the point.
     */
    public static Point rotateByOrigin(Point point, double degrees){
        double radians = Math.toRadians(degrees);
        double x = point.X * Math.cos(radians) - point.Y * Math.sin(radians);
        double y = point.Y * Math.cos(radians) + point.X * Math.sin(radians);
        return new Point((int) Math.round(x), (int) Math.round(y));
    }

    @Override
    public Collection<Point> getPoints() {
        return List.of(this);
    }

    /**
     * Note that point has final attributes, so to store
     * the translated point you have to assign it.
     * @param xAmount the amount added to X coordinates
     *                (negative numbers are accepted).
     * @param yAmount the amount added to Y coordinates
     *                (negative numbers are accepted).
     * @return A new point object.
     */
    @Override
    public Point translate(int xAmount, int yAmount) {
        return new Point(this.X + xAmount, this.Y + yAmount);
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
