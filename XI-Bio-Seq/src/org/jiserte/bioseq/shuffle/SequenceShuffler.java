package org.jiserte.bioseq.shuffle;

import math.random.FischerYatesShuffle;

/**
 * Given a sequence generates a new one that contains the same
 * characters of the original in different order. Gaps characters 
 * can be optionally treated in a special way, indicating that 
 * thay must remain in the same position as the original sequence. 
 * This option is implementation specific.
 * 
 * @author Javier Iserte 
 *
 */
public abstract class SequenceShuffler {

	///////////////////////
	// Public Interface
	/**
	 * This method is the only one in the public interface.
	 * Takes a sequence and returns it shuffled
	 *  
	 * @param sequence the input sequence to be shuffled
	 * @return a new sequence, that conatains the same characters
	 *         from the input sequence in an altered order.
	 */
	public String shuffle(String sequence) {

		//////////////////////////////
		// This method is implemented
		// as a template method
		// pattern. The first and the third
		// steps are subclass specific
		
		Character[] symbols = this.getSymbols(sequence);
		// Retrieves the symbols used in
		// the impit sequence
		
		this.shuffleSymbols(symbols);
		// Shuffles the symbol
		
		return this.compose(symbols, sequence);
		// Creates the new sequence
		// and returns it
		
	}
	
	////////////////////////
	// Protected Methods
	protected abstract Character[] getSymbols(String sequence);
	
	protected abstract String compose(Character[] symbols, String guide);
	
	protected void shuffleSymbols (Character[] symbols) {
		
		FischerYatesShuffle.shuffle(symbols.length, symbols);
		
	}
	
}
