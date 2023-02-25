package fun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindMax {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> token = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            token.add(scanner.nextInt());
            scanner.nextLine();
        }

        Integer max = Collections.max(token);
        int index = token.indexOf(max) + 1;

        System.out.println(max);
        System.out.println(index);

    }

}
