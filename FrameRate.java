/*
 * [FrameRate.java]
 * Determines the frames per second
 * January 1, 2017
 * Author: Jaden Tang
*/

import java.awt.Graphics;
import java.awt.Font;

class FrameRate{
  //variables
  String frameRate;
  long lastTimeCheck;
  long deltaTime;
  int frameCount;
  Font frameFont=new Font("Tahoma",Font.BOLD,20);
  
  //constructor
  public FrameRate(){
    lastTimeCheck = System.currentTimeMillis();
    frameCount = 0;
    frameRate = "0 fps";
  }
  
  //methods 
  
  public void update(){
    long currentTime = System.currentTimeMillis();
    deltaTime += currentTime - lastTimeCheck;
    lastTimeCheck = currentTime;
    frameCount++;
    if (deltaTime >= 1000){
      frameRate = frameCount + " fps";
      frameCount = 0;
      deltaTime = 0;
    }
  }
  
  public void draw(Graphics g, int x, int y){
    g.setFont(frameFont);
    g.drawString(frameRate,x,y);
  }
  
}