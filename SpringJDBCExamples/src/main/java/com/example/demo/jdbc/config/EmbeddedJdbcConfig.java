package com.example.demo.jdbc.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.example.demo.jdbc.dao.SingerDao;
import com.example.demo.jdbc.dao.impl.JdbcSingerDao;

//@Configuration
public class EmbeddedJdbcConfig {
	private static Logger logger = LoggerFactory.getLogger(EmbeddedJdbcConfig.class);

	@Bean
	public DataSource dataSource() {
		try {
			EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
			return dbBuilder.setType(EmbeddedDatabaseType.H2)
					.addScripts("classpath:db/h2/schema.sql", "classpath:db/h2/test-data.sql").build();
		} catch (Exception e) {
			logger.error("Embedded DataSource bean cannot be created!", e);
			return null;
		}
	}

	@Bean
	public SingerDao singerDao() {
		JdbcSingerDao dao = new JdbcSingerDao();
		dao.setDataSource(dataSource());
		return dao;
	}
}
