package com.geeksforgeeks.analysis;

import java.util.ArrayList;

public class Mathematics{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
//		System.out.println(countDigits(n));
//		System.out.println(recursiveCountDigits(n));
//		System.out.println(checkPalindrome(123213));
////		System.out.println(recursionReverse(1234));
		System.out.println(factorial(n));
//		System.out.println(recursiveFactorial(10));
//		System.out.println(trailingZeroesForFactortial(100));
//		System.out.println(calculateGcd(203234, 16524234));
//		System.out.println(checkPrime(31));
//		printPrimeFactors(84);
//		printDivisors(15);
//		printSortedDivisor(15);
//		primeNumbersUpTo(25);sieveUpto(25);
//		System.out.println();
//		System.out.println(powRecursive(2,9));
//		System.out.println(powIterative(2,9));
//		System.out.println(cToF(48));
//		System.out.println(quadraticRoots(752,904,164));
//		System.out.println(isPlaindrome("abba"));
	}
	public static int isPlaindrome(String S) {
		int j = S.length()-1;
        for(int i = 0;i<S.length()/2;i++,j--) {
        	if(S.charAt(i)!=S.charAt(j)) 
        		return 0;
        }
        return 1;
    }
	 public static ArrayList<Integer> quadraticRoots(int a, int b, int c){
		 double d = b*b-4*a*c;
		 ArrayList<Integer> al = new ArrayList<Integer>();
		 if(d<0) {
			 al.add(-1);
			 return al;
		 }
		 if(d==0) {
			 al.add(-b/(2*a));
			 al.add(-b/(2*a));
			 return al;
		 }
		 int r1 = (int) Math.floor((-b+Math.sqrt(d))/(2*a)) ;
		 int r2 = (int) Math.floor((-b-Math.sqrt(d))/(2*a)) ;
		 if(r1>r2) {
			 al.add(r1);
			 al.add(r2);
		 }else {
			 al.add(r2);
			 al.add(r1);
		 }
		 return al;
	 }
	 public static double cToF(int C)
	    {
	        return C*9/5+32;
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
//	static int num = 1;
//	static int base = 1;
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
	public static double factorial(int n) {
		double result = 1;
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
	
//5 7 11 13 17 19 23 25 29 31 35 37 41 43 47 49 53 55 59 61 65 67 71 73 77 79 83 85 89 91 95 97 101
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
		for (int i = 5;i*i<=a;i=i+6) {
			if(a%i==0||a%(i+2)==0) {
				return false;
			}
		}
		return true;
	}
	//5 7 11 13 17 19 23 25 29 31 35 37 41 43 47 49 53 55 59 61 65 67 71 73 77 79 83 85 89 91 95 97 101
	public static void printPrimeFactors(int n) {
		if (checkPrime(n)) {
			System.out.println(n);
		}else {
			while(n%2==0||n%3==0) {
				if(n%2==0) {
					System.out.print(2+" ");
					n=n/2;
					continue;
				}
				if(n%3==0) {
					System.out.print(3+" ");
					n=n/3;
				}
			}
			for(int i = 5;i*i<=n;i=i+6) {
				while(n%i==0||n%(i+2)==0) {
					if(n%i==0) {
						n = n/i;
						System.out.print(i+" ");
						continue;
					}
					if(n%(i+2)==0) {
						n = n/(i+2);
						System.out.print((i+2)+" ");
					}
				}
			}
			if(n>3) {
				System.out.println(n);
			}
		}
	}
	
	public static void printDivisors(int n) {
		int i;
		for(i = 1;i*i<n;i++) {
			if(n%i==0) {
				System.out.print(i+" ");
			}
		}
		for(;i>=1;i--) {
			if(n%i==0) {
				System.out.print((n/i)+" ");
			}
		}
		System.out.println();
	}	
	static int mult = 1;
	public static void printSortedDivisor(int n) {
		mult = 1;
		recursivePrintDivisors(n);
		System.out.println();
	}
	
	private static void recursivePrintDivisors(int n) {
		if(mult*mult>n) {
			return;
		}else {
			int temp = 0;
			if(n%mult==0) {
				System.out.print(mult+" ");
				temp = n/mult;
			}
			if(temp==mult) {
				temp = 0;
			}
			mult++;
			recursivePrintDivisors(n);
			if(temp!=0)
				System.out.print(temp+" ");
		}
	}
	public static void primeNumbersUpTo(int n) {
		if(n<1) {
			return;
		}
		if(n>2) {
			System.out.print(2+" "+3+" ");
		}
		for(int i = 5;i<=n;i=i+6) {
			if(checkPrime(i)) {
				System.out.print(i+" ");
			}
			if(checkPrime(i+2)) {
				System.out.print((i+2)+" ");
			}
		}
		System.out.println();
	}
	public static void sieveUpto(int n) {
		boolean [] arr = new boolean[n+1];
		for(int i =2;i<arr.length;i++) {
			arr[i] = true;
		}
		for(int i = 2;i<=n;i++) {
			if(arr[i]) {
				System.out.print(i+" ");
				for(int j = i*i;j<arr.length;j=j+i) {
					arr[j] = false;
				}
			}
		}
	}
	public static int powRecursive(int base,int pow) {
		if(pow==0)
			return 1;
		if(pow==1)
			return base;
		else {
			return powRecursive(base,pow/2)*powRecursive(base,(pow-(pow/2)));
		}
	}
	public static int powIterative(int base,int pow) {
		int result = 1;
		int b1 = pow;
		int base_mul = base;
		while(b1!=0) {
			if(b1%2!=0) {
				result = result*base_mul;
			}
			b1 = b1/2;
			base_mul = base_mul*base_mul;
		}
		return result;
	}
}
