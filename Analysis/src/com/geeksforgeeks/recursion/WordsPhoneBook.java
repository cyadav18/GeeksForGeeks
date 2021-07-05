package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordsPhoneBook {
	static char[][] arr = new char[][] { { '\0' }, { '\0' }, { 'A', 'B', 'C' }, { 'D', 'E', 'F' }, { 'G', 'H', 'I' },
			{ 'J', 'K', 'L' }, { 'M', 'N', 'O' }, { 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y', 'Z' },
			{ '*' }, { '#' } };
	static int count = 0;

	public static void main(String[] args) {

		printWrapper("234");
		System.out.println();
		System.out.println(possibleWords(new int[] { 2, 3, 4 }));
	}

	public static void printWrapper(String s) {
		printWords(arr, s, "");
	}

	public static void printWords(char[][] arr, String giveString, String current) {
		if (giveString.length() == 1) {
			printArray(arr, Integer.parseInt(giveString), current);
			return;
		} else {

			String current_number = "" + giveString.charAt(0);
			int index = Integer.parseInt(current_number);
			for (int j = 0; j < arr[index].length; j++) {
				current = current + arr[index][j];
				printWords(arr, giveString.substring(1), current);
				current = current.replace(arr[index][j] + "", "");
			}

		}
	}

	public static void printArray(char[][] arr, int i, String s) {
		for (int k = 0; k < arr[i].length; k++) {
			System.out.print(s + arr[i][k] + " ");
		}
		System.out.println();
	}

	public static ArrayList<String> possibleWords(int[] arrNum) {
		ArrayList<String> words = new ArrayList<String>();
		getWords(words, arrNum, "");
		return words;
	}

	public static void getWords(ArrayList<String> words, int[] arrNum, String current) {
		if (current.length() == arrNum.length - 1) {
			addToList(words, current, arrNum[current.length()]);
			return;
		} else {
			int first = arrNum[current.length()];
			for (int i = 0; i < arr[first].length; i++) {
				current = current + arr[first][i];
				getWords(words, arrNum, current);
				current = current.substring(0, current.length() - 1);
			}
		}
	}

	public static void addToList(ArrayList<String> words, String s, int i) {
		for (int j = 0; j < arr[i].length; j++) {
			words.add(s + arr[i][j]);
		}
	}
}
