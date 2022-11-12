package com.hanzek.zavrsni.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.CharacterAc;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.dao.ActorDao;

@Component
public class ActorDaoImpl implements ActorDao {

	@Autowired
	public JdbcTemplate iJdbcTemplate;

	@Override
	public Actor findMovieByID(Long id) {
		String sql = "SELECT * FROM actors WHERE idActors = ?";
		Actor temp = new Actor();
		temp = (Actor) iJdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Actor.class), id);
		return temp;
	}

	@Override
	public List<Movie> getMoviesByActorID(Long id) {
		String sql = "SELECT *\r\n" + "		FROM movie \r\n"
				+ "		INNER JOIN actor_movie on movie.idmovie = actor_movie.idmovie\r\n"
				+ "		WHERE actor_movie.idactor=?";
		return iJdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class), id);
	}

	@Override
	public List<CharacterAc> getCharactersByActorID(Long id) {
		String sql = "SELECT characters.idCharacter,characters.name,characters.info,characters.idMovie\r\n"
				+ "			FROM characters \r\n"
				+ "			INNER JOIN actor_movie on characters.idcharacter = actor_movie.idcharacter\r\n"
				+ "			WHERE actor_movie.idactor=?";
		String sql2 = "SELECT idmovie\r\n" + "			FROM actor_movie \r\n"
				+ "			WHERE actor_movie.idCharacter=?";

		List<CharacterAc> listCh = new ArrayList<>();
		listCh = iJdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(CharacterAc.class), id);
		for (CharacterAc ch : listCh) {
			ch.setIdMovie(iJdbcTemplate.queryForObject(sql2, (Long.class), ch.getIdCharacter()));
		}

		return listCh;
	}

}
