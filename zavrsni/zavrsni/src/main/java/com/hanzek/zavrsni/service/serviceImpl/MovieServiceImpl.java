package com.hanzek.zavrsni.service.serviceImpl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Director;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieStudio;
import com.hanzek.zavrsni.beans.Ocjene;
import com.hanzek.zavrsni.beans.UserRating;
import com.hanzek.zavrsni.dao.HomeDao;
import com.hanzek.zavrsni.dao.MovieDao;
import com.hanzek.zavrsni.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDao iMovieDao;
	
	@Autowired
	private HomeDao iHomeDao;

	@Autowired
	private HomeServiceImpl iHomeServiceImpl;
	
	@Override
	public Movie findMovieByID(Long id) {
		return iMovieDao.getMovieByID(id);
	}

	@Override
	public List<Actor> findActors(Long id) {
		return iMovieDao.findActors(id);
		
	}

	@Override
	public Director findDirector(Long id) {
		return iMovieDao.findDirector(id);
	}

	@Override
	public MovieStudio findStudio(Long id) {
		return iMovieDao.findStudio(id);
		}

	@Override
	public Ocjene dohvatiOcjenu(Long id) {
			Ocjene ocjena = new Ocjene();
			Movie temp = iMovieDao.getMovieByID(id);
			JSONObject jsonObj = new JSONObject();
			jsonObj = iHomeServiceImpl.getMovieRating(temp.getTitle());
			ocjena.setIdMovie(id);
			ocjena.setImdbRating(Double.parseDouble(jsonObj.getString("imdb")));
			ocjena.setRottenRating(Double.parseDouble(jsonObj.getString("rotten")) / 10);
			ocjena.setMetacriticRating(Double.parseDouble(jsonObj.getString("metacritic")) / 10);
			ocjena.setRating(iHomeDao.dohvatiOcjenu(id));
		return ocjena;

	}

	@Override
	public void eraseMovie(Long id) {
		 iMovieDao.eraseMovie(id);
	}

	@Override
	public void updateMovie(Movie movie) {
		 iMovieDao.updateMovie(movie);
	}

	@Override
	public void rateMovie(UserRating ur) {
		iMovieDao.rateMovie(ur);
		
	}
	
}
