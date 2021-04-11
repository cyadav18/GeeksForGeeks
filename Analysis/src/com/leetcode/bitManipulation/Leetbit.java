package com.leetcode.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Leetbit {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		List<List<Integer>> l = subsets(num);
		System.out.println(l);
		int[] arr = { 3, 3, 4, 2, 4, 3, 2, 3, 4 };
		System.out.println(maxIntinArray(arr));
		System.out.println(reverseOfBits(43261596));
		System.out.println(reverseBits31(1117003420));
	}

	public static List<List<Integer>> subsets(int[] num) {
		List<List<Integer>> outerList = new ArrayList<List<Integer>>();
		int limit = 1 << (num.length);
		int iterator = 0;
		while (iterator < limit) {
			int tempStore = iterator;
			int count = 0;
			List<Integer> innerList = new ArrayList<Integer>();
			while (tempStore != 0) {
				if ((tempStore & 1) == 1) {
					innerList.add(num[count]);
				}
				count++;
				tempStore = tempStore >> 1;
			}
			outerList.add(innerList);
			iterator++;
		}
		return outerList;
	}

	public static int maxIntinArray(int[] num) {
		int maxCount = 0;
		int maxCountIndex = 0;
		int prev = num[0];
		int current = num[0];
		for (int i = 0; i < num.length; i++) {
			current = num[i];
			int count = 0;
			if (i != 0 && current == prev) {
				continue;
			}
			for (int j = 0; j < num.length; j++) {
				if (num[i] == num[j])
					count++;
			}
			if (count > maxCount) {
				maxCount = count;
				maxCountIndex = i;
			}
			prev = num[i];
		}
		return num[maxCountIndex];
	}

	public static int reverseOfBits(int n) {
		counter = 0;
		return reveseBits(n);
	}

	static int counter = 0;

	private static int reveseBits(int n) {
		if (n < 2) {
			return n * (1 << counter);
		} else {
			int sum = reveseBits(n / 2);
			counter++;
			int adder = (n % 2) * (1 << counter);
			return sum + adder;
		}
	}

	public static int reverseBits31(int n) {
		for (int i = 0; i < 16; i++) {
			int a = n & (1 << (31 - i));
			int b = n & (1 << i);
			if ((a ^ b) != 0) {
				n = n ^ (1 << (31 - i));
				n = n ^ (1 << i);
			}
		}
		return n;
	}

}
