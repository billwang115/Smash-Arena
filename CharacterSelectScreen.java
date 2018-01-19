/*
 * [CharacterSelectScreen.java]
 * Displays the select screen to choose your character
 * Author: Jaden Tang
 * January 16th,2018
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class CharacterSelectScreen{
  SelectScreen characterSelectScreen = new SelectScreen(1024,768);
  Button redButton;
  Button blueButton;
  NarutoIcon narutoIconImage = new NarutoIcon(205,200);
  GokuIcon gokuIconImage = new GokuIcon(200,200);
  NarutoPose narutoPoseImage = new NarutoPose(180,294);
  GokuPose gokuPoseImage = new GokuPose(200,330);
  boolean redButtonSelect = false;
  boolean blueButtonSelect = false;
  int player1Character=0;
  int player2Character=0;
  
  public CharacterSelectScreen(){
    redButton = new Button();
    redButton.x = 450;
    redButton.y = 465;
    
    blueButton = new Button();
    blueButton.x = 520;
    blueButton.y = 465;
  }
  
  public void draw(Graphics g){
    characterSelectScreen.draw(g);
    narutoIconImage.draw(g);
    gokuIconImage.draw(g);
    redButton.move();
    redButton.draw(g);
    blueButton.move();
    blueButton.draw2(g);
    if(redButton.x >= 600 && redButton.x <= 800 && redButton.y >= 500 && redButton.y <= 700){
      gokuPoseImage.draw2(g);
      if(redButtonSelect == true){
        //player1 is goku
        player1Character=1;
      }
    }
    if(redButton.x >= 200 && redButton.x <= 400 && redButton.y >= 500 && redButton.y <= 700){
      narutoPoseImage.draw(g);
      if(redButtonSelect == true){
        //player1 is naruto
        player1Character=2;
      }
    }
    if(blueButton.x >= 600 && blueButton.x <= 800 && blueButton.y >= 500 && blueButton.y <= 700){
      gokuPoseImage.draw(g);
      if(blueButtonSelect == true){
        //player2 is goku
        player2Character=1;
      }
    }
    if(blueButton.x >= 200 && blueButton.x <= 400 && blueButton.y >= 500 && blueButton.y <= 700){
      narutoPoseImage.draw2(g);
      if(blueButtonSelect == true){
        //player2 is naruto
        player2Character=2;
      }
    }
  }
  public int getPlayer1Character(){
    return player1Character;
  }
  public int getPlayer2Character(){
    return player2Character;
  }
  
  
public void moveRedButton(int inputKey){
if(inputKey==1){
      redButton.xdirection=-1;
              inputKey=0;
      }
      if(inputKey==2){
      redButton.ydirection=1;
              inputKey=0;
      }
      if(inputKey==3){
      redButton.xdirection=1;
              inputKey=0;
      }
      if(inputKey==4){
       redButton.ydirection=-1;
        inputKey=0;
      }
      if(inputKey==5){
      redButtonSelect = true;
        inputKey=0;
      }
}
public void moveBlueButton(int inputKey){
 if(inputKey==1){
      blueButton.xdirection=-1;
              inputKey=0;
      }
      if(inputKey==2){
      blueButton.ydirection=1;
              inputKey=0;
      }
      if(inputKey==3){
      blueButton.xdirection=1;
              inputKey=0;
      }
      if(inputKey==4){
      blueButton.ydirection=-1;
        inputKey=0;
      }
      if(inputKey==5){
      blueButtonSelect = true;
        inputKey=0;
      } 
  
}
  
public void stopRedButton(int inputKey){
  if(inputKey==-1){
      redButton.xdirection=0;
      }
      if(inputKey==-2){
      redButton.ydirection=0;
      }
      if(inputKey==-3){
      redButton.xdirection=0;
      }
      if(inputKey==-4){
      redButton.ydirection=0;
      }
      if(inputKey==-5){
      redButtonSelect = false;
      }
}
public void stopBlueButton(int inputKey){
    if(inputKey==-1){
      blueButton.xdirection=0;
      }
      if(inputKey==-2){
      blueButton.ydirection=0;
      }
      if(inputKey==-3){
      blueButton.xdirection=0;
      }
      if(inputKey==-4){
      blueButton.ydirection=0;
      }
      if(inputKey==-5){
      blueButtonSelect = false;
      } 
}
}