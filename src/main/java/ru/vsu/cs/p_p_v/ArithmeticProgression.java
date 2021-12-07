package ru.vsu.cs.p_p_v;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticProgression {

    public static void makeProgression(List<Integer> list) {
        int minMoves = Integer.MAX_VALUE;
        List<Integer> minList = new ArrayList<>();

        for (int firstIndex = 0; firstIndex < list.size() - 1; firstIndex++) {
            for (int secondIndex = 0; secondIndex < list.size(); secondIndex++) {
                if (secondIndex == firstIndex)
                    continue;

                List<Integer> tempList = new ArrayList<>(list);
                int moves = 0;

                int diff = list.get(secondIndex) - list.get(firstIndex);
                if (diff % (secondIndex - firstIndex) != 0)
                    continue;
                diff /= secondIndex - firstIndex;

                for (int i = 0; i < list.size(); i++) {
                    int correctValue = list.get(secondIndex) + (i - secondIndex) * diff;
                    if (list.get(i) != correctValue) {
                        moves++;
                        tempList.set(i, correctValue);
                    }
                }

                if (moves < minMoves) {
                    minMoves = moves;
                    minList = tempList;
                }
            }
        }

        list.clear();
        list.addAll(minList);
    }
}
