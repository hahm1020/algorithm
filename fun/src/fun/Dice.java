package fun;

import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
//        1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.
//        같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
//        같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
//        모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
//        예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다.
//        또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다.
//        3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
//        3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.

        Scanner sc= new Scanner(System.in);

        String line = sc.nextLine();
        String[] param = line.split(" ");

        int a = Integer.parseInt(param[0]);
        int b = Integer.parseInt(param[1]);
        int c = Integer.parseInt(param[2]);

        boolean ab = (a == b);
        boolean bc = (b == c);
        boolean ca = (c == a);

        boolean abc = (ab && bc && ca);

        int result = 0;

        if( abc ) {
            result = 10000 + (a * 1000);
        } else if (ab || ca) {
            result = 1000 + (a * 100);
        } else if (bc) {
            result = 1000 + (b * 100);
        } else {
            int max = max(param);
            result = max * 100;
        }

        System.out.println(result);

    }

    public static int max(String[] data){

        int maxValue = Integer.parseInt(data[0]);

        for (int i = 0; i < data.length; i++){

            if (maxValue < Integer.parseInt(data[i])) {

                maxValue = Integer.parseInt(data[i]);
            }
        }
        return maxValue;
    }
}
