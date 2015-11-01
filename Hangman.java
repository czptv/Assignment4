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
	private String word="";
	private String display=""; //the word displayed on the screen according to what the player already entered.
	private RandomGenerator rgen=RandomGenerator.getInstance();
	
	//play the whole game
	
	public void run() {
		println("Welcom to Hangman!");
		word=getWord();
		setDisplay();
		guess();
		end();
	}
	
	//get a random word from the secret word base.
	
	private String getWord() {
		int totalWord=wordBase.getWordCount();
		int wordSequence=rgen.nextInt(0,totalWord);
		String secretWord=wordBase.getWord(wordSequence);
		return secretWord;
	}
	
	/*
	 * The players can guess for 8 times in one round. 
	 * the player can enter guess in either upper or lower case.
	 * Every time the player finish one guess, always show the prompt:
	 * "The word now looks like this: XXXXX"
	 * "You have X guesses left."
	 * "Your guess: "
	 * When you only have one guess left, the prompt is a bit different: 
	 * "You have only one guess left."
	 * Whenever player get all the letters in the word, break out of the loop.
	 * The color of player's guess and the secret word is pruple.
	 */
	
	private void guess() {
		while (guessLeft>0) {
			display=getDisplay();//set font
			println("The word now looks like this: " + display);
			if (guessLeft != 1) {
				println("You have " + guessLeft + "guesses left.");
			} else {
				println("You have only one guess left.")
			}
			String letter=readLine("You guess: "); //set font
			compareString(letter);
			guessLeft	
		}
	}
	
	/*
	 * Right guess: that doesn't count for one guess, 
	 * the prompt shown is "That guess is correct" and 
	 * their guessed letter appears in all the right places in the word.
	 * Wrong guess: they have one fewer guess, the word doesn't change, 
	 * and the prompt shown is "There is no X's in the word."
	 */
	
	private void compareString(String input) {
		input=input.toUpperCase();
		boolean appear=false;
		for (int i=0; i<word.length(); i++) {
			if (input.equals(word.substring(i, i+1))) {
				appear=true;
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
