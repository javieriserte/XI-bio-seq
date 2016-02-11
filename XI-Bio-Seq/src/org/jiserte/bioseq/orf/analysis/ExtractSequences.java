package org.jiserte.bioseq.orf.analysis;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.jiserte.bioseq.orf.OrfFinder;
import org.jiserte.bioseq.orf.replication.Replicate;

import pair.Pair;

public class ExtractSequences extends OrfAnalysis {

  public ExtractSequences(Replicate replicator, int minSize, Integer[] frames) {
    super();
    this.replicator = replicator;
    this.minSize = minSize;
    this.frames = frames;
  }

  @Override
  public void exportResults(PrintStream out, Pair<String, String> sequence) {

    List<Pair<List<Integer>, String>> order = getFrameIterateOrder(this.frames,
        sequence.getSecond());

    List<String> result = new ArrayList<String>();

    for (Pair<List<Integer>, String> pair : order) {

      Integer[] newarray = new Integer[pair.getFirst().size()];

      result.addAll(OrfFinder.allOrfsInThisStrand(pair.getSecond(), minSize,
          replicator, pair.getFirst().toArray(newarray)));

    }

    this.attempToKeepLargest(result);

    printoutSequences(out, sequence, result);

  }

  protected void printoutSequences(PrintStream out,
      Pair<String, String> sequence, List<String> r) {
    int counter = 0;

    int w = (int) (Math.log10(r.size()) + 1);

    String baseDescription = sequence.getFirst();

    if (!baseDescription.trim().equals(""))
      baseDescription = baseDescription + "|";

    for (String string : r) {
      counter++;
      out.print(">" + baseDescription + "ORF:");
      out.format("%0" + w + "d%n", counter);
      out.println(string);
    }
  }
  
  
  protected void attempToKeepLargest(List<String> orfs) {
  }

}
