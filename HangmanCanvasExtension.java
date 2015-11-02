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
				drawLeftFoot();
				break;	
			case 8: 
				drawRightFoot();
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
		int x=getWidth()/2-60;
		int y=(getHeight())/2-140; //upper y
		GImage leftArm= new GImage("leftHand.jpg",x,y);
		leftArm.scale(0.1,0.1);
		add(leftArm);
	}
	
	private void drawRightArm() {
		int x=getWidth()/2+32; 
		int y=(getHeight())/2-120;
		GImage rightArm= new GImage("rightHand.jpg",x,y);
		rightArm.scale(0.1,0.1);
		add(rightArm);
	}
	
	private void drawLeftLeg() {
		int rx=getWidth()/2;
		int lx=rx-HIP_WIDTH;
		int uy=(getHeight()+BODY_LENGTH)/2-DIFF;
		int ly=uy+LEG_LENGTH;
		GLine hip=new GLine(rx,uy,lx,uy);
		add(hip);
		GLine leg=new GLine(lx,uy,lx,ly);
		add(leg);
	}
	
	private void drawRightLeg() {
		int lx=getWidth()/2;
		int rx=lx+HIP_WIDTH;
		int uy=(getHeight()+BODY_LENGTH)/2-DIFF;
		int ly=uy+LEG_LENGTH;
		GLine hip=new GLine(rx,uy,lx,uy);
		add(hip);
		GLine leg=new GLine(rx,uy,rx,ly);
		add(leg);
	}
	
	private void drawLeftFoot(){
		int rx=getWidth()/2-HIP_WIDTH;
		int lx=rx-FOOT_LENGTH;
		int y=(getHeight()+BODY_LENGTH)/2-DIFF+LEG_LENGTH;
		GLine feet=new GLine(rx,y,lx,y);
		add(feet);
	}
	
	private void drawRightFoot(){
		int lx=getWidth()/2+HIP_WIDTH;
		int rx=lx+FOOT_LENGTH;
		int y=(getHeight()+BODY_LENGTH)/2-DIFF+LEG_LENGTH;
		GLine feet=new GLine(rx,y,lx,y);
		add(feet);
	}
	
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 44;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int DIFF=50; //how higher than the center the person is display
	
// Instance variables
	private GLabel display;
	private String incorrectGuess="";

}
