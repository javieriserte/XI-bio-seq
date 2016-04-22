package org.jiserte.bioseq.orf.analysis;

import org.jiserte.bioseq.orf.MarkedOrf;
import org.jiserte.bioseq.orf.replication.Replicate;

public class ExtractSequencesWithPositions extends ExtractSequences {

  public ExtractSequencesWithPositions(Replicate replicator, int minSize,
      Integer[] frames) {
    super(replicator, minSize, frames);
  }
  
  protected String getDescriptionString(String baseDescription, int width, int orderNumber, MarkedOrf orf) {
    
    StringBuilder desc = new StringBuilder();
    desc.append(">" + baseDescription + "ORF:");
    desc.append( String.format("%0" + width + "d", orderNumber));
    desc.append("|["+orf.getAtg()+"-"+orf.getStop()+"]");
   return desc.toString();
  }

}
