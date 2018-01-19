/*
 * [GokuIcon.java]
 * Displays a goku icon
 * Author: Jaden Tang
 * Jan 18, 2018
*/

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class GokuIcon{
  BufferedImage gokuIcon;
  int iconWidth;
  int iconHeight;
  //constructor
  GokuIcon(int iconWidth, int iconHeight){
    this.iconWidth = iconWidth;
    this.iconHeight = iconHeight;
    try{
      gokuIcon = new BufferedImage(iconWidth,iconHeight,BufferedImage.SCALE_DEFAULT);
      gokuIcon = ImageIO.read(new File("gokuSelectScreen.png"));
    }catch(IOException e){
      System.out.println("goku select screen error");
    }
  }
  //draw method
  public void draw(Graphics g){
    g.drawImage(gokuIcon,615,522,iconWidth,iconHeight,null);
  }
}