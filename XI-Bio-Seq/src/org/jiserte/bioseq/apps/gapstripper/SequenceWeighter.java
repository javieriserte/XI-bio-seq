package org.jiserte.bioseq.apps.gapstripper;

public abstract class SequenceWeighter {

	public abstract double getWeight(String sequenceIdentifier);
	
}
