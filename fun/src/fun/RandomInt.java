package fun;

import java.util.Scanner;

public class RandomInt {
	 public static void main(String[] args) {
	      
      /* 1���� 100 ������ ������ �߻���Ű��
       * ������ �Է� �޾Ƽ� �Է¹��� ������ �߻��� �������� ū ��� "�Է��Ͻ� �������� Ů�ϴ�." ���,
       * �Է¹��� �������� ������ ���� ��� "�Է��Ͻ� �������� �۽��ϴ�." �� ����ϸ�
       * �Է��� ������ ������ ���� ������ ���� ���߱⸦ �ݺ��ϴ� ���α׷��� ���弼��.
       * 
       * ��, �Է��� ������ ������ ���� ���   "�����Դϴ�. 4ȸ ���� ������ ���߼̽��ϴ�." �ϰ� 
       * ������ �Է��� Ƚ���� �Բ� ��µǵ��� �ؾ� �մϴ�.
       * ó������ �ٷ� ������ ���ߴ� ���� 1ȸ���� ������ ���� ���Դϴ�.
       * 
       * ������ ���ߴ� ��� �� ������ ����ϰ� ���α׷��� ����ǵ��� �ۼ��ϸ� �˴ϴ�.
       * 
       * -- ���α׷� ���� --
       * ������ �Է��ϼ��� : 5
       * �Է��Ͻ� �������� �۽��ϴ�.
       * ������ �Է��ϼ��� : 3
       * �Է��Ͻ� �������� Ů�ϴ�.
       * ������ �Է��ϼ��� : 4
       * �����Դϴ�. 3ȸ���� ������ ���߼̽��ϴ�.
       * */
		 
		 int random  = (int)(Math.random() * 100) + 1;
		 int result = 0;
		 
		Scanner sc= new Scanner(System.in);
		
		boolean b = false;  
		
		do {
			System.out.print("������ �Է��ϼ���: ");
			int a = sc.nextInt();
			
			b = RandomInt.su(a, random);
			
			result++;
		} while ( b );
	      System.out.println("�����Դϴ�. " + result + "ȸ ���� ������ ���߼̽��ϴ�.");
	   }
	 
	   public static boolean su(int a,int random) {
	      
	      boolean returnVal = false;
	      
	      if(a>random) {
	    	  System.out.println("�Է��Ͻ� �������� Ů�ϴ�.");
	      } else if(a<random) {
	    	  System.out.println("�Է��Ͻ� �������� �۽��ϴ�.");
	      } else {
	    	  returnVal = true;
	      }
	      
	      return returnVal;
	   }

}
