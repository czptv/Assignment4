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

	//instance variables
	ArrayList<String> wordList;
	
	// This is the HangmanLexicon constructor
	public HangmanLexicon() {
		BufferedReader rd=openFile("Please enter filename: ");
		wordList= new ArrayList<String>();
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
	
	private BufferedReader openFile(String prompt) {
		BufferedReader rd=null;
		while (rd==null) {
			try {
				String filename=readLine(prompt);
				rd=new BufferedReader(new FileReader(filename));
			} catch (IOException ex){
				println("Invalid filename.");
				println("Please enter another filename.");
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
