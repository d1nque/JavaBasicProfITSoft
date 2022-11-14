package org.example;
import org.example.figure.Cube;
import org.example.figure.Cylinder;
import org.example.figure.Figure3D;
import org.example.figure.Orb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BasicJavaTest {
    BasicJava bj = new BasicJava();
    @Test
    void onlyPositiveNumbers() {
        ArrayList<Integer> integerArrayListActual = bj.onlyPositiveNumbers(new ArrayList<>(Arrays.asList(1, 3, -4, 5, -13, 0, 21, -1)));
        ArrayList<Integer> integerArrayListExpected = new ArrayList<>(Arrays.asList(21, 5, 3, 1, 0));

        assertEquals(integerArrayListExpected, integerArrayListActual);
    }

    @Test
    void onlyPositiveNumbers_nulls() {
        try {
            ArrayList<Integer> integerArrayListActual = bj.onlyPositiveNumbers(null);
            fail("Null accepted");
        } catch (NullPointerException e){
            assertEquals("Array cant be null", e.getMessage());
        }

    }


    @Test
    void onlyPositiveNumbers_empty() {
        ArrayList<Integer> integerArrayListActual = bj.onlyPositiveNumbers(new ArrayList<>());
        ArrayList<Integer> integerArrayListExpected = new ArrayList<>();

        assertEquals(integerArrayListExpected, integerArrayListActual);
    }

    @Test
    void onlyPositiveNumbers_onlyNegative() {
        ArrayList<Integer> integerArrayListActual = bj.onlyPositiveNumbers(new ArrayList<>(Arrays.asList(-1, -3, -4, -5, -13, -21, -1)));
        ArrayList<Integer> integerArrayListExpected = new ArrayList<>();

        assertEquals(integerArrayListExpected, integerArrayListActual);
    }


    @Test
    void getTopFiveHashtags() {
        ArrayList<String> someStrings = new ArrayList<>();
        someStrings.add("#abara asd aa f g gg a #arrr #abara");
        someStrings.add("#aara as#d aa #rr g gg a #arrr #abara");
        someStrings.add("#abara as#d aa f g #gg a #rr #bara");
        someStrings.add("#Abara as#d aa f g gg a #rr #bara");
        someStrings.add("#abara asd aa f g #gg a #rr #bara");
        Map<String, Integer> actualMap = bj.getTopFiveHashtags(someStrings);
        Map<String, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put("#abara", 5);
        expectedMap.put("#rr", 4);
        expectedMap.put("#bara", 3);
        expectedMap.put("#gg", 2);
        expectedMap.put("#arrr", 2);


        assertEquals(expectedMap, actualMap);
    }

    @Test
    void getTopFiveHashtags_nulls() {
        try{
            bj.getTopFiveHashtags(null);
            fail("Null accepted");
        } catch(NullPointerException e){
            assertEquals("Can`t be null", e.getMessage());
        }
    }

    @Test
    void getTopFiveHashtags_empty() {

        assertEquals(new LinkedHashMap<>(), bj.getTopFiveHashtags(new ArrayList<>()));

    }

    @Test
    void getTopFiveHashtags_oneString() {
        ArrayList<String> someStrings = new ArrayList<>();
        someStrings.add("#abara asd aa f g gg a #arrr #abara");
        Map<String, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put("#abara", 1);
        expectedMap.put("#arrr", 1);
        assertEquals(expectedMap, bj.getTopFiveHashtags(someStrings));

    }

    @Test
    void getSort3DFigures() {
        ArrayList<Figure3D> actualFigures = new ArrayList<>();
        actualFigures.add(new Cube(14));
        actualFigures.add(new Cylinder(14, 2));
        actualFigures.add(new Orb(10));
        actualFigures.add(new Orb(12));
        actualFigures.add(new Orb(11));


        ArrayList<Figure3D> exceptedFigures = new ArrayList<>();
        exceptedFigures.add(new Orb(12));
        exceptedFigures.add(new Orb(11));
        exceptedFigures.add(new Orb(10));
        exceptedFigures.add(new Cube(14));
        exceptedFigures.add(new Cylinder(14, 2));
        exceptedFigures.add(new Cube(14));


        assertEquals(exceptedFigures.get(0).getVolume(), bj.getSort3DFigures(actualFigures).get(0).getVolume());

    }

    @Test
    void getSort3DFigures_nulls() {
        try{
            bj.getSort3DFigures(null);
        } catch(NullPointerException e){
            assertEquals("Cant be null", e.getMessage());
        }
    }

    @Test
    void getSort3DFigures_empty() {
        ArrayList<Figure3D> exceptedFigures = new ArrayList<>();
        assertEquals(exceptedFigures, bj.getSort3DFigures(exceptedFigures));

    }
}