package com.example.demo.hibernate.services;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hibernate.dao.InstrumentDao;
import com.example.demo.hibernate.dao.SingerDao;
import com.example.demo.hibernate.entities.Album;
import com.example.demo.hibernate.entities.Instrument;
import com.example.demo.hibernate.entities.Singer;

@Service
public class DBInitializer {
	private Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	@Autowired
	SingerDao singerDao;
	@Autowired
	InstrumentDao instrumentDao;

	@PostConstruct
	public void initDB() {
		logger.info("Starting database initialization...");
		Instrument guitar = new Instrument();
		guitar.setInstrumentId("Guitar");
		instrumentDao.save(guitar);

		Singer singer = new Singer();
		singer.setFirstName("Ravindra");
		singer.setLastName("Bansode");
		singer.setBirthDate(new Date((new GregorianCalendar(1977, 9, 16)).getTime().getTime()));
		singer.getInstruments().add(guitar);

		Album album1 = new Album();
		album1.setTitle("The Search For Everything");
		album1.setReleaseDate(new java.sql.Date((new GregorianCalendar(2017, 0, 20)).getTime().getTime()));
		singer.addAbum(album1);
		Album album2 = new Album();
		album2.setTitle("Battle Studies");
		album2.setReleaseDate(new java.sql.Date((new GregorianCalendar(2009, 10, 17)).getTime().getTime()));
		singer.addAbum(album2);
		singerDao.save(singer);
		logger.info("Database initialization finished.");
	}
}
