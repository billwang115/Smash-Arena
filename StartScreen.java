/*
 * [Options.java]
 * Displays the start screen
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

class StartScreen{
    BufferedImage startScreen;
    Font controls = new Font("Times New Roman",Font.BOLD,48);
    int screenWidth;
    int screenHeight;
    Color white = new Color(255,255,255);
    //constructor
    StartScreen(int screenWidth,int screenHeight){
      this.screenWidth=screenWidth;
      this.screenHeight=screenHeight;
      try{
        startScreen = new BufferedImage(screenWidth,screenHeight, BufferedImage.SCALE_DEFAULT);
        startScreen = ImageIO.read(new File("startScreen.png"));
      }catch(IOException e){
        System.out.println("start screen error"); 
      }
    }
    //method to draw the start screen
    public void draw(Graphics g){
      g.drawImage(startScreen,0,0,screenWidth, screenHeight,null);
      g.setFont(controls);
      g.setColor(white);
      g.drawString("Controls",800,710);
    }
  }