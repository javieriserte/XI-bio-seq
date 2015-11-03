package org.jiserte.bioseq.gapstripper;

public abstract class SequenceWeighter {

	public abstract double getWeight(String sequenceIdentifier);
	
}
