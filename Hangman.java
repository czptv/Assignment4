/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	//constants
	
	/**
	 * the total guesses the user has
	 */
	
	private static final int GUESS=8;
	
	//instance variables
	private HangmanLexicon wordBase;
	private int guessLeft=GUESS;
	
	//play the whole game
	
	public void run() {
		println("Welcom to Hangman!");
		guess();
		end();
	}
	
	/*
	 * The player can guess for 8 times in one round. 
	 */
	
	private void guess() {
		
	}
}
