package ru.vsu.cs.p_p_v;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListFile {
    public static List<Integer> listRead(String path) throws FileNotFoundException {
        List<Integer> nums = new ArrayList<>();

        Scanner fileScan = new Scanner(new File(path));

        Scanner lineScan = new Scanner(fileScan.nextLine());
        while (lineScan.hasNextInt())
            nums.add(lineScan.nextInt());

        return nums;
    }

    public static void listWrite(String path, List<Integer> input) throws IOException {
        FileWriter writer = new FileWriter(path);
        for (int i = 0; i < input.size(); i++)
                writer.append(String.valueOf(input.get(i))).append(i != input.size() - 1 ? " " : "");

        writer.close();
    }
}
