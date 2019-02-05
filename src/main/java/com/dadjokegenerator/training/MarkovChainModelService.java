package com.dadjokegenerator.training;

import java.io.File;

import com.dadjokegenerator.entities.MarkovChain;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * The service for writing existing Markov Chain object to json file or read
 * json file back to Markov Chain object
 *
 */
public class MarkovChainModelService {
    private ObjectMapper mapper;
    private ObjectWriter writer;

    public MarkovChainModelService() {
	mapper = new ObjectMapper();
	writer = mapper.writer(new DefaultPrettyPrinter());
    }

    public void serialize(MarkovChain markovChain, String filename) {
	try {
	    writer.writeValue(new File(getPath(filename)), markovChain);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new RuntimeException(e);
	}
    }

    public MarkovChain deserialize(String filename) {
	try {
	    return mapper.readValue(new File(getPath(filename)), MarkovChain.class);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new RuntimeException(e);
	}
    }

    private String getPath(String filename) {
	return getClass().getResource(filename).getPath();
    }
}
