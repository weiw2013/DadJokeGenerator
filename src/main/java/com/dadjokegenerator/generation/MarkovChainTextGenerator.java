package com.dadjokegenerator.generation;

import java.util.Random;

import com.dadjokegenerator.entities.MarkovChain;

/**
 * The service for generating new text with trained Markov Chain
 *
 */
public class MarkovChainTextGenerator {
    private Random random;


    public MarkovChainTextGenerator() {
	this.random = new Random();
    }

    public String generate(MarkovChain markovChain) {
	StringBuilder builder = new StringBuilder();
	String prev = null;
	int i = 0;
	while (true) {
	    String word;
	    if (i == 0) {
		word = markovChain.getRandomStartWord(random);
	    } else {
		word = markovChain.getRandomNextWord(prev, random);
	    }

	    if (word == null) {
		break;
	    }

	    builder.append(word).append(" ");
	    prev = word;
	    i++;
	}

	return builder.deleteCharAt(builder.length() - 1).toString();
    }

}
