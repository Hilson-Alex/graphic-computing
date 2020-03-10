package com.project.software.documents;

import com.project.software.documents.draw.components.Line;
import com.project.software.documents.draw.Point;
import com.project.software.documents.draw.ViewMatrix;

public class Main {

    public static void main(String[] args) {
        ViewMatrix vm = new ViewMatrix(90, 40);
        Line line = new Line(new Point(44, 19), new Point(64, 9));
        vm.plot(line);
        vm.print();
    }
}
