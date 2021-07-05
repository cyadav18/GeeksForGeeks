package com.geeksforgeeks.sorting;

import java.util.Arrays;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 20, 12, 30 };
		arr = new int[] { 'A', 'a', 'B', 'b', 'C', 'c' };
		Arrays.sort(arr, 2, 5);
		System.out.println(Arrays.toString(arr));
		Student[] arr1 = { new Student(2, "F"), new Student(3, "B"), new Student(5, "D"), new Student(2, "E"),
				new Student(7, "A"), new Student(4, "C") };
		Arrays.sort(arr1);
		System.out.println(Arrays.deepToString(arr1));

	}
}

class Student implements Comparable<Student> {

	private int rollNo;
	private String name;

	public Student(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rollNo;
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
		Student other = (Student) obj;
		if (rollNo != other.rollNo)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student s) {
		if ((this.rollNo % 2 - s.rollNo * 2) != 0) {
			return (this.rollNo % 2 - s.rollNo % 2);
		} else {
			return this.name.compareTo(s.name);
		}
	}

	@Override
	public String toString() {
		return "[rollNo=" + rollNo + ", name=" + name + "]";
	}

}