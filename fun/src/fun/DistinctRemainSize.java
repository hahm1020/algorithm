package fun;

import java.util.HashSet;
import java.util.Scanner;

public class DistinctRemainSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> remainderSet = new HashSet<>(); // 서로 다른 나머지를 저장할 집합(set)

        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            int remainder = num % 42;
            remainderSet.add(remainder);
        }

        System.out.println(remainderSet.size()); // 집합의 크기 출력
    }
}
