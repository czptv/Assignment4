/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.program.*;
import acm.util.*;
import java.util. *;
import java.io.*;

public class HangmanLexicon extends ConsoleProgram{

	//constants
	private static final String FILENAME="HangmanLexicon.txt";
	
	//instance variables
	ArrayList<String> wordList= new ArrayList<String>();
	
	// This is the HangmanLexicon constructor
	public HangmanLexicon() {
		BufferedReader rd=openFile(FILENAME);
		try {
			while (true) {
				String line=rd.readLine();
				if(line==null) break;
				wordList.add(line);
			}
			rd.close();
		} catch (IOException ex){
			throw new ErrorException(ex);
		}
		
	}
	
	private BufferedReader openFile(String filename) {
		BufferedReader rd=null;
		while (rd==null) {
			try {
				rd=new BufferedReader(new FileReader(filename));
			} catch (IOException ex){
				println("Invalid filename.");
			}
		}
		return rd;
	}
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordList.get(index);
	};
}
