package fun;

import java.util.Arrays;
import java.util.Scanner;

public class ManipulateGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextInt();
        }
        int max = Arrays.stream(grades).max().getAsInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (grades[i] / (double)max) * 100;
        }
        System.out.println(sum/n);
    }
}
