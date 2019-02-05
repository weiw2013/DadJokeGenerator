package com.dadjokegenerator.training;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dadjokegenerator.entities.MarkovChain;

public class MarkovChainModelServiceTest {

    @Test
    public void testSerializationAndDeserialization() {
	MarkovChain markovChain = new MarkovChain();
	markovChain.addStartWord("this");
	markovChain.addStartWord("is");
	markovChain.addEntry("this", "is");
	markovChain.addEntry("is", "test");
	markovChain.addEntry("is", "a");

	String filename = "MarkovChainTest.json";
	MarkovChainModelService modelService = new MarkovChainModelService();
	modelService.serialize(markovChain, filename);

	MarkovChain readResult = modelService.deserialize(filename);
	Assert.assertEquals(markovChain, readResult);
    }
}
