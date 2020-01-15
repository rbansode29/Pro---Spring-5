package com.example.demo.service.impl;

import com.example.demo.model.Circle;
import com.example.demo.model.Triangle;
import com.example.demo.service.ShapeService;

public class ShapeServiceImpl implements ShapeService {

	private Circle circle;

	private Triangle triangle;

	public ShapeServiceImpl() {
		super();
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
