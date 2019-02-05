package com.dadjokegenerator.training;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dadjokegenerator.entities.MarkovChain;

public class MarkovChainTraningServiceTest {

    @Test
    public void testTraining() {
	MarkovChain markovChain = new MarkovChain();
	MarkovChainTrainingService trainingService = new MarkovChainTrainingService();
	List<String> input = Arrays.asList("This is a unit test.",
		"This unit test is for markov chain training service.",
		"This unit test makes sure that I created the correct markov chain based on input."
	);

	trainingService.train(markovChain, input);

	Map<String, List<String>> words = markovChain.getWords();
	Assert.assertEquals(words.size(), 19);

	Assert.assertTrue(words.containsKey(MarkovChain.Start));
	Assert.assertEquals(words.get(MarkovChain.Start), Arrays.asList("This", "This", "This"));

	Assert.assertTrue(words.containsKey("This"));
	Assert.assertEquals(words.get("This"), Arrays.asList("is", "unit", "unit"));

	Assert.assertTrue(words.containsKey("is"));
	Assert.assertEquals(words.get("is"), Arrays.asList("a", "for"));

    }
}
