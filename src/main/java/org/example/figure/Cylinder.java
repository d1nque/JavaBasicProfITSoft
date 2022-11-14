package org.example.figure;

public class Cylinder extends Figure3D {
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    double radius;
    double height;
    @Override
    public double getVolume() {
        return 3.14 * radius * radius * height;
    }
}
