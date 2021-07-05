package com.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ProblemsGeeks {

	public static void main(String[] args) {
		int[] L = { 1, 5, 9, 13, 21 };
		int[] R = { 15, 8, 12, 20, 30 };
		ArrayList<Range> al = new ArrayList<Range>();
		for (int i = 0; i < L.length; i++) {
			Range r = new Range(L[i], R[i]);
			al.add(r);
		}
		Collections.sort(al);
		int[] arr = maxOccured(L, R);
		displayArray(arr);
		System.out.println(getIntersection(al));
	}

	public static Range getIntersection(ArrayList<Range> al) {
		Range r = al.get(0);
		for (int i = 1; i < al.size(); i++) {
			int left = Math.max(r.getX(), al.get(i).getX());
			int right = Math.min(r.getY(), al.get(i).getY());
			if (right >= left) {
				r.setX(left);
				r.setY(right);
			}
		}
		return r;
	}

//	Given n integer ranges, the task is to find the maximum occurring integer in these ranges. If more than one such integer exits, find the smallest one. The ranges are given as two arrays L[] and R[].  L[i] consists of starting point of range and R[i] consists of corresponding end point of the range.
//
//	For example consider the following ranges.
//	L[] = {2, 1, 3}, R[] = {5, 3, 9)
//	Ranges represented by above arrays are.
//	[2, 5] = {2, 3, 4, 5}
//	[1, 3] = {1, 2, 3}
//	[3, 9] = {3, 4, 5, 6, 7, 8, 9}
//	The maximum occurred integer in these ranges is 3.

	// int[] L = { 1, 4, 9, 13, 21 };
//	int[] R = { 15, 8, 12, 20, 30 };

	public static int[] maxOccured(int L[], int R[]) {
		int[] finalRange = new int[2];
		int[] range = new int[2];
		range[0] = L[0];
		range[1] = R[0];
		finalRange[0] = range[0];
		finalRange[1] = range[1];
		for (int i = 1; i < L.length; i++) {
			int leftMax = L[i];
			int rightMin = R[i];
			if (leftMax > range[0]) {
				range[0] = leftMax;
			}
			if (rightMin < range[1]) {
				range[1] = rightMin;
			}

			if (range[1] >= range[0]) {
				finalRange[0] = range[0];
				finalRange[1] = range[1];
			} else {
				range[0] = finalRange[0];
				range[1] = finalRange[1];
			}
		}
		return finalRange;
	}

	public static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

class Range implements Comparable<Range> {
	private int x;
	private int y;

	public Range(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public boolean isValid() {
		return x < y;
	}

	public void reset() {
		this.x = 0;
		this.y = 0;
	}

	@Override
	public int compareTo(Range r) {
		return this.x - r.x;
	}

}

class testRange {
	public static void main(String[] args) {
		Range r = new Range(4, 3);
		System.out.println(r.isValid());
		ArrayList<Range> al = new ArrayList<Range>();
		al.add(new Range(1, 2));
		al.add(new Range(-1, 3));
		al.add(new Range(4, 6));
		System.out.println(al);
		Collections.sort(al);
		Collections.reverse(al);
		System.out.println();
	}
}

class ListNode {
	int data;
	ListNode next;
	ListNode prev;

	public ListNode(int data) {
		this.data = data;
	}

	public String toString() {
		return " " + this.data + " ";
	}
}

class LinkedLst {
	ListNode head;
	ListNode last;
	int size;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode temp = head;
		while (temp != null) {
			sb.append(temp.data + " ");
			temp = temp.next;
		}
		return sb.toString();
	}

	public String toStringRverse() {
		StringBuilder sb = new StringBuilder();
		ListNode temp = last;
		while (temp != null) {
			sb.append(temp.data + " ");
			temp = temp.prev;
		}
		return sb.toString();
	}

	public void addAtHead(int data) {
		ListNode temp = new ListNode(data);
		if (head == null) {
			this.head = temp;
			last = head;
		} else {
			temp.next = head;
			head.prev = temp;
			this.head = temp;
		}
		size++;
	}

	public void addatTail(int data) {
		ListNode temp = new ListNode(data);
		if (head == null) {
			this.head = temp;
			last = head;
		} else {
			last.next = temp;
			temp.prev = last;
			this.last = temp;
		}
		size++;
	}

	public void addAtIndex(int data, int index) {
		if (index > size)
			return;
		if (index == 0) {
			addAtHead(data);
			return;
		}
		if (index == size) {
			addatTail(data);
			return;
		}
		int pos = 0;
		ListNode temp = head;
		while (pos < index && temp != null) {
			temp = temp.next;
			pos++;
		}
		ListNode prev = temp.prev;
		ListNode node = new ListNode(data);
		prev.next = node;
		node.prev = prev;
		node.next = temp;
		temp.prev = node;
		size++;
	}

	public int getAtIndex(int index) {
		if (index >= size || index < 0)
			return -1;
		int pos = 0;
		ListNode temp = head;
		while (pos < index && temp != null) {
			temp = temp.next;
			pos++;
		}
		if (pos == index) {
			return temp.data;
		}
		return -1;
	}

	public void deletAtIndex(int index) {
		if (index >= size || index < 0)
			return;
		if (index == 0) {
			head = head.next;
			head.prev = null;
			size--;
			return;
		}
		if (index == size-1) {
			last = last.prev;
			last.next = null;
			size--;
			return;
		} else {
			ListNode temp = head;
			int pos = 0;
			while (pos < index && temp != null) {
				temp = temp.next;
				pos++;
			}
			ListNode prev = temp.prev;
			ListNode next = temp.next;
			prev.next = next;
			next.prev = prev;
			temp.next = null;
			temp.prev = null;
			temp = null;
			size--;
		}
	}
}

class TestLinkedlst {
	public static void main(String[] args) {
		LinkedLst l = new LinkedLst();
//		for (int i = 1; i <= 5; i++) {
//			l.addAtHead(i);
//		}
//		for (int i = 6; i <= 10; i++) {
//			l.addatTail(i);
//		}
//		l.addAtIndex(99, 3);
//		System.out.println(l);
//		l.deletAtIndex(9);
//		System.out.println(l);
		l.addAtHead(1);
//		System.out.println(l);
//		l.addatTail(3);
//		System.out.println(l);
//		l.addAtIndex(2, 1);
//		System.out.println(l);
//		System.out.println(l.getAtIndex(1));
		l.deletAtIndex(1);
		System.out.println(l);
		l.getAtIndex(1);
	}
}
