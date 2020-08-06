package com.project.software.documents.draw.solid;

import com.project.software.documents.draw.plane.Point;

public class Point3D extends Point{

    public final int Z;

    public Point3D(int x, int y, int z){
        super(x, y);
        this.Z = z;
    }

    public Point3D(Point point, int zCoordinate){
        super(point.X, point.Y);
        Z = zCoordinate;
    }

    @Override
    public String toString() {
        return "{x = " + X + ", y = " + Y + ", z = " + Z + '}';
    }
}
