package org.jiserte.bioseq.orf.analysis;

import java.util.List;

import org.jiserte.bioseq.orf.MarkedOrf;
import org.jiserte.bioseq.orf.replication.Replicate;

public class LargestOrf extends ExtractSequences {

	public LargestOrf(Replicate replicator, int minSize, Integer[] frames) {
		
		super(replicator, minSize, frames);
		
	}

	@Override
	protected void attempToKeepLargest(List<MarkedOrf> orfs) {

		MarkedOrf largestOrf = new MarkedOrf();
		
		int largestOrfSize =0;
		
		for (MarkedOrf currentOrf : orfs) {
			
			int length = currentOrf.getSequence().length();
			
      if (length > largestOrfSize) {
				
				largestOrf = currentOrf;
				
				largestOrfSize = length; 
				
			}
			
		}
		
		orfs.clear();
		
		orfs.add(largestOrf);
		
	}

}
