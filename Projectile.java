/*Projectile class
 * super class for all projectiles
 * By:William Wang
 */
import java.awt.Graphics;

abstract class Projectile{
  //declare variables
  private double positionX;
  private double positionY;
  private double speed;
  private boolean direction; 
  private int damage;
  private boolean projectileCreated;
  Collision projectileHitbox;
  
  //constructor
  Projectile(double positionX,double positionY,double speed){
    this.positionX=positionX;
    this.positionY=positionY;
    this.speed=speed;
    projectileHitbox=new Collision(positionX,positionY,5,5);
  }
  
  //methods
  //movement
  public void move(){
    if(direction==true){
      this.positionX=positionX-2; 
    }else if(direction==false){
      this.positionX=positionX+2; 
    }
  }
  public double getPositionX(){
    return positionX; 
  }
  public double getPositionY(){
    return positionY; 
  }
  public void setPositionX(double positionX){
    this.positionX=positionX;
  }
  public void setPositionY(double positionY){
    this.positionY=positionY;
  }
  public boolean getDirection(){
    return direction; 
  }
  public void setDirection(boolean direction){
    this.direction=direction;
  }
    public void setProjectileCreated(boolean created){
    this.projectileCreated=created;
  }
  public boolean getProjectileCreated(){
    return projectileCreated;
  }
  abstract void update(double positionX,double positionY);   //overidden
    abstract void draw(Graphics g);   ///overidden  
  abstract int getImageHeight();  //overridden
  abstract int getImageWidth();   //overridden
  
  //attack methods
  public boolean getHit(int collision){
    return true;
  }  
  public void setDamage(int damage){
    this.damage = damage;
  }
  public int getDamage(){
    return damage;
  }
  abstract void attack();     //overriden
  
  
  //ProjectileHitbox
  public Collision getHitbox(){  //return projectile hitbox
    return projectileHitbox;
  }
  public void updateHitbox(int height,int width){ //update hitbox
    projectileHitbox.update(positionX,positionY,height,width);
  }
}