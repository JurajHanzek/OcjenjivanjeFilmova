package com.hanzek.zavrsni.service;

import java.util.List;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieRating;
import com.hanzek.zavrsni.beans.Ocjene;
import com.hanzek.zavrsni.user.User;

public interface HomeService {

	List<Movie> test();

	List<Actor> glumci();

	List<MovieRating> dohvatiRejting();

	List<Ocjene> dohvatiOcjene();

	void save(User user);

	
}
