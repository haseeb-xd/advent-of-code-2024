package com.ansari.haseeb.problems_2024.Day2;

import com.ansari.haseeb.Utils.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {

        List<String> lines = StringUtil.readLinesFromFile("src/main/java/com/ansari/haseeb/problems_2024/Day2/input.txt");


         /*
        Day 2 Part 1
         */

        List<List<Integer>> levels = new ArrayList<>();

        for (String line : lines) {
            List<Integer> level =  Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .toList();

            levels.add(level);
        }
        
        int problem1Count = 0;

        for (List <Integer> level : levels) {
                if(isIncreasingOrDecreasing(level)) {
                    problem1Count++;
                }
        }

        System.out.println("Part 1 Answer: " + problem1Count);

    }

    private static boolean isIncreasingOrDecreasing(List<Integer> level) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < level.size() - 1; i++) {
            int diff = level.get(i + 1) - level.get(i);

            if ((diff != 1 && diff != 2 && diff != 3)) {
                isIncreasing = false;
            }


            if ((diff != -1 && diff != -2 && diff != -3)) {
                isDecreasing = false;
            }

            if (!isIncreasing && !isDecreasing) {
                return false;
            }
        }

        return true;
    }
}
