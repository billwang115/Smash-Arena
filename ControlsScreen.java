/*
 * [ControlsDisplayed.java]
 * Displays the control screen
 * Author: Jaden Tang
 * Jan 18, 2018
*/

import java.awt.Font;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

class ControlsScreen{
    Font controls = new Font("Times New Roman",Font.BOLD,48);
    Color black = new Color(0,0,0);
    BufferedImage controlScreen;
    int screenWidth;
    int screenHeight;
    
    
    ControlsScreen(int screenWidth, int screenHeight){
      this.screenWidth=screenWidth;
      this.screenHeight=screenHeight;
      try{
        controlScreen = new BufferedImage(screenWidth,screenHeight, BufferedImage.SCALE_DEFAULT);
        controlScreen = ImageIO.read(new File("controlScreen.png"));
      }catch(IOException e){
        System.out.println("control screen error"); 
      }
    }
    public void draw(Graphics g){
      g.drawImage(controlScreen,0,0,screenWidth, screenHeight, null);
      g.setFont(controls);
      g.setColor(black);
      g.drawString("Back",890,50);
    }
  }