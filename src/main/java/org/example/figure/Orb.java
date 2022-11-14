package org.example.figure;

public class Orb extends Figure3D {
    public Orb(double radius) {
        this.radius = radius;
    }

    double radius;

    @Override
    public double getVolume() {
        return (4 * 3.14 * Math.pow(radius, 3)) / 3;
    }
}
