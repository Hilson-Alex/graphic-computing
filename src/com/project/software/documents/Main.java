package com.project.software.documents;

import com.project.software.documents.draw.plain.Point;
import com.project.software.documents.draw.plain.ViewMatrix;
import com.project.software.documents.draw.plain.components.geometry.Triangle;

public class Main {

    public static void main(String[] args) {
        ViewMatrix vm = new ViewMatrix(90, 40);
        Point pointA = new Point(9, 2);
        Point pointB = new Point(81, 2);
        Point pointC = new Point(81, 38);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        vm.plot(triangle);
        vm.print();
        vm.clean();
        vm.plot(triangle.resize(0.5f));
        vm.print();
    }
}
