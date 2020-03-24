package com.project.software.documents.draw.plain.components.geometry;

import com.project.software.documents.draw.plain.Plotable;
import com.project.software.documents.draw.plain.Point;
import com.project.software.documents.draw.plain.components.Line;
import com.project.software.documents.draw.plain.components.Scalable;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Triangle implements Scalable {

    private Point[] points = new Point[3];

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
    public Plotable resize(float xScale, float yScale) {
        Arrays.stream(points)
                .map(point ->  point = new Point(Math.round(point.X * xScale), Math.round(point.Y * yScale)))
                .collect(Collectors.toList()).toArray(points);
        return this;
    }
}
