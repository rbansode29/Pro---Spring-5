package com.example.demo.hibernate.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "album")
public class Album implements Serializable {
	private Long id;
	private String title;
	private Date releaseDate;
	private int version;

	private Singer singer;

	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	@Version
	@Column(name = "VERSION")
	public int getVersion() {
		return version;
	}

	@Column
	public String getTitle() {
		return this.title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RELEASE_DATE")
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne
	@JoinColumn(name = "SINGER_ID")
	public Singer getSinger() {
		return this.singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Album - Id: " + id + ", Title: " + title + ", Release Date: " + releaseDate;
	}

}
