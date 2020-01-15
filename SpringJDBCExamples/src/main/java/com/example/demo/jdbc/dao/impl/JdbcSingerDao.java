package com.example.demo.jdbc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.jdbc.dao.SingerDao;
import com.example.demo.jdbc.embededsupport.InsertSinger;
import com.example.demo.jdbc.embededsupport.InsertSingerAlbum;
import com.example.demo.jdbc.embededsupport.SelectAllSingers;
import com.example.demo.jdbc.embededsupport.SelectSingerByFirstName;
import com.example.demo.jdbc.embededsupport.StoredFunctionFirstNameById;
import com.example.demo.jdbc.embededsupport.UpdateSinger;
import com.example.demo.jdbc.exceptions.MySQLErrorCodesTranslator;
import com.example.demo.jdbc.model.Album;
import com.example.demo.jdbc.model.Singer;
import com.example.demo.jdbc.model.extractor.SingerWithDetailExtractor;
import com.example.demo.jdbc.model.mapper.SingerMapper;

@Repository("singerDao")
public class JdbcSingerDao implements SingerDao, InitializingBean {

	private static final Log logger = LogFactory.getLog(JdbcSingerDao.class);

	@Resource(name = "dataSource")
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private SelectAllSingers selectAllSingers;

	private SelectSingerByFirstName selectSingerByFirstName;

	private UpdateSinger updateSinger;

	private InsertSinger insertSinger;

	private InsertSingerAlbum insertSingerAlbum;

	private StoredFunctionFirstNameById storedFunctionFirstNameById;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		initJdbcTemplate(dataSource);
		this.selectAllSingers = new SelectAllSingers(dataSource);
		this.selectSingerByFirstName = new SelectSingerByFirstName(dataSource);
		this.updateSinger = new UpdateSinger(dataSource);
		this.insertSinger = new InsertSinger(dataSource);
		this.insertSingerAlbum = new InsertSingerAlbum(dataSource);
	}

	private void initJdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		MySQLErrorCodesTranslator errorTranslator = new MySQLErrorCodesTranslator();
		errorTranslator.setDataSource(dataSource);
		jdbcTemplate.setExceptionTranslator(errorTranslator);
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("Must set dataSource on SingerDao");
		}
	}

	@Override
	public String findNameById(Long id) {
		String queryValue = usingNamedParameterJdbcTemplate(id);
		queryValue = usingJdbcTemplate(id);
		return queryValue;

	}

	private String usingJdbcTemplate(Long id) {
		return jdbcTemplate.queryForObject("select first_name || ' ' || last_name from singer where id = ?",
				new Object[] { id }, String.class);
	}

	private String usingNamedParameterJdbcTemplate(Long id) {
		String sql = "SELECT first_name ||' '|| last_name FROM singer WHERE id = :singerId";
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("singerId", id);
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
	}

	@Override
	public List<Singer> findAll() {
		List<Singer> l_tempList = usingSelectAllSinger();
		String sql = "select id, first_name, last_name, birth_date from singer";
		return namedParameterJdbcTemplate.query(sql, new SingerMapper());

	}

	private List<Singer> usingSelectAllSinger() {
		return selectAllSingers.execute();

	}

	@Override
	public List<Singer> findAllWithAlbums() {
		String sql = "select s.id, s.first_name, s.last_name, s.birth_date"
				+ ", a.id as a.album_id, a.title, a.release_date from singer s "
				+ "left join album a on s.id = a.singer_id";
		return namedParameterJdbcTemplate.query(sql, new SingerWithDetailExtractor());
	}

	@Override
	public List<Singer> findByFirstName(String firstName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", firstName);
		return selectSingerByFirstName.executeByNamedParam(paramMap);
	}

	@Override
	public String findLastNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFirstNameById(Long id) {
		List<String> result = storedFunctionFirstNameById.execute(id);
		return result.get(0);
	}

	@Override
	public void insert(Singer singer) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", singer.getFirstName());
		paramMap.put("last_name", singer.getLastName());
		paramMap.put("birth_date", singer.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		insertSinger.updateByNamedParam(paramMap, keyHolder);
		singer.setId(keyHolder.getKey().longValue());
		logger.info("New singer inserted with id: " + singer.getId());

	}

	@Override
	public void update(Singer singer) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("first_name", singer.getFirstName());
		paramMap.put("last_name", singer.getLastName());
		paramMap.put("birth_date", singer.getBirthDate());
		paramMap.put("id", singer.getId());
		updateSinger.updateByNamedParam(paramMap);
		logger.info("Existing singer updated with id: " + singer.getId());
	}

	@Override
	public void delete(Long singerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertWithAlbum(Singer singer) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("first_name", singer.getFirstName());
		paramMap.put("last_name", singer.getLastName());
		paramMap.put("birth_date", singer.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		insertSinger.updateByNamedParam(paramMap, keyHolder);
		singer.setId(keyHolder.getKey().longValue());
		logger.info("New singer inserted with id: " + singer.getId());
		List<Album> albums = singer.getAlbums();
		if (albums != null) {
			for (Album album : albums) {
				paramMap = new HashMap<>();
				paramMap.put("singer_id", singer.getId());
				paramMap.put("title", album.getTitleName());
				paramMap.put("release_date", album.getReleaseDate());
				insertSingerAlbum.updateByNamedParam(paramMap);
			}
		}
		insertSingerAlbum.flush();

	}

}
