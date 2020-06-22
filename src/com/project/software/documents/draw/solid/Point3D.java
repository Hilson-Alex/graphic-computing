package com.project.software.documents.draw.solid;

import com.project.software.documents.draw.plane.Point;

public class Point3D {

    public final int X;

    public final int Y;

    public final int Z;

    public Point3D(int x, int y, int z){
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    public Point3D(Point point, int zCoordinate){
        X = point.X;
        Y = point.Y;
        Z = zCoordinate;
    }

    @Override
    public String toString() {
        return "{x = " + X + ", y = " + Y + ", z = " + Z + '}';
    }
}
