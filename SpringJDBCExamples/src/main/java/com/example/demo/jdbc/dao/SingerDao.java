package com.example.demo.jdbc.dao;

import java.util.List;

import com.example.demo.jdbc.model.Singer;

public interface SingerDao {

	String findNameById(Long id);

	List<Singer> findAll();

	List<Singer> findAllWithAlbums();

	List<Singer> findByFirstName(String firstName);

	String findLastNameById(Long id);

	String findFirstNameById(Long id);

	void insert(Singer singer);

	void update(Singer singer);

	void delete(Long singerId);

	void insertWithAlbum(Singer singer);
}
