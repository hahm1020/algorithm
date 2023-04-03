package fun;

import java.util.*;

public class NotSubmitWork {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> numbers = new HashSet<Integer>();
        for (int i = 1; i <= 30; i++) {
            numbers.add(i);
        }

        int inputs[] = new int[28];
        for (int i = 0; i < 28; i++) {
            inputs[i] = sc.nextInt(); // 숫자를 입력받아 배열에 저장합니다.
        }

        sc.close();

        for (int input : inputs) {
            if (numbers.contains(input)) {
                numbers.remove(input);
            }
        }

        for (int ret : numbers) {
            System.out.println(ret);
        }
    }
}
