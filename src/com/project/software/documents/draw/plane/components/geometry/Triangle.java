package com.project.software.documents.draw.plane.components.geometry;

import com.project.software.documents.draw.plane.Plotable;
import com.project.software.documents.draw.plane.Point;
import com.project.software.documents.draw.plane.components.Line;
import com.project.software.documents.draw.plane.components.Rotatable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Triangle implements Geometric2D, Rotatable {

    /**
     * Stores the triangle vertices
     */
    private Point[] points = new Point[3];

    /**
     * Creates a new triangle for the given lines.
     * @param point0 A vertex of the triangle.
     * @param point1 A vertex of the triangle.
     * @param point2 A vertex of the triangle
     */
    public Triangle(Point point0, Point point1, Point point2){
        points[0] = point0;
        points[1] = point1;
        points[2] = point2;
    }

    @Override
    public Collection<Point> getPoints() {
        HashSet<Point> pointSet = new HashSet<>();
        pointSet.addAll(new Line(points[0], points[1]).getPoints());
        pointSet.addAll(new Line(points[0], points[2]).getPoints());
        pointSet.addAll(new Line(points[1], points[2]).getPoints());
        return pointSet;
    }

    /**
     * Changes the triangle and then return this same line
     * (useful for fluent interface).
     * @param xAmount the amount added to X coordinates
     *                (negative numbers are accepted).
     * @param yAmount the amount added to Y coordinates
     *                (negative numbers are accepted).
     * @return this triangle (after the change)
     */
    @Override
    public Triangle translate(int xAmount, int yAmount) {
        Arrays.stream(points)
                .map(point ->  point = point.translate(xAmount, yAmount))
                .collect(Collectors.toList()).toArray(points);
        return this;
    }

    @Override
    public Plotable resize(double xScale, double yScale) {
        Arrays.stream(points)
                .map(point ->  point = new Point((int) Math.round(point.X * xScale), (int) Math.round(point.Y * yScale)))
                .collect(Collectors.toList()).toArray(points);
        return this;
    }

    @Override
    public Plotable rotate(double degrees) {
        Point centroid = getCentroid();
        Arrays.stream(points)
                .map(point -> {
                    point = point.translate(-centroid.X, -centroid.Y);
                    point = Point.rotateByOrigin(point, degrees);
                    return point.translate(centroid.X, centroid.Y);
                }).collect(Collectors.toList()).toArray(points);
        return this;
    }

    @Override
    public Point getCentroid() {
        int x = Arrays.stream(points).mapToInt(point -> point.X).sum() / 3;
        int y = Arrays.stream(points).mapToInt(point -> point.Y).sum() / 3;
        return new Point(x, y);
    }
}
