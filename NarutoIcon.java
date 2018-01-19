/*
 * [NarutoIcon.java]
 * Displays a naruto icon
 * Author: Jaden Tang
 * Jan 18, 2018
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class NarutoIcon{
  BufferedImage narutoIcon;
  int iconWidth;
  int iconHeight;
  //constructor
  NarutoIcon(int iconWidth, int iconHeight){
    this.iconWidth = iconWidth;
    this.iconHeight = iconHeight;
    try{
      narutoIcon = new BufferedImage(iconWidth,iconHeight,BufferedImage.SCALE_DEFAULT);
      narutoIcon = ImageIO.read(new File("narutoSelectScreen.png"));
    }catch(IOException e){
      System.out.println("naruto select screen error");
    }
  }
  //method to draw
  public void draw(Graphics g){
    g.drawImage(narutoIcon,208,523,iconWidth,iconHeight,null);
  }
}