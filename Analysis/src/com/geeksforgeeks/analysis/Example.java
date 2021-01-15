package com.geeksforgeeks.analysis;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1234;
		System.out.println(countDigits(n));
		System.out.println(recursiveCountDigits(n));
		System.out.println(checkPalindrome(123213));
		//System.out.println(recursionReverse(1234));
		System.out.println(factorial(10));
		System.out.println(recursiveFactorial(10));
		System.out.println(trailingZeroesForFactortial(100));
		System.out.println(calculateGcd(203234, 16524234));
		System.out.println(checkPrime(31));
	}
	
	public static int countDigits(int n) {
		int count = 0;
		while(n!=0) {
			n = n/10;
			count++;
		}
		return count;
	}
	public static int recursiveCountDigits(int n) {
		if (n<10) {
			return 1;
		}else {
			n = n/10;
			return 1+recursiveCountDigits(n);
		}
	}
	public static boolean checkPalindrome(int n) {
		if(countDigits(n)==1) {
			return true;
		}else {
			int nr = reverse(n);
			if(nr==n) {
				return true;
			}
			return false;
		}
	}
	public static int reverse(int n) {
		int sum = 0;
		while(n!=0) {
			int rem = n%10;
			n = n/10;
			sum = sum*10+rem;
		}
		return sum;
	}
	static int num = 1;
	static int base = 1;
//	public static int recursiveReverse(int n) {
//		if(n<0) {
//			return 0;
//		}else {
//			int lst = recursiveReverse(n/10);
//			base = base*10;
//			int rem = n%10;
//			num = num +rem*base;
//			return num;
//		}
//	}
	public static long factorial(int n) {
		long result = 1;
		for(int i = 2;i<=n;i++) {
			result = result*i;
		}
		return result;
	}
	public static int recursiveFactorial(int n) {
		if(n==0||n==1) {
			return 1;
		}else {
			return n*recursiveFactorial(n-1);
		}
	}
	public static int trailingZeroesForFactortial(int n) {
		if(n<5) {
			return 0;
		}else {
			return n/5+trailingZeroesForFactortial(n/5);
		}
	}
	public static int calculateGcd(int a,int b) {
		if(a>b) {
			return gcd(a, b);
		}else {
			return gcd(b,a);
		}
	}
	private static int gcd(int a,int b) {
		if(a%b==0) {
			return b;
		}
		int rem = a%b;
		if(b%rem==0) {
			return rem;
		}else {
			if(rem>b) {
				return gcd(rem,b);
			}else {
				return gcd(b,rem);
			}
		}
	}
	public static int lcm(int a,int b) {
		return a*b/(calculateGcd(a, b));
	}
	
//5 7 11 13 17 19 23 25 29 31 35 37 41 43 47 49 53 55 59 61 65 67 71 73 77 79 83 85 89 91 95 97
//	for(int i=2;i<=100;i++) {
//		if(i==2||i==3) {
//			continue;
//		}
//		if(i%2==0||i%3==0) {
//			continue;
//		}
//		System.out.print(i+" ");
//	}
	public static boolean checkPrime(int a) {
		if(a==1) {
			return false;
		}
		if(a==2||a==3) {
			return true;
		}
		if(a%2==0||a%3==0) {
			return false;
		}
		for (int i = 5;i*i<a;i=i+6) {
			if(a%i==0||a%(i+2)==0) {
				return false;
			}
		}
		return true;
	}
}
