/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.AudioClip;
import java.awt.*;

public class HangmanExtension extends ConsoleProgram {

	//constants
	
	/**
	 * the total guesses the user has in one round
	 */
	private static final int GUESS=8;
	
	/**
	 * the round the player has
	 */
	private static final int ROUND=10;
	
	//instance variables
	private HangmanLexicon wordBase= new HangmanLexicon();
	private int guessLeft=GUESS;
	private String word="";
	private String display=""; //the word displayed on the screen according to what the player already entered.
	private RandomGenerator rgen=RandomGenerator.getInstance();
	private HangmanCanvas canvas;
	
	//initiate the canvas
	
	public void init() {
		canvas=new HangmanCanvas();
		add(canvas);
	}
	
	//play the whole game	
	
	public void run() {
		println("Welcome to Hangman!");
		for(int i=0;i<ROUND;i++) {
			int roundLeft=ROUND-i;
			giveRound(roundLeft);
			word=getWord();
			setup();
			canvas.reset();
			canvas.displayWord(display);
			guess();
			end();
			guessLeft=GUESS;
		}
		
	}
	
	//give players hint about how many rounds do they still have.
	private void giveRound(int round) {
		if (round==1) {
			println("Cherish your last round!");
		} else {
			println("You have " + round + " rounds left.");
		}
	}
	
	//get a random word from the secret word base.
	
	private String getWord() {
		int totalWord=wordBase.getWordCount();
		int wordSequence=rgen.nextInt(0,totalWord-1);
		String secretWord=wordBase.getWord(wordSequence);
		return secretWord;
	}
	
	//set the initial display
	
	private void setup() {
		int wordLength=word.length();
		display="";
		for (int i=0; i<wordLength; i++) {
			display+="-";
		}
		
	}
	
	/*
	 * The players can guess for 8 times in one round. 
	 * the player can enter guess in either upper or lower case.
	 * Whenever player get all the letters in the word, break out of the loop.
	 */
	
	private void guess() {
		while (guessLeft>0) {
			givePrompt();
			String letter=readLine("Your guess: "); //set font
			boolean valid=hintInvalidInput(letter);
			if (valid) {
				compareString(letter);
				canvas.displayWord(display);
			}
			if (display.equals(word)) break;
		}
	}
	
	/* Every time the player finish one guess, always show the prompt:
	 * "The word now looks like this: XXXXX"
	 * "You have X guesses left."
	 * "Your guess: "
	 * When you only have one guess left, the prompt is a bit different: 
	 * "You have only one guess left."
	 */
	private void givePrompt() {
		println("The word now looks like this: " + display);
		if (guessLeft != 1) {
			println("You have " + guessLeft + " guesses left.");
		} else {
			println("You have only one guess left.");
		}
	}
	/*
	 * 
	 */
	
	private boolean hintInvalidInput(String input) {
		input=input.toUpperCase();
		boolean singleInput=(input.length()==1);
		boolean letterInput=false;
		if(input.length()==1) {
			letterInput=Character.isLetter(input.charAt(0));
		} 
		boolean validInput=singleInput && letterInput;
		if (!validInput) {
			println("Invalid guess.");
			println("There are only letters in the word.");
		}
		return validInput;
	}
	
	
	/*
	 * check whether the input of user is in the secret word and tells the player
	 */
	
	private void compareString(String input) {
		input=input.toUpperCase();
		char ch=input.charAt(0);
		boolean appear=checkPresence(ch);
		giveResponse(appear,ch);
		
		
	}
	
	/*
	 * check whether the input of user is in the secret word.
	 * Right guess: that doesn't count for one guess, 
	 * the prompt shown is "That guess is correct" and 
	 * their guessed letter appears in all the right places in the word.
	 * Wrong guess: they have one fewer guess, the word doesn't change, 
	 * and the prompt shown is "There is no X's in the word."
	 */
	
	private boolean checkPresence(char ch) {
		boolean appear=false;
		for (int i=0; i<word.length(); i++) {
			if (ch==word.charAt(i)) {
				appear=true;
				display=display.substring(0, i) + ch + display.substring(i+1);
			} 
		}
		return appear;
	}
	
	//give response to player whether their guess is correct
	private void giveResponse(boolean appear, char ch) {
		if (appear) {
			println("That guess is correct.");
			AudioClip bounceClip = MediaTools.loadAudioClip("correct.m4a");
			bounceClip.play();
		} else {
			guessLeft--;
			canvas.noteIncorrectGuess(ch);
			println("There are no " + ch + "'s in the word.");
			AudioClip bounceClip = MediaTools.loadAudioClip("incorrect.m4a");
			bounceClip.play();
		}
	}
	/*
	 * give the actual word and indicate whether user lose or win
	 */
	
	private void end() {
		if (guessLeft!=0) {
			println("You guessed the word: " + word);
			println("You win.");
		} else {
			println("The word was: " + word);
			println("You lose.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
