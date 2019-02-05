package com.dadjokegenerator;

import com.dadjokegenerator.entities.MarkovChain;
import com.dadjokegenerator.generation.MarkovChainTextGenerator;
import com.dadjokegenerator.training.MarkovChainModelService;

import java.util.Scanner;

/**
 * The entry point for the joke generation app
 *
 */
public class DadJokeGeneratorApp {

    public static void main(String[] args) {
	System.out.println("Start Reading Existing Markov Chain...");

	MarkovChainModelService markovTrainCachingService = new MarkovChainModelService();
	MarkovChain markovChain = markovTrainCachingService.deserialize("MarkovChain.json");

	System.out.println("Finished Reading Markov Chain, Ready to generate jokes now.");
	System.out.println(simpleHelpMessage());

	MarkovChainTextGenerator markovChainTextGenerator = new MarkovChainTextGenerator();

	try (Scanner scanner = new Scanner(System.in)) {

	    while (true) {
		System.out.print(">");
		String input = scanner.nextLine().trim();

		if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
		    break;
		} else if (input.isEmpty()) {
		    String result = markovChainTextGenerator.generate(markovChain);
		    System.out.println(result);
		} else {
		    System.out.println(simpleHelpMessage());
		}
	    }

	}
    }

    private static String simpleHelpMessage() {
	return "Press [Enter] for generating a new joke. Type \"quit\" or \"exit\" to exit the app.";
    }
}
