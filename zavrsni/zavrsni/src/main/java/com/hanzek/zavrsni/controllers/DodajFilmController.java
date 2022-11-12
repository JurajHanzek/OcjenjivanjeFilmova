package com.hanzek.zavrsni.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hanzek.zavrsni.beans.MovieData;
import com.hanzek.zavrsni.service.DodajFilmService;

@CrossOrigin("*")
@RestController
public class DodajFilmController {

	@Autowired
	DodajFilmService iDodajFilmService;

	@GetMapping("movie/search/{title}/{year}/{genre}")
	public List<MovieData> pretraga(@PathVariable String title, @PathVariable String year, @PathVariable String genre) {
		List<MovieData> temp = new ArrayList<>();

		if (!title.contains("-")) {
			temp = iDodajFilmService.searchByTitle(title);
		} else if (!year.contains("-") && !genre.contains("-")) {
			temp = iDodajFilmService.searchByYearGenre(year, genre);
		} else if (!year.contains("-")) {
			temp = iDodajFilmService.searchByYear(year);
		} else if (!genre.contains("-")) {
			temp = iDodajFilmService.searchByGenre(genre);
		}
		return temp;
	}
	
	@PostMapping("/movie/dodaj")
	void addRating(@RequestBody String id) {
		iDodajFilmService.add(id);
	}
}
