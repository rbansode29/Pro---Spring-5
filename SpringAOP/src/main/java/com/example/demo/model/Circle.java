package com.example.demo.model;

public class Circle {

	private String name;

	public Circle(String p_name) {
		this.name = p_name;
	}

	public void draw() {
		System.out.println(getName() + " drawn successfully");
	}

	public String getName() {
		return name;
	}

	public Integer passIntegrArgument(Integer p_param) {
		System.out.println(p_param + " passed to method");
		return p_param;
	}

}
