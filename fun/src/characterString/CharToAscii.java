package characterString;

import java.util.Scanner;

public class CharToAscii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.nextLine().charAt(0);
        int maskCode = c;
        System.out.println(maskCode);
    }
}
