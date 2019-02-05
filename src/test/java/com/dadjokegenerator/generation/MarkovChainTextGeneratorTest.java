package com.dadjokegenerator.generation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dadjokegenerator.entities.MarkovChain;

public class MarkovChainTextGeneratorTest {

    @Test
    public void testTextGeneration() {
	MarkovChain markovChain = new MarkovChain();
	markovChain.addStartWord("This");
	markovChain.addEntry("This", "is");
	markovChain.addEntry("is", "a");
	markovChain.addEntry("a", "test.");

	MarkovChainTextGenerator generator = new MarkovChainTextGenerator();
	String result = generator.generate(markovChain);

	Assert.assertEquals(result, "This is a test.");
    }

}
