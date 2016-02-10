package org.jiserte.bioseq.orf.replication;

public class ReplicateLinear extends Replicate {

	@Override
	public Replicon attempToReplicateSequence(String sequence, int unitLength, int[] ATG, int[] stop) {
		// Do nothing
		return new Replicon(ATG, stop, sequence);
		
	}
  @Override
  public boolean isCircular() {
    return false;
  }

}
