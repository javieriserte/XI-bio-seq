package org.jiserte.bioseq.orf.seqsource;

import java.io.BufferedReader;
import java.util.List;

import pair.Pair;

public abstract class SequenceSource {

	BufferedReader in = null;
	
	public SequenceSource(BufferedReader in) {
		
		this.in = in;
		
	}
	
	public abstract List<Pair<String,String>> getSequences();
	
}
