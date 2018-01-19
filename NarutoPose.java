/*
 * [NarutoPose.java]
 * Displays a naruto pose
 * Author: Jaden Tang
 * Jan 18, 2018
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class NarutoPose{
  BufferedImage narutoPose;
  int poseWidth, poseHeight;
  //constructor
  NarutoPose(int poseWidth, int poseHeight){
    this.poseWidth = poseWidth;
    this.poseHeight = poseHeight;
    try{
      narutoPose = new BufferedImage(poseWidth,poseHeight,BufferedImage.SCALE_DEFAULT);
      narutoPose = ImageIO.read(new File("narutoPose.png"));
    }catch(IOException e){
      System.out.println("naruto pose screen error");
    }
  }
  //method to draw
  public void draw(Graphics g){
    g.drawImage(narutoPose,80,150,poseWidth,poseHeight,null);
  }
  public void draw2(Graphics g){
    g.drawImage(narutoPose,760,150,poseWidth,poseHeight,null);
  }
}