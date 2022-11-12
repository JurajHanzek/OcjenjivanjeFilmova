package com.hanzek.zavrsni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.CharacterAc;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.service.ActorService;

@CrossOrigin("*")
@RestController
public class ActorController {

	@Autowired
	ActorService iActorService;
	
	@GetMapping("/actor/{id}")
	public ResponseEntity<Actor> getActorByID(@PathVariable Long id) {
		Actor actor= iActorService.findMovieByID(id);
		return new ResponseEntity<>(actor,HttpStatus.OK);
	}
	
	@GetMapping("/actor/movies/{id}")
	public ResponseEntity<List<Movie>> getMoviesByActorID(@PathVariable Long id) {
		List<Movie> movies= iActorService.getMoviesByActorID(id);
		return new ResponseEntity<>(movies,HttpStatus.OK);
	}
	
	@GetMapping("/actor/character/{id}")
	public ResponseEntity<List<CharacterAc>> getCharactersByActorID(@PathVariable Long id) {
		List<CharacterAc> characters= iActorService.getCharactersByActorID(id);
		return new ResponseEntity<>(characters,HttpStatus.OK);
	}
	
	
	
}
