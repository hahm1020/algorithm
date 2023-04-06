package fun;

import java.util.Scanner;

public class ReverseOrderBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int k = 0; k < m; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            for (int x = i, y = j; x <= y; x++, y--) {
                int temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
