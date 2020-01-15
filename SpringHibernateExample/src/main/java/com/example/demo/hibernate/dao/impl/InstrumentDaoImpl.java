package com.example.demo.hibernate.dao.impl;

import javax.annotation.Resource;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hibernate.dao.InstrumentDao;
import com.example.demo.hibernate.entities.Instrument;

@Transactional
@Repository("instrumentDao")
public class InstrumentDaoImpl implements InstrumentDao {

	private static final Log logger = LogFactory.getLog(SingerDaoImpl.class);
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Instrument save(Instrument instrument) {
		sessionFactory.getCurrentSession().saveOrUpdate(instrument);
		logger.info("Singer saved with id: " + instrument.getInstrumentId());
		return instrument;
	}

}
