package com.project.software.documents.draw.plane.components;

import com.project.software.documents.draw.plane.Plotable;
import com.project.software.documents.draw.plane.Point;
import com.project.software.documents.draw.plane.components.geometry.Triangle;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An representation for a Line
 */
public class Line implements Scalable, Rotatable {

    /**
     * Stores the two points of the line.
     */
    private Point[] points = new Point[2];

    /**
     * Creates a new line segment for the given points.
     * @param origin the initial point of the line and
     *               the one used to rotate the line.
     * @param pointB the final point of the line.
     */
    public Line (Point origin, Point pointB){
        points[0] = origin;
        points[1] = pointB;
    }

    private Line(Point... points){
        this.points = points;
    }

    // private methods

    /**
     * Generate the points of the line on a Y-relative way.
     * @param point0 the origin of the line.
     * @param point1 the endpoint of the line.
     * @return all the points of the line.
     */
    private List<Point> plotHigh(Point point0, Point point1) {
        List<Point> pointList = new LinkedList<>();
        int deltaX = point1.X - point0.X;
        int deltaY = point1.Y - point0.Y;
        int increment = 1;
        int x = point0.X, err;
        if (deltaX < 0){
            increment = -1;
            deltaX = -deltaX;
        }
        err = 2 * deltaX - deltaY;
        for (int y = point0.Y; y < point1.Y; y++){
            pointList.add(new Point(x, y));
            if (err > 0){
                x = x + increment;
                err = err - 2 * deltaY;
            }
            err = err + 2 * deltaX;
        }
        pointList.add(point1);
        return pointList;
    }

    /**
     * Generate the points of the line on a X-relative way.
     * @param point0 the origin of the line.
     * @param point1 the endpoint of the line.
     * @return all the points of the line.
     */
    private List<Point> plotLong(Point point0, Point point1) {
        List<Point> pointList = new LinkedList<>();
        int deltaX = point1.X - point0.X;
        int deltaY = point1.Y - point0.Y;
        int increment = 1;
        int y = point0.Y, err;
        if (deltaY < 0){
            increment = -1;
            deltaY = -deltaY;
        }
        err = 2 * deltaY - deltaX;
        for (int x = point0.X; x < point1.X; x++){
            pointList.add(new Point(x, y));
            if (err > 0){
                y = y + increment;
                err = err - 2 * deltaX;
            }
            err = err + 2 * deltaY;
        }
        pointList.add(point1);
        return pointList;
    }

    // methods from Plotable

    @Override
    public Collection<Point> getPoints() {
        int deltaX = points[1].X - points[0].X;
        int deltaY = points[1].Y - points[0].Y;
        if (Math.abs(deltaY) < Math.abs(deltaX)){
            if (points[1].isLongerThan(points[0])) {
                return plotLong(points[0], points[1]);
            }
            return plotLong(points[1], points[0]);
        }
        if (points[1].isHigherThan(points[0])){
            return plotHigh(points[0], points[1]);
        }
        return plotHigh(points[1], points[0]);
    }

    /**
     * Changes the line and then return this same line
     * (useful for fluent interface).
     * @param xAmount the amount added to X coordinates
     *                (negative numbers are accepted).
     * @param yAmount the amount added to Y coordinates
     *                (negative numbers are accepted).
     * @return this line (after the change)
     */
    @Override
    public Line translate(int xAmount, int yAmount) {
        Point[] newPoints = new Point[3];
        Arrays.stream(points)
                .map(point ->  point = point.translate(xAmount, yAmount))
                .collect(Collectors.toList()).toArray(newPoints);
        return new Line(newPoints);
    }

    // methods from Scalable

    @Override
    public Line resize(double xScale, double yScale) {
        Arrays.stream(points)
                .map(point ->  point = new Point((int) Math.round(point.X * xScale), (int) Math.round(point.Y * yScale)))
                .collect(Collectors.toList()).toArray(points);
        return this;
    }

    // methods from Rotatable

    /**
     * Rotates the line using the first passed point
     * as reference.
     * @param degrees The degrees of the angle.
     * @return this line after the rotation.
     */
    @Override
    public Plotable rotate(double degrees) {
        Point point = points[1].translate(-points[0].X, -points[0].Y);
        point = Point.rotateByOrigin(point, degrees);
        points[1] = point.translate(points[0].X, points[0].Y);
        return this;
    }

}

