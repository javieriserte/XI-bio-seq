package org.jiserte.bioseq.apps.sequenceshuffler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import cmdGA2.CommandLine;
import cmdGA2.NoArgumentOption;
import cmdGA2.OptionsFactory;
import cmdGA2.SingleArgumentOption;
import org.jiserte.bioformats.fastaIO.FastaMultipleReader;
import org.jiserte.bioformats.fastaIO.FastaWriter;
import pair.Pair;
import org.jiserte.bioseq.shuffle.FixedGapsShuffler;
import org.jiserte.bioseq.shuffle.NoFixedShuffler;
import org.jiserte.bioseq.shuffle.SequenceShuffler;

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
public abstract class SequenceShufflerCli {

	
	////////////////////////
	// Main executable method
	public static void main(String[] args) {
		
		/////////////////////////
		// Create Command Line object
		CommandLine cmdline = new CommandLine();
		
		/////////////////////////
		// Adds Options to command line
		SingleArgumentOption<InputStream> inOpt = OptionsFactory.createBasicInputStreamArgument(cmdline);
		
		SingleArgumentOption<PrintStream> outOpt = OptionsFactory.createBasicPrintStreamArgument(cmdline);
		
		NoArgumentOption fixedGapOpt = new NoArgumentOption(cmdline, "--fixedGaps");
		
		NoArgumentOption helpOpt = new NoArgumentOption(cmdline, "--help");
		
		/////////////////////////////
		// Parse command line
		cmdline.readAndExitOnError(args);
		
		//////////////////////////////
		// Checks for help option
		if (helpOpt.isPresent()) {
			
			SequenceShufflerCli.printHelp();
			
			System.exit(1);
			
		}
		
		/////////////////////////////
		// Gets command line values
		BufferedReader in = new BufferedReader(new InputStreamReader( inOpt.getValue()));
		
		PrintStream out = outOpt.getValue();
		
		boolean fixedGap = fixedGapOpt.isPresent();
		
		////////////////////////////
		// Checks if --fixedGaps option
		// is present in the command line
		// and creates the corresponding 
		// sequence shuffler.
		SequenceShuffler seqShuffler = fixedGap ? 
				                       (new FixedGapsShuffler()):
				                       (new NoFixedShuffler());
			
		/////////////////////////////
        // Read the input sequences
        List<Pair<String, String>> sequences = (new FastaMultipleReader()).readBuffer(in);
        
        /////////////////////////////
        // Shuffle sequences 
        
        List<Pair<String,String>> shuffled = new ArrayList<>();
        
        for (Pair<String, String> sequence : sequences) {
			
        	shuffled.add(new Pair<String, String>(sequence.getFirst(), seqShuffler.shuffle(sequence.getSecond())));
        	
		}

        ////////////////////////////
        // and prints them out.
        FastaWriter writer = new FastaWriter();
        
    	writer.print(out, shuffled);
		
	}

	private static void printHelp() {
		
		InputStream helpStream = SequenceShufflerCli.class.getResourceAsStream("Help");
		
		PrintStream ps = new PrintStream(System.err);
		
		byte current = -1;

		try {
			
			while ((current = (byte) helpStream.read())!=-1) {
			
				ps.write(current);
			
			}
			
		} catch (IOException e) {
			
			System.err.println("There was an error trying to print the help.");
			
		}
		
	}
	
	
}
