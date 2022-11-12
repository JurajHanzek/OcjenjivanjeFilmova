package com.hanzek.zavrsni.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.CharacterAc;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.dao.ActorDao;
import com.hanzek.zavrsni.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	public ActorDao iActorDao;
	
	@Override
	public Actor findMovieByID(Long id) {
		return iActorDao.findMovieByID(id);
	}

	@Override
	public List<Movie> getMoviesByActorID(Long id) {
		return iActorDao.getMoviesByActorID(id);
	}

	@Override
	public List<CharacterAc> getCharactersByActorID(Long id) {
		return iActorDao.getCharactersByActorID(id);
	}

}
