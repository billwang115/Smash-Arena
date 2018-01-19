/*Screen class
 * includes all the screen objects
 * By:William Wang
 */
import java.awt.Graphics;

class Screen{
  //declare variables
WinScreen winScreen;
int currentScreen=0;
boolean gameRunning=false;
CharacterSelectScreen characterSelectScreen;
ControlsScreen controlsScreen;
StartScreen startScreen;

//constructor
Screen(int xResolution,int yResolution){
  winScreen=new WinScreen(xResolution,yResolution);
  characterSelectScreen=new CharacterSelectScreen();
  controlsScreen=new ControlsScreen(xResolution,yResolution);
  startScreen=new StartScreen(xResolution,yResolution);
}
  //methods
public boolean getGameRunning(){
  return gameRunning;
}
public void setGameRunning(boolean game){
  this.gameRunning=game; 
}
public int getCurrentScreen(){
  return currentScreen;
}
public void setCurrentScreen(int screen){
  this.currentScreen=screen;
}
//update screen
  public void updateScreen(){
    if(getCharacter1()!=0&&getCharacter2()!=0){
      currentScreen=3;
      gameRunning=true;
    }
  }
 
//draw winScreen
public void drawWinScreen(Graphics g,int characterWon,int playerWon){
  winScreen.draw(g,characterWon,playerWon);  
}
//character select screen methods
  public void drawCharacterSelectScreen(Graphics g){
  characterSelectScreen.draw(g);
}
  
  public void moveButtons(int inputKey,int inputKey2){
    if(inputKey>0){
      characterSelectScreen.moveRedButton(inputKey);
    }else if(inputKey<0){
      characterSelectScreen.stopRedButton(inputKey);
    } 
    if(inputKey2>0){
      characterSelectScreen.moveBlueButton(inputKey2); 
    }else if(inputKey2<0){
      characterSelectScreen.stopBlueButton(inputKey2);
    }
  }
  public int getCharacter1(){
    return characterSelectScreen.getPlayer1Character();
  }
  public int getCharacter2(){
    return characterSelectScreen.getPlayer2Character();
  }
  
  //controls screen
  public void drawControlScreen(Graphics g){
    controlsScreen.draw(g);
  }  
  
  //start screen
  public void drawStartScreen(Graphics g){
    startScreen.draw(g);
  }
  
}