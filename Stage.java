/*Stage class
 * Create stage for movement on
 */
import java.awt.Graphics;

abstract class Stage{
  //declare variables
  int boxHeight;
  int boxWidth;
  Collision mapHitbox= new Collision(0,0,1024,768);
  
//constructor
  Stage(int xResolution,int yResolution){
    this.boxWidth=xResolution;
    this.boxHeight=yResolution;
  }
  
  //methods
  public Collision getMapHitbox(){
    return mapHitbox;
  }
  public boolean onstage(int collision){
    return true;
  }
  abstract double respawnPointX();    ///will be overriden
  abstract double respawnPointY();   ///will be overriden
  abstract void draw(Graphics g);   //will be overriden
  abstract Collision getStageHitbox(); //overridden
}