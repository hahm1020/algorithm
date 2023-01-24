package fun;

import java.util.Arrays;
import java.util.Scanner;

public class MinThanX {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] array = line.split(" ");

        int size = Integer.parseInt(array[0]);
        int item = Integer.parseInt(array[1]);

        String[] list = sc.nextLine().split(" ");

        String[] ret = Arrays.stream(list)
                .filter(idx -> Integer.parseInt(idx) < item)
                .toArray(String[]::new);


        for(String strValue : ret) {
            System.out.print(strValue + " ");
        }

    }

}
