package com.dadjokegenerator.training;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JokeRequestServiceTest {
    @Test
    public void testGetJoke() {
	JokeRequestService jokeRequestService = new JokeRequestService();

	List<String> result = jokeRequestService.getJokesByPage(1);
	Assert.assertEquals(result.size(), 20);

	result = jokeRequestService.getJokesByPage(100);
	Assert.assertEquals(result.size(), 0);
    }
}

