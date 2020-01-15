package com.example.demo.hibernate.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hibernate.dao.SingerDao;
import com.example.demo.hibernate.entities.Singer;

@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {
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
	@Transactional(readOnly = true)
	public List<Singer> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAllWithAlbum() {
		return sessionFactory.getCurrentSession().getNamedQuery("Singer.findAllWithAlbum").list();
	}

	@Override
	@Transactional(readOnly = true)
	public Singer findById(Long id) {
		return (Singer) sessionFactory.getCurrentSession().getNamedQuery("Singer.findById").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public Singer save(Singer singer) {
		sessionFactory.getCurrentSession().saveOrUpdate(singer);
		logger.info("Singer saved with id: " + singer.getId());
		return singer;
	}

	@Override
	public void delete(Singer contact) {
		// TODO Auto-generated method stub

	}

}
