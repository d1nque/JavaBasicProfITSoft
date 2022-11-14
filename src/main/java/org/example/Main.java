package org.example;
import org.example.figure.*;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BasicJava bj = new BasicJava();
        //System.out.println(bj.onlyPositiveNumbers(bj.getRandomIntegerArrayList(10)).toString());
        ArrayList<String> someStrings = new ArrayList<>();
        someStrings.add("#abara asd aa f g gg a #arrr #abara");
        someStrings.add("#aara as#d aa #rr g gg a #arrr #abara");
        someStrings.add("#abara as#d aa f g #gg a #rr #bara");
        someStrings.add("#Abara as#d aa f g gg a #rr #bara");
        someStrings.add("#abara asd aa f g #gg a #rr #bara");
        System.out.println(bj.getTopFiveHashtags(someStrings).toString());

        ArrayList<Figure3D> figures = new ArrayList<>();
        figures.add(new Cube(14));
        figures.add(new Cylinder(14, 2));
        figures.add(new Orb(10));
        figures.add(new Orb(12));
        figures.add(new Orb(11));
        bj.getSort3DFigures(figures).forEach((e) -> {
            System.out.println(e.getClass() + " " + e.getVolume());
        });
    }
}

