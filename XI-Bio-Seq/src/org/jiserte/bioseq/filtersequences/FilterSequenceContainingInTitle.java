package org.jiserte.bioseq.filtersequences;

import pair.Pair;

public class FilterSequenceContainingInTitle extends FilterSequence {

	private CharSequence text;
	
	
	public FilterSequenceContainingInTitle(CharSequence text) {
		super();
		this.text = text;
	}

	@Override
	public boolean filter(Pair<String, String> sequence) {
		
		return sequence.getFirst().contains(this.text);
		
	}

}
