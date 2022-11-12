package com.hanzek.zavrsni.service;

import java.util.List;

import com.hanzek.zavrsni.beans.MovieData;

public interface DodajFilmService {



	List<MovieData> searchByTitle(String title);

	List<MovieData> searchByYearGenre(String year, String genre);

	List<MovieData> searchByYear(String year);

	List<MovieData> searchByGenre(String genre);

	void add(String ur);

}
