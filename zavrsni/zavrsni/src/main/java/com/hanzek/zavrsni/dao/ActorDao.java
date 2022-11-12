package com.hanzek.zavrsni.dao;

import java.util.List;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.CharacterAc;
import com.hanzek.zavrsni.beans.Movie;

public interface ActorDao {

	Actor findMovieByID(Long id);

	List<Movie> getMoviesByActorID(Long id);

	List<CharacterAc> getCharactersByActorID(Long id);

}
