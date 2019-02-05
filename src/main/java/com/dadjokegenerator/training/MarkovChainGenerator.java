package com.dadjokegenerator.training;

import java.util.List;

import com.dadjokegenerator.entities.MarkovChain;

/**
 * Creating and training Markov Chain and save it as a json file in the
 * corresponding target resource folder
 *
 */
public class MarkovChainGenerator {
    public static void main(String[] args) {
	System.out.println("Start Getting all jokes through API...");
	JokeRequestService jokeRequestService = new JokeRequestService();
	List<String> jokes = jokeRequestService.getJokes();

	System.out.println("Finished Getting all jokes. Start training Markov Chain...");
	MarkovChain markovChain = new MarkovChain();
	MarkovChainTrainingService markovChainTraningService = new MarkovChainTrainingService();
	markovChainTraningService.train(markovChain, jokes);

	System.out.println("Finished training Markov Chain. Writing result to MarkovChain.json file");
	MarkovChainModelService markovChainModelService = new MarkovChainModelService();
	markovChainModelService.serialize(markovChain, "MarkovChain.json");
	System.out.println("Finished writing result to MarkovChain.json file");

    }

}
