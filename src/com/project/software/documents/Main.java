package com.project.software.documents;

import com.project.software.documents.draw.solid.Euler;
import com.project.software.documents.draw.solid.Point3D;

public class Main {

    public static void main(String[] args) {
        //euler();
    }

    private static void euler (){
        double angle  = 90;
        Point3D point;
        Integer[][] rotations = {
                {0, 0,  0},
                {7, 0,  0},
                {7, 10, 2}
        };

        for (Integer[] coords : rotations){
            point = new Point3D(coords[0], coords[1], coords[2]);
            System.out.println("Para as coordenadas:");
            System.out.println(point);
            System.out.println("E ângulo de " + angle + " graus \n");
            System.out.println("Rotação em x: " + Euler.rotateByX(point, angle));
            System.out.println("Rotação em y: " + Euler.rotateByY(point, angle));
            System.out.println("Rotação em z: " + Euler.rotateByZ(point, angle));
            System.out.println();
        }
    }
}