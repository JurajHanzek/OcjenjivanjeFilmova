package com.hanzek.zavrsni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieRating;
import com.hanzek.zavrsni.beans.Ocjene;
import com.hanzek.zavrsni.service.HomeService;
import com.hanzek.zavrsni.user.User;

@CrossOrigin("*")
@RestController
public class HomeController {

	@Autowired
	private HomeService iHomeService;

	@PostMapping("/save-user")
	void addUser(@RequestBody User user) {
		iHomeService.save(user);
	}

	@GetMapping("/movie/all")
	public List<Movie> testic() {
		return iHomeService.test();
	}

	@GetMapping("/actor/all")
	public List<Actor> glumci() {
		return iHomeService.glumci();
	}

	@GetMapping("/movie/rating")
	public ResponseEntity<List<MovieRating>> dohvatiRejting() {
		List<MovieRating> ratings = iHomeService.dohvatiRejting();
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}

	@GetMapping("/movie/ocjene")
	public ResponseEntity<List<Ocjene>> dohvatiOcjene() {
		List<Ocjene> ocj = iHomeService.dohvatiOcjene();
		return new ResponseEntity<>(ocj, HttpStatus.OK);
	}
}
