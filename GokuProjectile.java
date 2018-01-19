/*goku projectile
 *creates goku's special attack projectile
 * By:William Wang
 */
import java.awt.Graphics;

class GokuProjectile extends Projectile{
  //declare variables
  Sprites gokuProjectile;
  private double delay;
  
  //constructor
  GokuProjectile(double positionX,double positionY,double speed){
    super(positionX,positionY,speed);
    gokuProjectile=new Sprites(positionX,positionY);
  }
  
  //methods
  public void update(double positionX,double positionY){
    gokuProjectile.projectileAttack();
    setPositionX(positionX);
    setPositionY(positionY);
    gokuProjectile.setFacingLeft(getDirection());
  }
  
  //attack methods
  public void attack(){
    setDamage(8);
    delay=1.5;
  }
  public double getDelay(){
   return delay; 
  }
  //image methods
   public int getImageWidth(){
    return gokuProjectile.getImageWidth();
  }
  
  public int getImageHeight(){
    return gokuProjectile.getImageWidth();
  }
  
  //draw the projectile
  public void draw(Graphics g){
    gokuProjectile.draw(g,getPositionX(),getPositionY());
  }
  
}