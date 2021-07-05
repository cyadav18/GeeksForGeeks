package com.geeksforgeeks.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ContestEnt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sarray = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			if (n == 1) {
				System.out.println();
				continue;
			}
			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sarray.nextInt();
			}
			findMissingAndRepeted(arr);
		}
		sc.close();

	}

	private static void findMissingAndRepeted(int[] arr) {
		int sum = arr[0];
		int prev = arr[0];
		Arrays.sort(arr);
		int repeted = -1;
		for (int i = 1; i < arr.length; i++) {
			if (prev == arr[i]) {
				repeted = arr[i];
			}
			sum = sum + arr[i];
			prev = arr[i];
		}
		int total_sum = arr.length * (arr.length + 1) / 2;
		int missing = total_sum - sum;
		missing = repeted + missing;
		System.out.println(repeted + " " + missing);

	}

}
