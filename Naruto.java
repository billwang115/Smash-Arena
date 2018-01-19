/*
 * [Naruto.java]
 * Create a class for the character Naruto
 * December 19, 2017
 * Author: Jaden Tang
 */

import java.awt.Graphics;

class Naruto extends Character{
  Sprites naruto;
  private double delay;
  Collision normalAttackHitbox;
  Projectile narutoProjectile=new NarutoProjectile(0,0,2);
  
  //constructor
  Naruto(int health,double positionX,double positionY,int speed){
    super(health,positionX,positionY,speed);
    naruto = new Sprites(positionX, positionY);
    normalAttackHitbox=new Collision(positionX,positionY,5,5);
  }
  
  //methods
  //movement methods
  public void updateMove(){   //updates image in the sprite class
    naruto.move2(getMovement());
  }
    public boolean getOrientation(){
    return(naruto.getFacingLeft());
  }
    
    //attack methods
  public void updateAttack(int attack){  //updates the image to attack in sprite class
    naruto.attack2(attack);
  }
  
  public void normalAttack(){
    setDamage(5);
    delay = 0.5;
    setAttackBoxCreated(true);
    updateAttack(1);
  }
  
  public void specialAttack(){
    updateAttack(2);
    setProjectileDirection();
    updateProjectile();
    projectileAttack();
    setProjectileCreated(true);
  }
  
  public double getDelay(){
    return delay;
  }
  //get and update the attack hitbox
  public Collision getAttackHitbox(){   //return attack hitbox
    return normalAttackHitbox;
  }
  public void updateAttackHitbox(){   //update attack hitbox based on orientation
    if(naruto.getFacingLeft()==true){
      normalAttackHitbox.update(getPositionX(),getPositionY()+12,getImageHeight()-37,getImageWidth()-35);
    }else if(naruto.getFacingLeft()==false){
      normalAttackHitbox.update(getPositionX()+35,getPositionY()+12,getImageHeight()-37,getImageWidth()-35);
    }
  }
  
  //projectile methods
  public boolean getProjectileCreated(){   //find out if projectile created
    return narutoProjectile.getProjectileCreated();
  }
  public void setProjectileCreated(boolean created){  //set projectile created
    narutoProjectile.setProjectileCreated(created);
  }
  public void moveProjectile(){    //move projectile and projectile hitbox
    narutoProjectile.move();
    updateProjectileHitbox(getProjectileImageHeight(),getProjectileImageWidth());
  }
  public void drawProjectile(Graphics g){
    narutoProjectile.draw(g);
  }
  public double getProjectileX(){
    return narutoProjectile.getPositionX();
  }
  public double getProjectileY(){
    return narutoProjectile.getPositionY();
  }
  public int getProjectileImageHeight(){    //get height
    return narutoProjectile.getImageHeight();
  }
  public int getProjectileImageWidth(){   //get width
    return narutoProjectile.getImageWidth();
  }
  public int getProjectileDamage(){  
    return narutoProjectile.getDamage();
  }
  public void setProjectileDirection(){
    narutoProjectile.setDirection(naruto.getFacingLeft());
  }
  public void updateProjectile(){    //update projectile position
    narutoProjectile.update(getPositionX(),getPositionY());
  }
  public void projectileAttack(){   //run the attack method in the projectile class
    narutoProjectile.attack();
  }

  //get and update the projectile hitbox
  public Collision getProjectileHitbox(){   //return projectile hitbox
    return narutoProjectile.getHitbox();
  }
  public void updateProjectileHitbox(int height, int width){  //update projectile hitbox
    narutoProjectile.updateHitbox(height,width);
  }

  //image methods
    public int getImageHeight(){
    return naruto.getImageHeight();
  }
  
  public int getImageWidth(){
    return naruto.getImageWidth();
  }
  
  //draw character
  public void draw(Graphics g){
    naruto.draw(g,getPositionX(),getPositionY());
  }

}