/*
 * [GokuPose.java]
 * Displays a goku pose
 * Author: Jaden Tang
 * Jan 18, 2018
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class GokuPose{
  BufferedImage gokuPose;
  int poseWidth, poseHeight;
  //constructor
  GokuPose(int poseWidth, int poseHeight){
    this.poseWidth = poseWidth;
    this.poseHeight = poseHeight;
    try{
      gokuPose = new BufferedImage(poseWidth,poseHeight,BufferedImage.SCALE_DEFAULT);
      gokuPose = ImageIO.read(new File("gokuPose.png"));
    }catch(IOException e){
      System.out.println("goku pose screen error");
    }
  }
  //methods to draw
  public void draw(Graphics g){
    g.drawImage(gokuPose,750,150,poseWidth,poseHeight,null);
  }
  public void draw2(Graphics g){
    g.drawImage(gokuPose,60,150,poseWidth,poseHeight,null);
  }
}