package com.dadjokegenerator.training;

import java.util.List;

import com.dadjokegenerator.entities.MarkovChain;

/**
 * The service for training Markov Chain
 *
 */
public class MarkovChainTrainingService {

    public void train(MarkovChain markovChain, List<String> input) {
	for (String sentence : input) {
	    String[] words = sentence.split(" ");

	    for (int i = 0; i < words.length - 1; i++) {
		if (i == 0) {
		    markovChain.addStartWord(words[i]);
		}

		markovChain.addEntry(words[i], words[i + 1]);

	    }
	}

    }

}
