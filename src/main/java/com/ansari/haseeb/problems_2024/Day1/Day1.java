package com.ansari.haseeb.problems_2024.Day1;

import com.ansari.haseeb.Utils.StringUtil;

import java.io.IOException;
import java.util.*;

public class Day1 {

    public static void main(String[] args) throws IOException {

        List<String> lines = StringUtil.readLinesFromFile("src/main/java/com/ansari/haseeb/problems_2024/Day1/input.txt");

        /*
        Day 1 Part 1
         */

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();



        lines.forEach(line -> {
            String[] split = line.split("   ");
            leftList.add(Integer.parseInt(split[0]));
            rightList.add(Integer.parseInt(split[1]));
                }
        );

        if (leftList.size() != rightList.size()) {
            throw new RuntimeException("Lists are not same size");
        }

        Collections.sort(leftList);
        Collections.sort(rightList);



        int sum1=0;
        for (int i=0; i<leftList.size(); i++){

            sum1+=  Math.abs(leftList.get(i) - rightList.get(i));
        }

        System.out.println("Part 1 Answer:"+ sum1);


        /*
        Day 1 Part 2
         */

        int sum2=0;


        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : rightList) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : leftList) {
            int count = frequencyMap.getOrDefault(num, 0);
            sum2 += count * num;
        }

        System.out.println("Part 2 Answer:" + sum2);
    }
}
