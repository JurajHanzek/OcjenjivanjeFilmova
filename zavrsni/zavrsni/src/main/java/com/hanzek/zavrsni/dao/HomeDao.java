package com.hanzek.zavrsni.dao;

import java.util.List;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieRating;
import com.hanzek.zavrsni.user.User;

public interface HomeDao {

	List<Movie> dohvatiFilm();

	List<Actor> dohvatiGlumce();

	List<MovieRating> dohvatiRejting();

	List<Long> dohvatiId();

	Double dohvatiOcjenu(Long var);

	int insertUser(User user);

}
