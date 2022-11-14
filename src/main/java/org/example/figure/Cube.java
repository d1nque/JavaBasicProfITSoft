package org.example.figure;

public class Cube extends Figure3D {
    public Cube(double edge) {
        this.edge = edge;
    }

    double edge;

    @Override
    public double getVolume() {
        return edge * edge * edge;
    }
}
