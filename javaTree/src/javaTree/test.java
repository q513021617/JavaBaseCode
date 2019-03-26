package javaTree;
import java.lang.Math;
import java.math.MathContext;

public class test {

	public static int test01(int n) {
		int count=0;
		while(n>1) {
			count++;
			if(n%2!=0) n=3*n+1;
			else {
				n=n/2;
			}
		}
		return count;
	}

	public static int logdengyu(double n,int c1,int c2) {
		
		Math.log(n);
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			for(int n=2;n<100;n++) {
				for (int c = 0; c < 100; c++) {
				
						
						if(c*(Math.log(c)/Math.log(2)+5)==(Math.log(n*n)/Math.log(2)))
							{
								System.out.println("c "+String.valueOf(c)+"n "+String.valueOf(n));
							}
						
					
				}
				
			}
		
//		Math.log(4)/Math.log(2)  µÈÓÚ2
		System.out.println();
		
	}

}
