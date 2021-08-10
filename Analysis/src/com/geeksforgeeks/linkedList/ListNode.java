package com.geeksforgeeks.linkedList;

public class ListNode<T extends Comparable<T>> implements Comparable<ListNode<T>> {
	private T data;
	private ListNode<T> next;
	private ListNode<T> prev;

	public ListNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	public ListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(ListNode<T> prev) {
		this.prev = prev;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		ListNode other = (ListNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	public String toString() {
		return "[" + data + "]";
	}

	public int compareTo(ListNode<T> o) {
		return this.data.compareTo(o.data);
	}

}

class TestListNode {
	public static void main(String[] args) {
		ListNode<Integer> l1 = new ListNode<Integer>(1);
		ListNode<Integer> l2 = new ListNode<Integer>(2);
		ListNode<Integer> l3 = new ListNode<Integer>(3);
		l1.setNext(l2);
		l2.setNext(l3);
		l3.setPrev(l2);
		l2.setPrev(l1);
		System.out.println(l1);
		System.out.println(l1.getNext());
		System.out.println(l1.getNext().getNext());
		System.out.println(l3);
		System.out.println(l3.getPrev());
		System.out.println(l3.getPrev().getPrev());
	}
}