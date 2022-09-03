package fun;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        
        int a = scan.nextInt();
        String re = "";
        
        switch (a/10) {
			case 10:
				re = "A";
				break;
			case 9:
				re = "A";
				break;
			case 8:
				re = "B";
				break;
			case 7:
				re = "C";
				break;
			case 6:
				re = "D";
				break;
	
			default:
				re = "F";
				break;
			}
        
        System.out.println(re);
        
    }
}
