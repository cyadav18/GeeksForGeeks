package com.geeksforgeeks.linkedList;

public class LinkedList<T extends Comparable<T>> {

	private ListNode<T> head;
	private ListNode<T> last;
	private int size;

	public int getSize() {
		return size;
	}

	// printing
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode<T> temp = this.head;
		while (temp != null) {
			sb.append(temp + "->");
			temp = temp.getNext();
		}
		return sb.toString();
	}

	// printing reverse
	public String toStringReverse() {
		StringBuilder sb = new StringBuilder();
		ListNode<T> temp = this.last;
		while (temp != null) {
			sb.append(temp + "->");
			temp = temp.getPrev();
		}
		return sb.toString();
	}

	// adding data
	public void add(T data) {
		ListNode<T> node = new ListNode<T>(data);
		if (head == null) {
			this.head = node;
			this.last = node;
		} else {
			last.setNext(node);
			node.setPrev(last);
			last = node;
		}
		size++;
	}

	public void addAtBegining(T data) {
		ListNode<T> node = new ListNode<T>(data);
		if (head == null) {
			this.head = node;
			this.last = node;
		} else {
			node.setNext(head);
			head.setPrev(node);
			this.head = node;
		}
		size++;
	}

	public void addAtEnd(T data) {
		ListNode<T> node = new ListNode<T>(data);
		if (head == null) {
			this.head = node;
			this.last = node;
		} else {
			last.setNext(node);
			node.setPrev(last);
			this.last = node;
		}
		size++;
	}

	// recursion
	public void printForward() {
		printForward(this.head);
		System.out.println();
	}

	private void printForward(ListNode<T> head) {
		if (head == null)
			return;
		else {
			System.out.print(head + "->");
			printForward(head.getNext());
		}
	}

	// recursion print from tail
	public void printbackWard() {
		printbackWard(this.head);
		System.out.println();
	}

	private void printbackWard(ListNode<T> head) {
		if (head == null)
			return;
		printbackWard(head.getNext());
		System.out.print(head + "->");
	}

	public void deleteFirstNode() {
		if (head == null)
			return;
		else if (head.getNext() == null) {
			head = null;
			last = null;
		} else {
			head = head.getNext();
			head.setPrev(null);
			if (head == null)
				last = null;
		}
		size--;
	}

	public void deleteLastNode() {
		if (head == null)
			return;
		else if (head.getNext() == null) {
			head = null;
			last = null;
			return;
		} else {
			last = last.getPrev();
			last.setNext(null);
		}
		size--;
	}

	public void insertAtPosition(T data, int pos) {
		if (head == null || pos > size + 1)
			return;
		int count = 1;
		ListNode<T> temp = this.head;
		while (count < pos && temp != null) {
			count++;
			if (count == pos)
				break;
			temp = temp.getNext();
		}
		ListNode<T> node = new ListNode<T>(data);
		if (temp.getPrev() == null) {
			node.setNext(head);
			head.setPrev(node);
			this.head = node;
			size++;
		} else {
			node.setNext(temp.getNext());
			if (temp.getNext() != null) {
				temp.getNext().setPrev(node);
			} else {
				this.last = node;
			}
			temp.setNext(node);
			node.setPrev(temp);
		}
		size++;
	}

	public int search(T data) {
		if (head == null)
			return -1;
		else {
			ListNode<T> temp = this.head;
			int pos = 1;
			while (temp != null) {
				if (temp.getData().equals(data))
					break;
				pos++;
				temp = temp.getNext();
			}
			return pos;
		}
	}

	public int searchRecursive(T data) {
		return searchRecursive(this.head, data);
	}

	public int searchRecursive(ListNode<T> head, T data) {
		if (head == null)
			return -1;
		else {
			if (head.getData().equals(data)) {
				return 1;
			} else {
				int pos = searchRecursive(head.getNext(), data);
				if (pos != -1) {
					return pos + 1;
				} else {
					return -1;
				}
			}
		}
	}

}

class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> lst = new LinkedList<Integer>();
		for (int i = 1; i <= 10; i++) {
			lst.add(i);
		}
		System.out.println("printing forward" + lst);
		System.out.println("\nprinting backward" + lst.toStringReverse());
		System.out.print("\nrecursion forward");
		lst.printForward();
		System.out.print("\nrecursion backward");
		lst.printbackWard();
		lst.addAtBegining(0);
		lst.addAtEnd(11);
		lst.deleteFirstNode();
		lst.deleteLastNode();
		System.out.println("\nadding at begining and end , deleting at begining forward\t" + lst);
		System.out.println("\nadding at begining and end , deleting at begining backward\t" + lst.toStringReverse());
		System.out.println(lst);
		lst.insertAtPosition(99, lst.getSize() + 1);
		System.out.println(lst);
		System.out.println(lst.searchRecursive(98));
	}
}