/*shield class
 * create shields for characters
 * By:William Wang
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Shield{
  //declare variables
  private int health;
  private int shieldHeight;
  private int shieldWidth;
  private double positionX;
  private double positionY;
  boolean shieldCreated;
  private boolean shieldDestroyed=false;
  BufferedImage shield;
//  Collision shieldHitbox;
  
  //constructor
  Shield(int health,int shieldHeight,int shieldWidth,double positionX,double positionY){
    this.health=health;
    this.shieldHeight=shieldHeight;
    this.shieldWidth=shieldWidth;
    this.positionX=positionX;
    this.positionY=positionY;
//    shieldHitbox=new Collision(positionX,positionY,shieldHeight,shieldWidth);
    try{
      shield= new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
      shield=ImageIO.read(new File("Shield.png"));
    }catch(IOException e){
      System.out.println("Shield error: "+e);
    }
  }
  
  //methods
   public double getPositionX(){
    return positionX; 
  }
  public double getPositionY(){
    return positionY; 
  }
  public void update(double positionX,double positionY,int damage){
    this.positionX=positionX;
    this.positionY=positionY;
    this.health=health-damage;
    if(health<=0){
      shieldDestroyed=true;
    }
  }
  public boolean getShieldDestroyed(){
    return shieldDestroyed;
  }
  public boolean getShieldCreated(){
    return shieldCreated;
  }
  public void setShieldCreated(boolean created){
    this.shieldCreated=created;
  }
  
  //draw the shield
  public void draw(Graphics g){
    g.drawImage(shield,(int)positionX,(int)positionY,null);
  }
  
}