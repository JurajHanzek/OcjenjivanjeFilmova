package com.hanzek.zavrsni.dao.daoImpl;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Director;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieStudio;
import com.hanzek.zavrsni.beans.UserRating;
import com.hanzek.zavrsni.dao.MovieDao;

@Component
public class MovieDaoImpl implements MovieDao{
	private final static Logger LOGGER = Logger.getLogger(MovieDaoImpl.class.getName());
	@Autowired
	public JdbcTemplate iJdbcTemplate;
	
	@Override
	public Movie getMovieByID(Long id) {
		String sql ="SELECT * FROM movie WHERE idMovie = ?";
		  try {
				return (Movie) iJdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Movie.class),id);
	        } catch (EmptyResultDataAccessException e) {
	        	LOGGER.log(Level.INFO,"Following query execution failed: ");
	            return null;
	        }
	}

	@Override
	public List<Actor> findActors(Long id) {
		String sql ="SELECT *\r\n"
				+ "FROM actors \r\n"
				+ "INNER JOIN actor_movie on actors.idActors = actor_movie.idactor\r\n"
				+ "WHERE actor_movie.idmovie=?";
		return iJdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Actor.class),id);
	}

	@Override
	public Director findDirector(Long id) {
		String sql ="SELECT * FROM directors WHERE idDirector = ?";
		return (Director) iJdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Director.class),id);
	}

	@Override
	public MovieStudio findStudio(Long id) {
		String sql ="SELECT * FROM movie_studio WHERE idMovie_studio = ?";
		return (MovieStudio) iJdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(MovieStudio.class),id);
	}

	@Override
	public void eraseMovie(Long id) {
		String sql ="DELETE FROM movie WHERE idMovie = ?";
		iJdbcTemplate.update(sql,id);
		String sql2 ="DELETE FROM actor_movie WHERE idmovie = ?";
		iJdbcTemplate.update(sql2,id);
	}

	@Override
	public void updateMovie(Movie movie) {
		String sql2 ="UPDATE movie set title= ?,releaseyear= ?,rated= ?,trailerUrl= ?,durationMin= ? where idMovie = ?";
		iJdbcTemplate.update(sql2,movie.getTitle(),movie.getReleaseyear(),movie.getRated(),movie.getTrailerUrl(),movie.getDurationMin(),movie.getIdMovie());
	}

	@Override
	public void rateMovie(UserRating ur) {
		String sql1 ="SELECT MAX(idRating) FROM user_rating;";
		Integer id= iJdbcTemplate.queryForObject(sql1,Integer.class);
		id=id+1;
		String sql2 = "INSERT INTO user_rating(idRating, komentar, rating,idMovie,idUser) VALUES(?,?,?,?,?)" ;
  		iJdbcTemplate.update(sql2, id, ur.getKomentar(),ur.getRating(),ur.getIdMovie(),ur.getIdUser());
	}
}


