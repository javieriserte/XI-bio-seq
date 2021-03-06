package org.jiserte.bioseq.orf.seqsource;

import java.io.BufferedReader;
import java.util.List;

import org.jiserte.bioformats.fastaIO.FastaMultipleReader;
import pair.Pair;

public class FastaSequenceSource extends SequenceSource {

	public FastaSequenceSource(BufferedReader in) {
		super(in);
	}

	@Override
	public List<Pair<String, String>> getSequences() {

		FastaMultipleReader mrf; 

		mrf = new FastaMultipleReader();
					
		return mrf.readBuffer(in);
	}

}
