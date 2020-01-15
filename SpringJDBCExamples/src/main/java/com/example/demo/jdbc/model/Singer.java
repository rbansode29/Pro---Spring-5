package com.example.demo.jdbc.model;

import java.util.Date;
import java.util.List;

public class Singer {
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private List<Album> albums;

	public Singer() {
		super();
	}

	public Singer(Long id, String firstName, String lastName, Date birthDate, List<Album> albums) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.albums = albums;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

}
