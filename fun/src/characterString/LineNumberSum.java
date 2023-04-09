package characterString;

import java.util.Scanner;

public class LineNumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(String.valueOf(line.charAt(i)));
        }
        System.out.println(sum);
    }
}
