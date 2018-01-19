/*Final destination class
 * create the final destination stage
 * By:William Wang
 */

//import classes
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class FinalDestination extends Stage{
  //declare variables
  BufferedImage finalD;
  Collision stageHitbox = new Collision(220,475,600,65);
  //constructor
  FinalDestination(int xResolution,int yResolution){
    super(xResolution,yResolution);
    try{
      finalD=new BufferedImage(xResolution, yResolution, BufferedImage.TYPE_BYTE_INDEXED);
      finalD=ImageIO.read(new File("Final_Destination.png"));
    }catch(IOException e){
      System.out.println("Final destination error: "+e);
    }
  }
  
  //methods
   public Collision getStageHitbox(){  //return the hitbox
    return stageHitbox;
  }
   public double respawnPointX(){  //get respawn pointX
     return 512;
   }
   public double respawnPointY(){   //get respawn pointY
     return 400;
   }
  public void draw(Graphics g){
    g.drawImage(finalD,0,0,boxWidth,boxHeight,null); 
  }
  
}