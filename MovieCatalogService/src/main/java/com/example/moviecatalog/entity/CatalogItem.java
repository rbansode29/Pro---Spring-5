package com.example.moviecatalog.entity;

public class CatalogItem {

	private String title;
	private String description;
	private Integer rating;

	public CatalogItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatalogItem(String title, String description, Integer rating) {
		super();
		this.title = title;
		this.description = description;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
