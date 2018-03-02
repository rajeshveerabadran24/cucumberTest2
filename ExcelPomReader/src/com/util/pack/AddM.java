package com.util.pack;

public class AddM {
	public int[] add(int a, int b, int n) {
	int[] c=new int [n];
	for (int i = 0; i < c.length; i++) {
		c[i]=a+b;
		
	}
			
		
		return c;
		
		}
		
public static void main(String[] args) {
	AddM ad=new AddM();
	ad.add(2, 3, 8);
	System.out.println(ad.add(2, 3, 8));
}
}
