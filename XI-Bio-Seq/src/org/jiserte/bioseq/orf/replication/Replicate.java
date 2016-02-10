package org.jiserte.bioseq.orf.replication;

public abstract class Replicate {

	public abstract Replicon attempToReplicateSequence(String sequence, int unitLength, int[] ATG, int[] stop);
	
	public abstract boolean isCircular();
}
