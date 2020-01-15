package com.example.demo.jdbc.model;

import java.util.Date;

public class Album {
	private Long id;
	private Long singerId;
	private String titleName;
	private Date releaseDate;

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(Long id, Long singerId, String titleName, Date releaseDate) {
		super();
		this.id = id;
		this.singerId = singerId;
		this.titleName = titleName;
		this.releaseDate = releaseDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSingerId() {
		return singerId;
	}

	public void setSingerId(Long singerId) {
		this.singerId = singerId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}
