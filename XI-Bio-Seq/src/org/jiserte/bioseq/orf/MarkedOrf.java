package org.jiserte.bioseq.orf;

/**
 * Objets of this class has the information of the sequence, atg mark and stop
 *  mark for a sequence.
 *
 * @author Javier
 *
 */
public class MarkedOrf {

  //////////////////////////////////////////////////////////////////////////////
  // Instance variables
  private int atg;
  private int stop;
  private String sequence;
  //////////////////////////////////////////////////////////////////////////////
  
  //////////////////////////////////////////////////////////////////////////////
  // Constructors
  
  public MarkedOrf(int atg, int stop, String sequence) {
    super();
    this.atg = atg;
    this.stop = stop;
    this.sequence = sequence;
  }
  public MarkedOrf() {
    super();
    this.atg = 0;
    this.stop = 0;
    this.sequence = "";
  }

  //////////////////////////////////////////////////////////////////////////////

  //////////////////////////////////////////////////////////////////////////////
  // Public interface
  public int getAtg() {
    return atg;
  }
  public void setAtg(int atg) {
    this.atg = atg;
  }
  public int getStop() {
    return stop;
  }
  public void setStop(int stop) {
    this.stop = stop;
  }
  public String getSequence() {
    return sequence;
  }
  public void setSequence(String sequence) {
    this.sequence = sequence;
  }
  
  //////////////////////////////////////////////////////////////////////////////
  
}
