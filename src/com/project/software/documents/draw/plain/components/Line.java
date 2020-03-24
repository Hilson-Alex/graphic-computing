package com.project.software.documents.draw.plain.components;

import com.project.software.documents.draw.plain.Point;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An representation for a Line
 */
public class Line implements Scalable {

    /**
     * Stores the two points of the line.
     */
    private Point[] points = new Point[2];

    /**
     * Creates a new line segment for the given points.
     * @param origin the initial point of the line.
     * @param endPoint the final point of the line.
     *
     * Obs: The origin will be the point used to rotate
     * The line.
     */
    public Line (Point origin, Point endPoint){
        points[0] = origin;
        points[1] = endPoint;
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
        int increment = 1, x = point0.X, err;
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
        int increment = 1, y = point0.Y, err;
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
            if (points[1].isLongerThan(points[0])){
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
        Arrays.stream(points)
                .map(point ->  point = point.translate(xAmount, yAmount))
                .collect(Collectors.toList()).toArray(points);
        return this;
    }

    // methods from Scalable

    @Override
    public Line resize(float xScale, float yScale) {
        Arrays.stream(points)
                .map(point ->  point = new Point(Math.round(point.X * xScale), Math.round(point.Y * yScale)))
                .collect(Collectors.toList()).toArray(points);
        return this;
    }
}

