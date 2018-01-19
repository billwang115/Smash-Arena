/*
 * [SelectScreen.java]
 * Displays the select screen for choosing characters
 * Author: Jaden Tang
 * Jan 18, 2018
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class SelectScreen{
  BufferedImage selectScreen;
  int screenWidth;
  int screenHeight;
  //constructor
  SelectScreen(int screenWidth, int screenHeight){
    this.screenWidth=screenWidth;
    this.screenHeight=screenHeight;
    try{
      selectScreen = new BufferedImage(screenWidth,screenHeight, BufferedImage.SCALE_DEFAULT);
      selectScreen = ImageIO.read(new File("selectScreen.jpg"));
    }catch(IOException e){
      System.out.println("select screen error"); 
    }
  }
  //method to draw
  public void draw(Graphics g){
    g.drawImage(selectScreen,0,0,screenWidth, screenHeight, null);
  }
}