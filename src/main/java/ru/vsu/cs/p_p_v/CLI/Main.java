package ru.vsu.cs.p_p_v.CLI;

import ru.vsu.cs.p_p_v.ArithmeticProgression;
import ru.vsu.cs.p_p_v.ListFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {

/*    18. (*) Необходимо, заменив минимальное кол-во чисел в списке, сделать его
    арифметической прогрессией, например:
    { 1, 16, 4, 10, 7, 11, 1, -2 } → { 19, 16, 13, 10, 7, 4, 1, -2 } (заменены 3 элемента)
    Реализовать в виде функции:
    public static void process(List<Integer> list)
    В случае нескольких подходящих вариантов замены минимального кол-ва элементов
    можно использовать любой.

    Подсказка: необходимо для каждой пары элементов списка посчитать, сколько
    элементов списка придется изменить, не меняя выбранную пару элементов, чтобы
    список стал арифметической прогрессией (очевидно, что в целых числах некоторые пары
    элементов сразу же не будут подходить для построения арифметической прогрессии;
    например, для приведенного примера в качестве опорной пары не подходят числа 4 и 7,
    т.к. между ними не может быть дробного числа 5,5).*/

    static class InputArgs {
        public String inputFilePath = null;
        public String outputFilePath = null;
    }

    public static void main(String[] args) {
        try {
            InputArgs processedArgs = parseCmdArgs(args);

            List<Integer> inputList = ListFile.listRead(processedArgs.inputFilePath);

            ArithmeticProgression.makeProgression(inputList);

            ListFile.listWrite(processedArgs.outputFilePath, inputList);
            System.out.printf("The result is saved in the file %s", processedArgs.outputFilePath);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static InputArgs parseCmdArgs(String[] args) throws Exception {
        if (args.length != 4)
            throw new Exception("Invalid number of arguments");

        InputArgs myInputArgs = new InputArgs();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i", "--input-file" -> myInputArgs.inputFilePath = args[++i];
                case "-o", "--output-file" -> myInputArgs.outputFilePath = args[++i];
            }
        }

        if (myInputArgs.outputFilePath == null)
            throw new Exception("Invalid output file");

        if (myInputArgs.inputFilePath == null)
            throw new Exception("Invalid input file");

        File inputFile = new File(myInputArgs.inputFilePath);
        if (!inputFile.isFile() || !inputFile.exists())
            throw new Exception("Invalid input file");

        return myInputArgs;
    }
}
