package com.example.demo.hibernate.dao;

import java.util.List;

import com.example.demo.hibernate.entities.Singer;

public interface SingerDao {
	List<Singer> findAll();
	List<Singer> findAllWithAlbum();
	Singer findById(Long id);
	Singer save(Singer contact);
	void delete(Singer contact);
}
