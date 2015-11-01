/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
/**
 * draw the scaffold and tiny rope.
 */
	private void setup() {
		int rightX=getWidth()/2;		
		int leftX=rightX-BEAM_LENGTH;
		int midY=(getHeight()-BODY_LENGTH)/2-2*HEAD_RADIUS-DIFF;
		int upY=midY-ROPE_LENGTH;
		int lowY=upY+SCAFFOLD_HEIGHT;
		GLine scaffold=new GLine(leftX, upY, leftX, lowY);
		add(scaffold);
		GLine beam=new GLine(leftX, upY, rightX, upY);
		add(beam);
		GLine rope=new GLine(rightX, upY, rightX, midY);
		add(rope);
	}
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
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
		display.setFont("-30");
		add(display, 100, 800);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		incorrectGuess+=letter;
		GLabel incorrectList=new GLabel(incorrectGuess);
		incorrectList.setFont("-20");
		add (incorrectList, 100, 900);
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
		}
	}

	
	private void drawHead() {
		int d=2*HEAD_RADIUS;
		int x=getWidth()/2-HEAD_RADIUS;
		int y=(getHeight()-BODY_LENGTH)/2-DIFF-d;
		GOval head=new GOval(x,y,d,d);
		add(head);
	}
	
	private void drawBody() {
		int x=getWidth()/2;
		int upY=(getHeight()-BODY_LENGTH)/2-DIFF;
		int lowY=upY+BODY_LENGTH;
		GLine body=new GLine(x,upY,x,lowY);
		add(body);
	}
	
	private void drawLeftArm() {
		int rx=getWidth()/2; //right x
		int lx=-rx-UPPER_ARM_LENGTH; //left x
		int uy=(getHeight()-BODY_LENGTH)/2-DIFF+ARM_OFFSET_FROM_HEAD; //upper y
		int ly=uy+LOWER_ARM_LENGTH; //lower y
		GLine upLeftArm= new GLine(lx,uy,rx,uy);
		add(upLeftArm);
		GLine lowLeftArm= new GLine(lx,uy,lx,ly);
		add(lowLeftArm);
	}
	
	private void drawRightArm() {
		int lx=getWidth()/2; //right x
		int rx=lx+UPPER_ARM_LENGTH; //left x
		int uy=(getHeight()-BODY_LENGTH)/2-DIFF+ARM_OFFSET_FROM_HEAD; //upper y
		int ly=uy+LOWER_ARM_LENGTH; //lower y
		GLine upRightArm= new GLine(lx,uy,rx,uy);
		add(upRightArm);
		GLine lowRightArm= new GLine(rx,uy,rx,ly);
		add(lowRightArm);
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
		int y=(getWidth()+BODY_LENGTH)/2-DIFF+LEG_LENGTH;
		GLine feet=new GLine(rx,y,lx,y);
		add(feet);
	}
	
	private void drawRightFoot(){
		int lx=getWidth()/2+HIP_WIDTH;
		int rx=lx+FOOT_LENGTH;
		int y=(getWidth()+BODY_LENGTH)/2-DIFF+LEG_LENGTH;
		GLine feet=new GLine(rx,y,lx,y);
		add(feet);
	}
	
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int DIFF=100; //how higher than the center the person is display
	
// Instance variables
	private GLabel display;
	private String incorrectGuess;

}
