package com.hanzek.zavrsni.service;

import java.util.List;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Director;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieStudio;
import com.hanzek.zavrsni.beans.Ocjene;
import com.hanzek.zavrsni.beans.UserRating;

public interface MovieService {

	Movie findMovieByID(Long id);

	List<Actor> findActors(Long id);

	Director findDirector(Long id);

	MovieStudio findStudio(Long id);

	Ocjene dohvatiOcjenu(Long id);

	void eraseMovie(Long id);

	void updateMovie(Movie movie);

	void rateMovie(UserRating ur);

}
