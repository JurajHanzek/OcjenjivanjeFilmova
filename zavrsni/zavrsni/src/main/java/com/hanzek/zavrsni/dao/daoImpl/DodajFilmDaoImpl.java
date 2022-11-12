package com.hanzek.zavrsni.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.dao.DodajFilmDao;

@Component
public class DodajFilmDaoImpl implements DodajFilmDao {

	@Autowired
	public JdbcTemplate iJdbcTemplate;

	@Override
	@Transactional
	public void unesi(Movie movie) {

		String sql1 = "SELECT MAX(idMovie) FROM movie;";
		Integer id = iJdbcTemplate.queryForObject(sql1, Integer.class);
		id = id + 1;
		String sql3 = "INSERT INTO movie(idMovie, title,releaseyear,synopsis,trailerUrl,durationMin,directorId,rated,image,idgenre,moviestudioid)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		iJdbcTemplate.update(sql3, id, movie.getTitle(), movie.getReleaseyear(), movie.getSynopsis(),
				movie.getTrailerUrl(), movie.getDurationMin(), movie.getDirectorId(), movie.getRated(),
				movie.getImage(), movie.getIdgenre(), movie.getMovieStudioid());
	}

}
