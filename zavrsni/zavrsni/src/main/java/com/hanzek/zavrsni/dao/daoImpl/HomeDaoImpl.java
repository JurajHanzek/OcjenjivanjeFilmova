package com.hanzek.zavrsni.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieRating;
import com.hanzek.zavrsni.dao.HomeDao;
import com.hanzek.zavrsni.user.User;

@Component
public class HomeDaoImpl implements HomeDao{

	
	@Autowired
	public JdbcTemplate iJdbcTemplate;
	
	@Override
	public List<Movie> dohvatiFilm() {
		String sql ="SELECT * FROM movie";
		return iJdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Movie.class));
	}

	@Override
	public List<Actor> dohvatiGlumce() {
		String sql ="SELECT * FROM actors";
		return iJdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Actor.class));
	}

	@Override
	public List<MovieRating> dohvatiRejting() {
		String sql ="SELECT * FROM user_rating";
		return iJdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(MovieRating.class));
	}

	@Override
	public List<Long> dohvatiId() {
		String sql ="SELECT idMovie FROM movie";
		return iJdbcTemplate.queryForList(sql,(Long.class));
	}

	@Override
	public Double dohvatiOcjenu(Long var) {
		String sql ="SELECT AVG(rating) \r\n"
				+ "FROM zavrsnidb.user_rating\r\n"
				+ "WHERE idMovie=?;";
		Double x = iJdbcTemplate.queryForObject(sql,(Double.class),var);
		if (x == null) {
			return 0.00;
		} else {
			return x;
		}
	}
	
	  @Override
	   @Transactional 
	   public int insertUser(User user) {
	  		String sql1 ="SELECT MAX(id) FROM user;";
			Integer id= iJdbcTemplate.queryForObject(sql1,Integer.class);
			id=id+1;
	  		String sql2 = "INSERT INTO user_authority(user_id, authority_id) VALUES(?,?)" ;
	  		iJdbcTemplate.update(sql2, id, 2);
			
			String sql3 = "INSERT INTO user(id, username,password,first_name,last_name) VALUES(?,?,?,?,?)" ;
	      return iJdbcTemplate.update(sql3, id, user.getUsername(),user.getPassword(),user.getFirstName(),user.getLastName());
	   }
	
}
