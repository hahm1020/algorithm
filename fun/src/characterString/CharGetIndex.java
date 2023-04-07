package characterString;

import java.util.Scanner;

public class CharGetIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next().charAt(sc.nextInt()-1));
    }
}
