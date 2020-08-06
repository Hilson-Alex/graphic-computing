package com.project.software.documents.demos;

import com.project.software.documents.draw.plane.Point;
import com.project.software.documents.draw.plane.ViewMatrix;
import com.project.software.documents.draw.plane.components.Line;
import com.project.software.documents.draw.plane.components.geometry.Triangle;
import com.project.software.documents.draw.solid.Euler;
import com.project.software.documents.draw.solid.Point3D;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public enum Demos implements Demo {

    LINE {
        @Override
        public void exec() {
            view.clean();
            Point pointA = new Point(45, 2);
            Point pointB = new Point(90, 2);
            Line line = new Line(pointA, pointB);
            printName();
            for (int i = 0; i < 5; i++){
                System.out.println("\n Linha: " + (i*22.5) + 'º');
                view.plot(line).print().clean();
                line.rotate(22.5);
                Demos.getToken();
            }
        }
    },

    SCALE {
        @Override
        public void exec() {
            view.clean();
            double[] values = {1, 0.5, 2};
            Point pointA = new Point(4, 4);
            Point pointB = new Point(20, 20);
            Point pointC = new Point(36, 4);
            Triangle triangle = new Triangle(pointA, pointB, pointC);
            printName();
            for (double value : values) {
                System.out.println("Escala de '" + value + "':");
                view.plot(triangle.resize(value)).print().clean();
                Demos.getToken();
            }

        }
    },

    ROTATE {
        @Override
        public void exec() {
            view.clean();
            Point pointA = new Point(24, 14);
            Point pointB = new Point(40, 30);
            Point pointC = new Point(56, 14);
            Triangle triangle = new Triangle(pointA, pointB, pointC);
            printName();
            for (int i = 0; i < 9; i ++){
                System.out.println("Rotação de " + i*45 + 'º');
                view.plot(triangle.rotate(i*45)).print().clean();
                Demos.getToken();
            }
        }
    },

    TRANSLATE {
        @Override
        public void exec() {
            view.clean();
            Point pointA = new Point(4, 10);
            Point pointB = new Point(20, 36);
            Point pointC = new Point(36, 10);
            Triangle triangle = new Triangle(pointA, pointB, pointC);
            for (int i = 0; i < 5; i++){
                view.plot(triangle.translateX(i*13)).print().clean();
                Demos.getToken();
            }
        }
    },

    EULER {
        @Override
        public void exec() {
            double angle  = 90;
            Point3D point;
            Integer[][] rotations = {
                    {0, 0,  0},
                    {7, 0,  0},
                    {7, 10, 2}
            };
            printName();
            for (Integer[] coords : rotations){
                point = new Point3D(coords[0], coords[1], coords[2]);
                System.out.println("Para as coordenadas:");
                System.out.println(point);
                System.out.println("E ângulo de " + angle + " graus \n");
                System.out.println("Rotação em x: " + Euler.rotateByX(point, angle));
                System.out.println("Rotação em y: " + Euler.rotateByY(point, angle));
                System.out.println("Rotação em z: " + Euler.rotateByZ(point, angle));
                System.out.println();
                Demos.getToken();
            }
        }
    },

    EXIT {
        @Override
        public void exec() {
            System.out.println("Obrigado!!!");
        }
    },

    HELP {
        @Override
        public void exec() {
            printName();
            Arrays.stream(Demos.values()).forEach(System.out::println);
        }
    };

    private static ViewMatrix view = new ViewMatrix(92, 40);

    private static void getToken(){
        try {
            System.out.print("(press enter)");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void printName() {
        System.out.println("\n======= " + this.name() + " =======");
        getToken();
    }


}
