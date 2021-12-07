package ru.vsu.cs.p_p_v;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticProgressionTest {

    @Test
    void makeProgression() {
        List<Integer> input;
        List<Integer> correct;

        input = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 2, 2, 2, 5));
        correct = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2));
        ArithmeticProgression.makeProgression(input);
        assertEquals(correct, input);

        input = new ArrayList<>(Arrays.asList(1, 345, 543, 7, 2424, 11, 6546, 15));
        correct = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));
        ArithmeticProgression.makeProgression(input);
        assertEquals(correct, input);

        input = new ArrayList<>(Arrays.asList(1, 16, 4, 10, 7, 11, 1, -2));
        correct = new ArrayList<>(Arrays.asList(19, 16, 13, 10, 7, 4, 1, -2));
        ArithmeticProgression.makeProgression(input);
        assertEquals(correct, input);

        input = new ArrayList<>(Arrays.asList(-1, -2, -3, -4, -5));
        correct = new ArrayList<>(Arrays.asList(-1, -2, -3, -4, -5));
        ArithmeticProgression.makeProgression(input);
        assertEquals(correct, input);

        input = new ArrayList<>(Arrays.asList(1, 2, 3, 999, 998));
        correct = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArithmeticProgression.makeProgression(input);
        assertEquals(correct, input);

        input = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 4, 5));
        correct = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        ArithmeticProgression.makeProgression(input);
        assertEquals(correct, input);

        input = new ArrayList<>(Arrays.asList(-998, 0, 0, -995, -994));
        correct = new ArrayList<>(Arrays.asList(-998, -997, -996, -995, -994));
        ArithmeticProgression.makeProgression(input);
        assertEquals(correct, input);

        input = new ArrayList<>(Arrays.asList(998, 0, 0, 995, 994));
        correct = new ArrayList<>(Arrays.asList(998, 997, 996, 995, 994));
        ArithmeticProgression.makeProgression(input);
        assertEquals(correct, input);
    }
}