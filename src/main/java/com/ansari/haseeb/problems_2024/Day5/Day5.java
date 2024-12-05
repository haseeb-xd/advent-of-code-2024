package com.ansari.haseeb.problems_2024.Day5;

import com.ansari.haseeb.Utils.StringUtil;

import java.io.IOException;
import java.util.*;

public class Day5 {


    public static void main(String[] args) throws IOException {



        List<String> lines = StringUtil.readLinesFromFile("src/main/java/com/ansari/haseeb/problems_2024/Day5/input.txt");


        Map<Integer, ArrayList<Integer>> pageOrderMap = new HashMap<>();

        List<List<Integer>> pageNumbers = new ArrayList<>();


        for (String line : lines) {

            if (line.contains("|")){
                String[] split = line.split("\\|");
                int key = Integer.parseInt(split[0]);
                int value = Integer.parseInt(split[1]);

                pageOrderMap.putIfAbsent(key, new ArrayList<>());
                pageOrderMap.get(key).add(value);
            }
            else if(line.contains(",")){
                String[] split = line.split(",");
                List<Integer> list = new ArrayList<>();
                for (String s : split) {
                    list.add(Integer.parseInt(s));
                }
                pageNumbers.add(list);
            }
        }

        List<List<Integer>> safePages = new ArrayList<>();

        for (List<Integer> list : pageNumbers) {

            boolean isSafe = true;
            for (int i = 0; i < list.size() && isSafe; i++) {
                 for(int j=0; j<list.size(); j++){
                     if(i==j){
                         continue;
                     }
                     if(pageOrderMap.getOrDefault(list.get(i), new ArrayList<>()).contains(list.get(j))){
                        if (!(i<j)){
                            isSafe = false;
                            break;
                        }
                     }

                 }
            }

            if(isSafe){
                safePages.add(list);
            }
        }

        int sum=0;
        for (List<Integer> list : safePages) {

            sum+= list.get(list.size()/2);
        }

        System.out.println("Part 1 Answer:"+sum);


        List<List<Integer>> unsafePages = new ArrayList<>();

        for (List<Integer> list : pageNumbers) {

            boolean isSafe = true;
            for (int i = 0; i < list.size(); i++) {
                for(int j=0; j<list.size(); j++){
                    if(i==j){
                        continue;
                    }
                    if(pageOrderMap.getOrDefault(list.get(i), new ArrayList<>()).contains(list.get(j))){
                        if (!(i<j)){
                            Collections.swap(list, i, j);
                            j--;
                            isSafe = false;
                        }
                    }
                }
            }

            if(!isSafe){
                unsafePages.add(list);
            }
        }

        int sum2=0;
        for (List<Integer> list : unsafePages) {
            sum2+= list.get(list.size()/2);
        }

        System.out.println("Part 2 Answer:"+sum2);


    }
}
