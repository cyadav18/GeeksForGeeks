package com.geeksforgeeks.hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class Basics {
	static ArrayList<LinkedList<Integer>> table = new ArrayList<LinkedList<Integer>>();
	static int bucket = 7;

	public static void main(String[] args) {

		for (int i = 0; i < bucket; i++) {
			table.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < 2 * 7; i++) {
			insert(i);
		}
		System.out.println(table);
		for (int i = 0; i < 2 * 7; i++) {
			System.out.println(search(i));
		}
		for (int i = 0; i < 2 * 7; i++) {
			remove(i);
		}
		System.out.println(table);
	}

	public static int binarySearch(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == element) {
				return mid;
			}
			if (arr[mid] < element) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void insert(int key) {
		int rem = key % bucket;
		table.get(rem).add(key);
	}

	public static boolean search(int key) {
		int rem = key % bucket;
		return (table.get(rem).contains(key));
	}

	public static void remove(int key) {
		int rem = key % bucket;
		table.get(rem).removeFirstOccurrence(key);
	}

}
