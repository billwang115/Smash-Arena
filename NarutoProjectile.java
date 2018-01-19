/*
 * [NarutoProjectile.java]
 * Class that has naruto's projectiles
 * December 04,2017
 * Author: Jaden Tang
*/

import java.awt.Graphics;

class NarutoProjectile extends Projectile{
  //variables
  Sprites narutoProjectile;
  private double delay;
  
  //constructor
  NarutoProjectile(double positionX, double positionY, double speed){
    super(positionX,positionY,speed);
    narutoProjectile = new Sprites(positionX,positionY);
  }
  
  //methods
  public void update(double positionX, double positionY){  //update location
    narutoProjectile.projectileAttack2();
    setPositionX(positionX);
    setPositionY(positionY);
    narutoProjectile.setFacingLeft(getDirection());
  }
  
  //attack methods
  public void attack(){
    setDamage(8);
    delay = 1.5;
  }
  
  public double getDelay(){
    return delay;
  }
  
  //image methods
    public int getImageWidth(){
    return narutoProjectile.getImageWidth();
  }
  
  public int getImageHeight(){
    return narutoProjectile.getImageWidth();
  }
  
  //draw the projectile
  public void draw(Graphics g){
    narutoProjectile.draw(g,getPositionX(), getPositionY());
  }
}
    
    