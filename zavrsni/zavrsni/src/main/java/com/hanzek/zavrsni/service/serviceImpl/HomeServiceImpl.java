package com.hanzek.zavrsni.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hanzek.zavrsni.beans.Actor;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieRating;
import com.hanzek.zavrsni.beans.Ocjene;
import com.hanzek.zavrsni.config.SecurityConfiguration;
import com.hanzek.zavrsni.dao.HomeDao;
import com.hanzek.zavrsni.dao.MovieDao;
import com.hanzek.zavrsni.service.HomeService;
import com.hanzek.zavrsni.user.User;

@Service
public class HomeServiceImpl implements HomeService {

	String apiUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=5e203a2d&t=";

	@Autowired
	private HomeDao iHomeDao;

	@Autowired
	private MovieDao iMovieDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Movie> test() {
		List<Movie> movie = new ArrayList<Movie>();
		movie = iHomeDao.dohvatiFilm();
		return movie;
	}

	@Override
	public List<Actor> glumci() {
		List<Actor> actors = new ArrayList<Actor>();
		actors = iHomeDao.dohvatiGlumce();
		return actors;
	}

	@Override
	public List<Ocjene> dohvatiOcjene() {
		List<Long> ids = new ArrayList<>();
		ids = iHomeDao.dohvatiId();
		List<Ocjene> ocjene = new ArrayList<>();
		for (Long var : ids) {
			Ocjene ocjena = new Ocjene();
			Movie temp = iMovieDao.getMovieByID(var);
			JSONObject jsonObj = new JSONObject();
			jsonObj = getMovieRating(temp.getTitle());
			ocjena.setIdMovie(var);
			ocjena.setImdbRating(Double.parseDouble(jsonObj.getString("imdb")));
			ocjena.setRottenRating(Double.parseDouble(jsonObj.getString("rotten")) / 10);
			ocjena.setMetacriticRating(Double.parseDouble(jsonObj.getString("metacritic")) / 10);
			ocjena.setRating(iHomeDao.dohvatiOcjenu(var));
			ocjene.add(ocjena);
		}

		return ocjene;
	}

	@Override
	public List<MovieRating> dohvatiRejting() {
		List<MovieRating> rating = new ArrayList<MovieRating>();
		rating = iHomeDao.dohvatiRejting();
		for (MovieRating rating_ : rating) {
			Movie temp = iMovieDao.getMovieByID(rating_.getIdMovie());
			if(temp !=null) {
			JSONObject jsonObj = new JSONObject();
			jsonObj = getMovieRating(temp.getTitle());
			rating_.setImdbRating(Double.parseDouble(jsonObj.getString("imdb")));
			rating_.setRottenRating(Double.parseDouble(jsonObj.getString("rotten")) / 10);
			rating_.setMetacriticRating(Double.parseDouble(jsonObj.getString("metacritic")) / 10);}
		}

		return rating;
	}

	public JSONObject getMovieRating(String title) {

		try {
			RestTemplate template = new RestTemplate();

			ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title + "", ObjectNode.class);
			ObjectNode json = response.getBody();
			final JsonNode arrNode = new ObjectMapper().readTree(json.toString()).get("Ratings");
			JSONObject jsonObj = new JSONObject();
			if (arrNode.isArray()) {
				String temp = "";
				for (final JsonNode objNode : arrNode) {
					if (objNode.get("Source").toString().contains("Internet")) {
						temp = objNode.get("Value").toString();
						temp = temp.substring(temp.indexOf('"') + 1, temp.indexOf("/"));
						jsonObj.put("imdb", temp);
					} else if (objNode.get("Source").toString().contains("Rotten")) {
						temp = objNode.get("Value").toString();
						temp = temp.substring(temp.indexOf('"') + 1, temp.indexOf("%"));
						jsonObj.put("rotten", temp);
					} else if (objNode.get("Source").toString().contains("Metacritic")) {
						temp = objNode.get("Value").toString();
						temp = temp.substring(temp.indexOf('"') + 1, temp.indexOf("/"));
						jsonObj.put("metacritic", temp);
					}
				}
			}

			return jsonObj;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void save(User user) {
		System.out.println(user.getFirstName()+" --- "+user.getLastName());
		Integer temp=0;
		String pass=passwordEncoder.encode(user.getPassword());
		user.setPassword(pass);
		temp=iHomeDao.insertUser(user);
		System.out.println(temp.toString());
	}

}
