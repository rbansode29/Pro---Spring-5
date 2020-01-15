package com.example.demo.model;

public class Triangle {
	private String name;

	public Triangle(String p_name) {
		this.name = p_name;
	}

	public void draw() {
		System.out.println(getName() + " drawn successfully");
	}

	public String getName() {
		return name;
	}

}
