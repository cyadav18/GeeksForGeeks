package com.leetcode.bitManipulation;

public class LRUCache {

	public static void main(String[] args) {

		DoubleLinkedList d = new DoubleLinkedList(2);
		d.put(new Data(1, 1));
		d.put(new Data(2, 2));
		System.out.println(d);
		System.out.println(d.get(1));
		System.out.println(d);
		d.put(new Data(3, 3));
		System.out.println(d);
		d.put(new Data(4, 4));
		System.out.println(d);
		System.out.println(d.get(1));
		System.out.println(d.get(3));
		System.out.println(d.get(4));
//		for (int i = 1; i < 10; i++) {
//			d.put(new Data(i, i));
//		}
//		System.out.println(d);
//		System.out.println(d.toStringReverse());
	}

}

class Data {
	int key;
	int value;

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (key != other.key)
			return false;
		return true;
	}

	public Data(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public String toString() {
		return "[" + key + " ," + value + "]";
	}
}

class ListNode {
	public Data data;
	public ListNode next;
	public ListNode prev;

	public ListNode(Data data) {
		this.data = data;
	}

}

class DoubleLinkedList {
	ListNode head;
	ListNode last;
	int size = 0;
	int capacity = 0;

	public DoubleLinkedList(int cap) {
		this.capacity = cap;
	}

	public String toString() {
		ListNode temp = head;
		StringBuilder sb = new StringBuilder();
		while (temp != null) {
			sb.append(temp.data + " ");
			temp = temp.next;
		}
		sb.append("\n");
		return sb.toString();
	}

	public String toStringReverse() {
		ListNode temp = last;
		StringBuilder sb = new StringBuilder();
		while (temp != null) {
			sb.append(temp.data + " ");
			temp = temp.prev;
		}
		sb.append("\n");
		return sb.toString();
	}

	public void put(Data data) {
		ListNode temp = new ListNode(data);
		if (size >= capacity) {
			last = last.prev;
			last.next = null;
			size--;
		}
		if (head == null) {
			head = temp;
			last = temp;
		} else {
			head.prev = temp;
			temp.next = head;
			head = temp;
		}
		size++;
	}

	public int get(int key) {
		Data data = new Data(key, 0);
		ListNode temp = head;
		if (head == null)
			return -1;
		if (head.data.equals(data)) {
			return head.data.key;
		}
		while (temp != null) {
			if (temp.data.equals(data)) {
				ListNode next = temp.next;
				ListNode prev = temp.prev;
				if (prev != null) {
					prev.next = next;
				}
				if (next != null) {
					next.prev = prev;
				} else {
					this.last = prev;
				}
				head.prev = temp;
				temp.next = head;
				this.head = temp;
				temp.prev = null;
				return temp.data.key;
			}
			temp = temp.next;
		}
		return -1;
	}
}
