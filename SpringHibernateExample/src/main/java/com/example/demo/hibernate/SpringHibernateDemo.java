package com.example.demo.hibernate;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.example.demo.hibernate.config.AppConfig;
import com.example.demo.hibernate.dao.SingerDao;
import com.example.demo.hibernate.entities.Album;
import com.example.demo.hibernate.entities.Instrument;
import com.example.demo.hibernate.entities.Singer;

public class SpringHibernateDemo {
	private static Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

	public static void main(String[] args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		// listSingers(singerDao.findAll());

		Singer singer = singerDao.findById(2l);
		singerDao.delete(singer);
		listSingersWithAlbum(singerDao.findAllWithAlbum());

		saveSinger(singerDao);
		//ctx.close();
	}

	private static void saveSinger(SingerDao singerDao) {
		Singer singer = new Singer();
		singer.setFirstName("BB");
		singer.setLastName("King");
		singer.setBirthDate(new Date((new GregorianCalendar(1940, 8, 16)).getTime().getTime()));
		Album album = new Album();
		album.setTitle("My Kind of Blues");
		album.setReleaseDate(new java.sql.Date((new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
		singer.addAbum(album);
		album = new Album();
		album.setTitle("A Heart Full of Blues");
		album.setReleaseDate(new java.sql.Date((new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
		singer.addAbum(album);
		singerDao.save(singer);
		List<Singer> singers = singerDao.findAllWithAlbum();
		listSingersWithAlbum(singers);

	}

	private static void listSingersWithAlbum(List<Singer> singers) {
		logger.info(" ---- Listing singers with instruments:");
		for (Singer singer : singers) {
			logger.info(singer.toString());
			if (singer.getAlbums() != null) {
				for (Album album : singer.getAlbums()) {
					logger.info("\t" + album.toString());
				}
			}
			if (singer.getInstruments() != null) {
				for (Instrument instrument : singer.getInstruments()) {
					logger.info("\t" + instrument.getInstrumentId());
				}
			}
		}
	}

	private static void listSingers(List<Singer> singers) {
		logger.info(" ---- Listing singers:");
		for (Singer singer : singers) {
			logger.info(singer.toString());
		}
	}

}
