package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.service.impl.ShapeServiceImpl;

public class AopMain {

	public AopMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ShapeServiceImpl shapeService = (ShapeServiceImpl) context.getBean("shapeService");

		shapeService.getCircle().getName();
		shapeService.getCircle().passIntegrArgument(10);
		shapeService.getCircle().draw();

		shapeService.getCircle().getName();
		shapeService.getTriangle().draw();
	}

}
