package com.geeksforgeeks.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class HashMapProblem {
	public static void main(String[] args) {
		int[] arr = { 15, 12, 13, 12, 13, 13, 18 };
		System.out.println("countDistinctElement " + countDistinctElement(arr));
		arr = new int[] { 10, 12, 10, 15, 10, 20, 12, 12 };
		printNumberOfOccurance(arr);
		int[] arr1 = new int[] { 10, 15, 20, 5, 5, 8, 2, 30 };
		int[] arr2 = new int[] { 30, 5, 30, 80, 16, 17 };
		printCommonElements(arr1, arr2);
		printDistinctElement(arr1, arr2);
		printPairWithGivenSum(arr1, 10);
		arr = new int[] { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		subArrayWithSumZero(arr);
		printSubArrayWithSumZero(arr);
		arr = new int[] { 0, 0, 0, 0, 15, 2, 8, 10, 0, -5, -8, 6, 0, 0, 0, 0, 0 };
		arr = new int[] { 8, 3, 1, 5, -6, 6, 2, 2 };
		printAllSubArrayWithSum(arr, 4);
		arr = new int[] { 0, 0, 0, 3, 1, 0, 1, 8, 2, 3, 6 };
		printLongestSubArray(arr, 5);
	}

	// need to make correction for 0 condition
	public static void printLongestSubArray(int[] arr, int sum) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int max = 0;
		int prefixSum = 0;
		for (int i = 0; i < arr.length; i++) {
			prefixSum = prefixSum + arr[i];
			if (prefixSum == sum) {
				if (i > max)
					max = i + 1;
			}
			int totalDif = sum - prefixSum;
			if (map.containsKey(totalDif)) {
				ArrayList<Integer> list = map.get(totalDif);
				for (int j = 0; j < list.size(); j++) {
					int dif = i - list.get(j);
					if (dif > max)
						max = dif;
				}
			}
			if (map.containsKey(prefixSum)) {
				map.get(prefixSum).add(i);
			} else {
				map.put(prefixSum, new ArrayList<Integer>(Arrays.asList(i)));
			}

		}
		System.out.println("printLongestSubArray " + max);
	}

// 15, 2, 8, 10, 0, -5, -8, 6, 0 
	public static void printAllSubArrayWithSum(int[] arr, int sum) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		int prefixSum = 0;
		for (int i = 0; i < arr.length; i++) {
			prefixSum = prefixSum + arr[i];
			if (prefixSum == sum) {
				outer.add(new ArrayList<Integer>(Arrays.asList(0, i)));
			}
			int dif = prefixSum - sum;
			if (map.containsKey(dif)) {
				ArrayList<Integer> list = map.get(dif);
				int size = list.size();
				for (int j = 0; j < size; j++) {
					int index = list.get(j) + 1;
					outer.add(new ArrayList<Integer>(Arrays.asList(index, i)));
				}
			}
			// Do this for both the cases so putting it in the general conditions (for not
			// present also for present also)
			if (map.containsKey(prefixSum)) {
				map.get(prefixSum).add(i);
			} else {
				map.put(prefixSum, new ArrayList<Integer>(Arrays.asList(i)));
			}

		}
		System.out.println("printAllSubArrayWithSum " + outer);
	}

	public static boolean subArrayWithSumK(int[] arr, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		int sum1 = 0;
		for (int i = 0; i < arr.length; i++) {
			sum1 = sum1 + arr[i];
			if (sum == sum1)
				return true;
			int dif = sum - sum1;
			if (set.contains(dif)) {
				return true;
			} else {
				set.add(sum1);
			}
		}
		return false;
	}

	// -3 -1 0 -2 -1 0 7
	// 6 9 8 5 9 7 9 13 19 7 0 Arraylist to catch the duplicates of repeated to form
	// the be form sum 0 from repeating index
	// prefixsum
	public static void printSubArrayWithSumZero(int[] arr) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum == 0) {
				outer.add(new ArrayList<Integer>(Arrays.asList(0, i)));
			}
			if (map.containsKey(sum)) {
				ArrayList<Integer> list = map.get(sum);
				int len = list.size();
				for (int j = 0; j < len; j++) {
					int index = list.get(j) + 1;
					outer.add(new ArrayList<Integer>(Arrays.asList(index, i)));
				}
				list.add(i);
				map.put(sum, list);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(sum, list);
			}
		}
		System.out.println(outer);
	}

	public static void subArrayWithSumZero(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (map.containsKey(sum)) {
				int index = map.get(sum);
				res.put(index + 1, arr[index + 1]);
				res.put(i, arr[i]);
				map.put(sum, i);
			} else {
				map.put(sum, i);
			}

		}
		System.out.println("subArrayWithSumZero " + res);
	}

	// a+b = c that is b = c-a;
	public static void printPairWithGivenSum(int[] arr, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int search = sum - arr[i];
			if (map.containsKey(search)) {
				res.put(map.get(search), search);
				res.put(i, arr[i]);
			} else {
				map.put(arr[i], i);
			}
		}
		System.out.println("printPairWithGivenSum " + res);
	}

	public static void printDistinctElement(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int element : arr1)
			set.add(element);
		for (int element : arr2)
			set.add(element);
		System.out.println("printDistinctElement " + set);
	}

	public static void printCommonElements(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> set1 = new HashSet<Integer>();
		int count = 0;
		if (arr1.length < arr2.length) {
			for (int element : arr1)
				set.add(element);

			for (int element : arr2) {
				if (set.contains(element)) {
					set1.add(element);
					set.remove(element);
					count++;
				}
			}
		} else {
			for (int element : arr2)
				set.add(element);

			for (int element : arr1) {
				if (set.contains(element)) {
					set1.add(element);
					set.remove(element);
					count++;
				}
			}
		}
		System.out.print("printCommonElements " + set1);
		System.out.println(" " + count);
	}

	public static void printNumberOfOccurance(int[] arr) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			Integer key = arr[i];
			if (map.get(arr[i]) == null) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		System.out.print("printNumberOfOccurance ");
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.print(e.getKey() + " " + e.getValue() + "|");
		}
		System.out.println();
	}

	public static int countDistinctElement(int[] arr) {
		Set<Integer> s = new LinkedHashSet<Integer>();
		for (int i = 0; i < arr.length; i++)
			s.add(arr[i]);
		return s.size();
	}
}
