package com.project.software.documents;

import com.project.software.documents.draw.plane.Point;
import com.project.software.documents.draw.plane.ViewMatrix;

public class Main {

    public static void main(String[] args) {
        ViewMatrix vm = new ViewMatrix(90, 40);
        Point pointA = new Point(35, 15);
//        Point pointB = new Point(55, 15);
//        Point pointC = new Point(55, 25);
//        Triangle triangle = new Triangle(pointA, pointB, pointC);
        for (int i = 0; i < 360; i ++){
            vm.plot(Point.rotateByOrigin(pointA, i));
        }
        vm.print();

    }
}
