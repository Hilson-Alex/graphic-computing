package com.project.software.documents.draw.components;

import com.project.software.documents.draw.Point;

import java.util.LinkedList;
import java.util.List;

public class Line implements Plotable {

    private Point[] points = new Point[2];

    public Line (Point pointA, Point pointB){
        points[0] = pointA;
        points[1] = pointB;
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

    /*public List<Point> getPoints(){
        int initialX, initialY, err, deltaX, deltaY;
        LinkedList<Point> pointsList = new LinkedList<>();
        err = 0;
        initialX = points[0].X;
        initialY = points[0].Y;
        deltaX = points[1].X - points[0].X;
        deltaY = points[1].Y - points[0].Y;

        pointsList.add(points[0]);
        pointsList.add(points[1]);

        // Verifica se o segundo ponto é mais distante
        if(deltaX >= 0){

            //Delta X maior intervalo
            if(Math.abs(deltaX) >= Math.abs(deltaY)){
                for(int i = 1; i < Math.abs(deltaX); i++){
                    if( err <= deltaX/(deltaY+1)){
                        initialX++;
                        pointsList.add(new Point(initialX,initialY));
                        err += deltaY;
                    }else{
                        initialX++;
                        initialY++;
                        pointsList.add(new Point(initialX,initialY));
                        err += deltaY - deltaX;
                    }
                }

            //Delta Y maior intervalo
            }else{
                for(int i=1;i<Math.abs(deltaY);i++){
                    if(err < deltaY/(deltaX+1)){
                        initialY++;
                        pointsList.add(new Point(initialX,initialY));
                        err += deltaX;
                    }else{
                        initialX++;
                        initialY++;
                        pointsList.add(new Point(initialX,initialY));
                        err += deltaX - deltaY;
                    }
                }
            }
        }else if (deltaX == Math.abs(deltaY)){
            for(int i=1;i<Math.abs(deltaX);i++){
                if(err<0){
                    initialX--;
                    pointsList.add(new Point(initialX,initialY));
                    err += deltaY;
                }else{
                    initialX--;
                    initialY++;
                    pointsList.add(new Point(initialX,initialY));
                    err += deltaY + deltaX;
                }
            }
        }else{
            for(int i=1;i<Math.abs(deltaY);i++){
                if(err<0){
                    initialX--;
                    initialY++;
                    pointsList.add(new Point(initialX,initialY));
                    err += deltaY + deltaX;
                }else{
                    initialY++;
                    pointsList.add(new Point(initialX,initialY));
                    err += deltaX;
                }
            }
        }
        return pointsList;
    }*/
}

