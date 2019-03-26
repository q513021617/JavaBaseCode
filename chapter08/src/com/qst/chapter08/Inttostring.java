package com.qst.chapter08;

public class Inttostring {

	public Inttostring() {
		// TODO Auto-generated constructor stub
	}
	
	public static int[] StringtoInt(char[] strarry) {
		
		int [] intarr=new int[10];
		int j=0;
		for(int i=0;i<strarry.length;i++) {
			
			System.out.print(strarry[i]+" ");
			//&& strarry[i]<10
	
		}
		System.out.println("");
		return intarr;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a= {'1','2','4','6','7','5','8'};
		int[] re=StringtoInt(a);
		for (int i = 0; i < re.length; i++) {
			System.out.print(re[i]);
		}
		
	}

}
