package com.dadjokegenerator.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The representation of Markov Chain
 *
 */
public class MarkovChain {
    public static final String Start = "_start";

    /**
     * The key of the map represents every unique word in the input, value of
     * the map represents possible words following the key. The more times a
     * word appear in the value list, the more likely that it will be picked up
     * during generation process. The start word is treated as a special case
     * with key as "_start"
     */
    private Map<String, List<String>> words;

    public MarkovChain() {
	words = new HashMap<>();
    }

    public void addEntry(String word, String nextWord) {
	words.putIfAbsent(word, new ArrayList<>());
	words.get(word).add(nextWord);
    }

    public void addStartWord(String startWord) {
	addEntry(Start, startWord);
    }

    public String getRandomNextWord(String word, Random random) {
	List<String> nextWords = words.get(word);
	if (nextWords == null || nextWords.isEmpty()) {
	    return null;
	} else if (nextWords.size() == 1) {
	    return nextWords.get(0);
	} else {
	    int index = random.nextInt(nextWords.size());
	    return nextWords.get(index);
	}
    }

    public String getRandomStartWord(Random random) {
	return getRandomNextWord(Start, random);
    }


    public Map<String, List<String>> getWords() {
	return words;
    }

    public void setWords(Map<String, List<String>> words) {
	this.words = words;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((words == null) ? 0 : words.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof MarkovChain)) {
	    return false;
	}
	MarkovChain other = (MarkovChain) obj;
	if (words == null) {
	    if (other.words != null) {
		return false;
	    }
	} else if (!words.equals(other.words)) {
	    return false;
	}
	return true;
    }

}
