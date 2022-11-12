package com.hanzek.zavrsni.service.serviceImpl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hanzek.zavrsni.beans.Movie;
import com.hanzek.zavrsni.beans.MovieData;
import com.hanzek.zavrsni.dao.DodajFilmDao;
import com.hanzek.zavrsni.service.DodajFilmService;

@Component
public class DodajFilmServiceImpl implements DodajFilmService {
	
	String apiUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=5e203a2d&t=";

	@Autowired
	DodajFilmDao iDodajFilmDao;
	
	@Override
	public void add(String ur) {
		Movie movie = new Movie();
		HttpResponse<String> response = null;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://www.omdbapi.com/?i="+ur+"&apikey=5e203a2d&t="))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JSONObject myjson = new JSONObject(response.body());
		movie.setTitle(myjson.getString("Title"));
		movie.setReleaseyear(myjson.getString("Released"));
		movie.setSynopsis(myjson.getString("Plot"));
		movie.setTrailerUrl("https://www.youtube.com/embed/6ZfuNTqbHE8");
		movie.setDurationMin(Integer.parseInt(myjson.getString("Runtime").substring(0, 3)));
		movie.setRated(myjson.getString("Rated"));
		movie.setImage(myjson.getString("Poster"));
		movie.setDirectorId(11l);
		movie.setMovieStudioid(8l);
//		System.out.println(response.body());
		iDodajFilmDao.unesi(movie);
	}

	@Override
	public List<MovieData> searchByTitle(String title) {
		HttpResponse<String> response = null;
		title = title.replaceAll(" ", "%20");
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://data-imdb1.p.rapidapi.com/movie/imdb_id/byTitle/" + title + "/"))
				.header("x-rapidapi-key", "9d040e771bmsh104e4353f4f6831p132381jsn2e84ba6055e5")
				.header("x-rapidapi-host", "imdb8.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// System.out.println(response.body());

		List<MovieData> skup = new ArrayList<>();

		JSONObject myjson = new JSONObject(response.body());
		JSONArray the_json_array = myjson.getJSONArray("Result");
		int size = the_json_array.length();
		if (size > 10) {
			size = 10;
		}
		for (int i = 0; i < size; i++) {
			skup.add(getData(the_json_array.getJSONObject(i).getString("imdb_id"),
					the_json_array.getJSONObject(i).getString("title")));
		}

		return skup;
	}

	@Override
	public List<MovieData> searchByYearGenre(String year, String genre) {
		String gen = genrefix(genre);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://data-imdb1.p.rapidapi.com/movie/byYear/" + year + "/byGen/" + gen + "/"))
				.header("x-rapidapi-key", "9d040e771bmsh104e4353f4f6831p132381jsn2e84ba6055e5")
				.header("x-rapidapi-host", "data-imdb1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Movies 2000--Drama
		List<MovieData> skup = new ArrayList<>();

		JSONObject myjson = new JSONObject(response.body());
		JSONArray the_json_array = myjson.getJSONArray("Movies " + year + "--" + gen);
		int size = the_json_array.length();
		if (size > 10) {
			size = 10;
		}
		for (int i = 0; i < size; i++) {
			skup.add(getData(the_json_array.getJSONObject(i).getString("imdb_id"),
					the_json_array.getJSONObject(i).getString("title")));
		}
		return skup;
	}

	@Override
	public List<MovieData> searchByYear(String year) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://data-imdb1.p.rapidapi.com/movie/byYear/" + year + "/"))
				.header("x-rapidapi-key", "9d040e771bmsh104e4353f4f6831p132381jsn2e84ba6055e5")
				.header("x-rapidapi-host", "data-imdb1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<MovieData> skup = new ArrayList<>();

		JSONObject myjson = new JSONObject(response.body());
		JSONArray the_json_array = myjson.getJSONArray("Movies " + year);
		int size = the_json_array.length();
		if (size > 10) {
			size = 10;
		}
		for (int i = 0; i < size; i++) {
			skup.add(getData(the_json_array.getJSONObject(i).getString("imdb_id"),
					the_json_array.getJSONObject(i).getString("title")));
		}
		return skup;
	}

	@Override
	public List<MovieData> searchByGenre(String genre) {
		String gen = genrefix(genre);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://data-imdb1.p.rapidapi.com/movie/byGen/" + gen + "/"))
				.header("x-rapidapi-key", "9d040e771bmsh104e4353f4f6831p132381jsn2e84ba6055e5")
				.header("x-rapidapi-host", "data-imdb1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<MovieData> skup = new ArrayList<>();

		JSONObject myjson = new JSONObject(response.body());
		JSONArray the_json_array = myjson.getJSONArray("Movies " + gen);
		int size = the_json_array.length();
		if (size > 10) {
			size = 10;
		}
		for (int i = 0; i < size; i++) {
			skup.add(getData(the_json_array.getJSONObject(i).getString("imdb_id"),
					the_json_array.getJSONObject(i).getString("title")));
		}
		return skup;
	}

	public String genrefix(String x) {
		String y = "";
		x = x.toLowerCase();
		if (x.contains("akcija")) {
			y = "action";
		} else if (x.contains("komedija")) {
			y = "comedy";
		} else if (x.contains("drama")) {
			y = "drama";
		} else if (x.contains("fantazija")) {
			y = "fantasy";
		} else if (x.contains("horror")) {
			y = "horror";
		} else if (x.contains("triler")) {
			y = "thriller";
		} else if (x.contains("romant")) {
			y = "Romance";
		} else if (x.contains("mist")) {
			y = "mystery";
		} else {
			y = "Action";
		}

		return y;
	}

	public MovieData getData(String id, String name) {
		MovieData dat = new MovieData();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://data-imdb1.p.rapidapi.com/movie/id/" + id + "/"))
				.header("x-rapidapi-key", "9d040e771bmsh104e4353f4f6831p132381jsn2e84ba6055e5")
				.header("x-rapidapi-host", "data-imdb1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println(response.body());
		JSONObject myjson = new JSONObject(response.body());
		dat.setTitle(myjson.getJSONObject(name).getString("title"));
		dat.setIdImdb(myjson.getJSONObject(name).getString("imdb_id"));
		dat.setGenre(myjson.getJSONObject(name).getString("plot"));
		dat.setYear(myjson.getJSONObject(name).getString("image_url"));
		return dat;
	}

}
