package com.geeksforgeeks.analysis;

public class Test123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 123234322;
		String s = "";
		int index = 0;
		while(N!=0) {
			if(index%2==0)
				System.out.println(N%10);
			//s = s+(N%10);
			N = N/10;
			index++;
		}
		System.out.println(s);
	}

}
