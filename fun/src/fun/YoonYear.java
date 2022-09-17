//package fun;
//
//import java.util.Scanner;
//
//class YoonYear {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);        
//        
//        int a = scan.nextInt();
//        
//        if( a> 1 && a<=4000) {
//        	boolean four = (a % 4 ==0);
//        	boolean hundred = (a % 100 != 0);
//        	boolean fourhundred = (a % 400 == 0);
//        	
//        	int re ;
//        	
//        	if( (four && hundred) || (four && fourhundred) ) {
//        		re = 1;
//        	} else {
//        		re = 0;
//        	}
//        	
//        	System.out.println(re);
//        	
//        }
//        
//    }
//}
