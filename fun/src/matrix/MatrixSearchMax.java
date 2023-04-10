package matrix;

import java.util.Scanner;

public class MatrixSearchMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[9][9];
        String maxPosition = "";
        int max = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] >= max) {
                    max = a[i][j];
                    maxPosition = (i+1) + " " + (j+1);
                }
            }
        }
        System.out.println(max);
        System.out.println(maxPosition);
    }
}
