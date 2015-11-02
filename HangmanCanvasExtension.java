/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import acm.util.ErrorException;

public class HangmanCanvasExtension extends GCanvas {
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		if (getElementCount()!=0) {
			removeAll();
		}
		incorrectGuess="";
		int x=getWidth()/2-140;
		int y=getHeight()/2-250;
		GImage scaffold=new GImage("scaffold.png");
		scaffold.scale(0.25,0.25);
		add(scaffold,x,y);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		if (display!=null) {
			remove (display);
		}
		display=new GLabel(word);
		display.setFont("-20");
		add(display, 50, 440);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		updateIncorrectList(letter);
		switch (incorrectGuess.length()) {
			case 1: 
				drawHead();
				break;
			case 2: 
				drawBody();
				break;	
			case 3: 
				drawLeftArm();
				break;	
			case 4: 
				drawRightArm();
				break;	
			case 5: 
				drawLeftLeg();
				break;	
			case 6: 
				drawRightLeg();
				break;	
			case 7: 
				drawTail();
				break;	
			case 8: 
				drawDeco();
				break;	
			default: throw new ErrorException("getWord: Illegal index");
		}
	}

	private void updateIncorrectList(char letter){
		incorrectGuess+=letter;
		GLabel incorrectList=new GLabel(incorrectGuess);
		incorrectList.setFont("-15");
		add (incorrectList, 50, 470);
	}
	private void drawHead() {
		int x=getWidth()/2-20;
		int y=(getHeight())/2-170;
		GImage head=new GImage("head.jpg");
		head.scale(0.25,0.25);
		add(head,x,y);
	}
	
	private void drawBody() {
		int x=getWidth()/2-5;
		int y=(getHeight())/2-120;
		GImage body=new GImage("body.jpg",x,y);
		body.scale(0.1,0.1);
		add(body);
	}
	
	private void drawLeftArm() {
		int x=getWidth()/2-55;
		int y=(getHeight())/2-137; //upper y
		GImage leftArm= new GImage("leftHand.jpg",x,y);
		leftArm.scale(0.1,0.1);
		add(leftArm);
	}
	
	private void drawRightArm() {
		int x=getWidth()/2+32; 
		int y=(getHeight())/2-122;
		GImage rightArm= new GImage("rightHand.jpg",x,y);
		rightArm.scale(0.1,0.1);
		add(rightArm);
	}
	
	private void drawLeftLeg() {
		int x=getWidth()/2-14;
		int y=(getHeight())/2-93;
		GImage leftLeg=new GImage("leftFoot.jpg",x,y);
		leftLeg.scale(0.2,0.2);
		add(leftLeg);
	}
	
	private void drawRightLeg() {
		int x=getWidth()/2+11;
		int y=(getHeight())/2-93;
		GImage rightLeg=new GImage("rightFoot.jpg",x,y);
		rightLeg.scale(0.2,0.2);
		add(rightLeg);
	}
	
	private void drawTail(){
		int x=getWidth()/2+35;
		int y=(getHeight())/2-93;
		GImage tail=new GImage("tail.jpg",x,y);
		tail.scale(0.2,0.2);
		add(tail);
	}
	
	private void drawDeco(){
		int x=getWidth()/2;
		int y=(getHeight())/2;
		GImage deco=new GImage("deco.jpg",x,y);
		deco.scale(0.1,0.1);
		add(deco);
	}
	
// Instance variables
	private GLabel display;
	private String incorrectGuess="";

}
