package com.royal.bean;

public class StudentBean {

	int id, marks, std;
	String name;
	
	public StudentBean() {
		
	}
	
	public StudentBean(int marks, int std, String name) {
		this.marks = marks;
		this.std = std;
		this.name = name;
	}

	public StudentBean(int id, int marks, int std, String name) {
		this.id = id;
		this.marks = marks;
		this.std = std;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
