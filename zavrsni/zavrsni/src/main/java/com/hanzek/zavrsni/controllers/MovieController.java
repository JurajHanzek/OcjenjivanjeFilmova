package com.hanzek.zavrsni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Director;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieStudio;
import com.hanzek.zavrsni.beans.Ocjene;
import com.hanzek.zavrsni.beans.UserRating;
import com.hanzek.zavrsni.service.MovieService;
import com.hanzek.zavrsni.user.User;

@CrossOrigin("*")
@RestController
public class MovieController {
	
	@Autowired
	private MovieService iMovieService;
	
	
	@GetMapping("/movie/{id}")
	public ResponseEntity<Movie> findMovieByID(@PathVariable Long id) {
		Movie movie= iMovieService.findMovieByID(id);
		return new ResponseEntity<>(movie,HttpStatus.OK);
	}
	
	@PostMapping("/movie/update")
	void addUser(@RequestBody Movie movie) {
		iMovieService.updateMovie(movie);
	}
	@Secured({"ROLE_USER" ,"ROLE_ADMIN"})
	@PostMapping("/movie/rate")
	void addRating(@RequestBody UserRating ur) {
		iMovieService.rateMovie(ur);
	}
	
	@GetMapping("/movie/erase/{id}")
	@Secured("ROLE_ADMIN")
	public void erase(@PathVariable Long id) {
		iMovieService.eraseMovie(id);
	}
	
	//Getta actore po filmu
	@GetMapping("/movie/actors/{id}")
	public ResponseEntity<List<Actor>> findMovieActors(@PathVariable Long id) {
		List<Actor> actors= iMovieService.findActors(id);
		return new ResponseEntity<>(actors,HttpStatus.OK);
	}
	
	@GetMapping("/movie/director/{id}")
	public ResponseEntity<Director> findMovieDirector(@PathVariable Long id) {
		Director director= iMovieService.findDirector(id);
		return new ResponseEntity<>(director,HttpStatus.OK);
	}
	
	@GetMapping("/movie/studio/{id}")
	public ResponseEntity<MovieStudio> findMovieStudio(@PathVariable Long id) {
		MovieStudio movieStudio= iMovieService.findStudio(id);
		return new ResponseEntity<>(movieStudio,HttpStatus.OK);
	}
	
	@GetMapping("/movie/ocjena/{id}")
	public ResponseEntity <Ocjene> dohvatiOcjenu(@PathVariable Long id) {
		Ocjene ocj= iMovieService.dohvatiOcjenu(id);
		return new ResponseEntity<>(ocj,HttpStatus.OK);
	}
}
