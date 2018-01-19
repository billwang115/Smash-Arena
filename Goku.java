/*Goku character class
 * Create the goku character
 * By:William Wang
 */
import java.awt.Graphics;

class Goku extends Character{
  //declare variables
  Sprites goku;
  private double delay;
  Collision normalAttackHitbox;
  Projectile gokuProjectile=new GokuProjectile(0,0,2);
  
  //constructor
  Goku(int health, double positionX, double positionY, int speed){
    super(health,positionX,positionY,speed);
    goku = new Sprites(positionX,positionY);
    normalAttackHitbox=new Collision(positionX,positionY,5,5);
  }
  
  //methods  
  //movement method
  public void updateMove(){   //updates movement direction to sprite class
    goku.move(getMovement());
  }
    //get orientation
  public boolean getOrientation(){
    return (goku.getFacingLeft());
  }
  
  //Attack methods
  public void updateAttack(int attack){  //update sprite image to attack
    goku.attack(attack);
  }
  public void normalAttack(){  //normal attack
    setDamage(5);
    delay=0.5;
    setAttackBoxCreated(true);
    updateAttack(1);
  }
  public void specialAttack(){   //special attack
    //damage is given through the projectile
    updateAttack(2);
    setProjectileDirection();
    updateProjectile();  //update projectile location
    projectileAttack();  //run special attack method in projectile class
    setProjectileCreated(true);
    delay=1;
  }
  public double getDelay(){  //return attack delay
    return delay;
  }  
    //get and update the attack hitbox
  public Collision getAttackHitbox(){   //return the punch attack hitbox
    return normalAttackHitbox;
  }
  public void updateAttackHitbox(){   //create the punch hitbox based on the character location
    if(goku.getFacingLeft()==true){
      normalAttackHitbox.update(getPositionX(),getPositionY()+15,getImageHeight()-37,getImageWidth()-35);
    }else if(goku.getFacingLeft()==false){
      normalAttackHitbox.update(getPositionX()+35,getPositionY()+15,getImageHeight()-37,getImageWidth()-35);
    }
  }

  //image methods
    public int getImageHeight(){ //return image height from sprite class
    return goku.getImageHeight();
  }
  
  public int getImageWidth(){  //return image width from sprite class
    return goku.getImageWidth();
  }
  
  //projectile methods
  public boolean getProjectileCreated(){
    return gokuProjectile.getProjectileCreated();
  }
  public void setProjectileCreated(boolean created){
    gokuProjectile.setProjectileCreated(created);
  }
  public void moveProjectile(){    //update the projectile location and the hitbox location
    gokuProjectile.move();
    updateProjectileHitbox(getProjectileImageHeight(),getProjectileImageWidth());
  }
  public void drawProjectile(Graphics g){
    gokuProjectile.draw(g);
  }
  public double getProjectileX(){
    return gokuProjectile.getPositionX();
  }
  public double getProjectileY(){
    return gokuProjectile.getPositionY();
  }
  public int getProjectileImageHeight(){  //get height of projectile image
    return gokuProjectile.getImageHeight();
  }
  public int getProjectileImageWidth(){   //get width of projectile image
    return gokuProjectile.getImageWidth();
  }
  public int getProjectileDamage(){
    return gokuProjectile.getDamage();
  }
  public void setProjectileDirection(){    //set direction of projectile as direction of character
    gokuProjectile.setDirection(goku.getFacingLeft());
  }
  public void updateProjectile(){           //update projectile location
    gokuProjectile.update(getPositionX(),getPositionY());
  }
  public void projectileAttack(){   //run the attack method in the goku projectile class (this is called by the special attack method above)
    gokuProjectile.attack();
  }   
  //get and update the projectile hitbox
  public Collision getProjectileHitbox(){  //return projectile hitbox
    return gokuProjectile.getHitbox();
  }
  public void updateProjectileHitbox(int height, int width){  //update the hitbox location
    gokuProjectile.updateHitbox(height,width);
  }

  //draw the character
  public void draw(Graphics g){
    goku.draw(g,getPositionX(),getPositionY());
  }
    
}