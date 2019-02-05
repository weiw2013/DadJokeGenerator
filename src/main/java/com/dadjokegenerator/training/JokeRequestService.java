package com.dadjokegenerator.training;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

/**
 * The service for getting all jokes from icanhazdadjoke API
 *
 */
public class JokeRequestService {
    private static final String Url = "https://icanhazdadjoke.com/search?page=";
    
    public List<String> getJokes() {
	List<String> jokes = new ArrayList<>();
	int pageNumber = 1;

	while (true) {
	    List<String> jokesPerPage = getJokesByPage(pageNumber);
	    if (jokesPerPage.size() == 0) {
		break;
	    }

	    jokes.addAll(jokesPerPage);
	    pageNumber++;

	}

	return jokes;

    }

    public List<String> getJokesByPage(int pageNumber) {
	List<String> jokes = new ArrayList<>();
	try {
	    HttpResponse<JsonNode> response = Unirest.get(Url + pageNumber)
		    .header("accept", "application/json").asJson();

	    if (response.getStatus() == 200) {
		JSONObject body = response.getBody().getObject();
		JSONArray currentPageJokes = body.getJSONArray("results");

		for (int i = 0; i < currentPageJokes.length(); i++) {
		    jokes.add(currentPageJokes.getJSONObject(i).getString("joke"));
		}

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new RuntimeException(e);
	}

	return jokes;
    }
    
    

}
