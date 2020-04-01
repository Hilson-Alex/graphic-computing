package com.project.software.documents.draw.solid;

public class Euler {

    private Euler(){}

    public static Point3D rotateByX(Point3D point, double angle){
        double y, z;
        angle = Math.toRadians(angle);
        y = point.Y * Math.cos(angle) - point.Z * Math.sin(angle);
        z = point.Y * Math.sin(angle) + point.Z * Math.cos(angle);
        return new Point3D(point.X, (int)Math.round(y), (int)Math.round(z));
    }

    public static Point3D rotateByY(Point3D point, double angle){
        double x, z;
        angle = Math.toRadians(angle);
        x = point.Z * Math.sin(angle) + point.X * Math.cos(angle);
        z = point.Z * Math.cos(angle) - point.X * Math.sin(angle);
        return new Point3D((int)Math.round(x), point.Y , (int)Math.round(z));
    }

    public static Point3D rotateByZ(Point3D point, double angle){
        double x, y;
        angle = Math.toRadians(angle);
        x = point.X * Math.cos(angle) - point.Y * Math.sin(angle);
        y = point.X * Math.sin(angle) + point.Y * Math.cos(angle);
        return new Point3D((int)Math.round(x), (int)Math.round(y), point.Z);
    }

}
