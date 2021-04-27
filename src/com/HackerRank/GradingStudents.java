package com.HackerRank;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List result = new ArrayList();
        for (Integer grade : grades){
            result.add(grade < 38 || grade % 5 < 3 ? grade : grade + (5 - (grade % 5)));
        }
        return result;
    }
    public static void main(String[] args)  {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));*/
        System.out.println("Test:"+Math.round(210%50));
        List grades = new ArrayList();
        grades.add(33);
        grades.add(88);
        grades.add(41);
        grades.add(67);
        List<Integer> result = GradingStudents.gradingStudents(grades);
        result.stream().forEach(System.out::println);
    }
}
