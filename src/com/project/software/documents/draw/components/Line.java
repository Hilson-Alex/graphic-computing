package com.project.software.documents.draw.components;

import com.project.software.documents.draw.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * An representation for a Line
 */
public class Line implements Plotable {

    /**
     * Stores the two points of the line.
     */
    private Point[] points = new Point[2];

    /**
     * Creates a new line for the given points.
     * @param pointA the initial point of the line.
     * @param pointB the final point of the line.
     *
     * Obs: there's no real initial or final point.
     * It's just an abstraction, but there's no order.
     */
    public Line (Point pointA, Point pointB){
        points[0] = pointA;
        points[1] = pointB;
    }

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
    private List<Point> plotLow(Point point0, Point point1) {
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

    @Override
    public List<Point> getPoints() {
        int deltaX = points[1].X - points[0].X;
        int deltaY = points[1].Y - points[0].Y;
        if (Math.abs(deltaY) < Math.abs(deltaX)){
            if (points[1].isLongerThan(points[0])){
                return plotLow(points[0], points[1]);
            }
            return plotLow(points[1], points[0]);
        }
        if (points[1].isHigherThan(points[0])){
            return plotHigh(points[0], points[1]);
        }
        return plotHigh(points[1], points[0]);
    }
}

