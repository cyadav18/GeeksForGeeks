package com.geeksforgeeks.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PracticeHasHMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		displayArray(arr);
		printPrefixSum(arr);
		printAllSubArrayWithGivenSum(arr, 0);

	}

	public static void printAllSubArrayWithGivenSum(int[] arr, int sum) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		int prefixSum = 0;
		for (int i = 0; i < arr.length; i++) {
			prefixSum = prefixSum + arr[i];
			if (prefixSum == 0)
				outer.add(new ArrayList<Integer>(Arrays.asList(0, i)));
			if (map.containsKey(prefixSum - sum)) {
				ArrayList<Integer> list = map.get(prefixSum - sum);
				for (int j = 0; j < list.size(); j++) {
					outer.add(new ArrayList<Integer>(Arrays.asList(list.get(j) + 1, i)));
				}
				list.add(i);
			} else {
				map.put(prefixSum, new ArrayList<Integer>(Arrays.asList(i)));
			}
		}
		System.out.println(outer);
	}

	public static void printPrefixSum(int[] arr) {
		int prefixSum = 0;
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			prefixSum = prefixSum + arr[i];
			arr1[i] = prefixSum;
		}
		System.out.println(Arrays.toString(arr1));
	}

	public static void displayArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
