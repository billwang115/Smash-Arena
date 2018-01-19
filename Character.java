/* Character class
 * Super class for the characters
 * By:William Wang and Jaden Tang
 */
import java.awt.Graphics;

abstract class Character{
  //variables
  private int health=0;
  private double positionX;
  private double positionY;
  private double speed;
  private int movement=0;     //variable for the movement direction
  private int hasJumps=5;     //variable determining max number of jumps offstage
  private boolean dead=true;
  private int damage;
  Shield characterShield;
  Clock counter=new Clock();
  private long lastJumped;     //time of last jump
  private boolean attackBoxCreated;
  Collision characterHitbox;
  
  //constructors
  Character(int health,double positionX, double positionY, int speed){
    this.health=health;
    this.positionX=positionX;
    this.positionY=positionY;
    this.speed=speed;
    characterShield=new Shield(30,60,62,positionX,positionY);
    characterHitbox=new Collision(positionX,positionY,45,60);
  }
  
  //methods
  
  //movement methods
  public void jump(){
    //jump
    //or up
    if(hasJumps!=0){
      lastJumped=counter.getCurrentTime();
      hasJumps=hasJumps-1;
      positionY=positionY-70;
      movement=1;
    }
  }
  public void right(){
    //right
    positionX=positionX+1*speed;
    movement=2;
  }
  public void down(){
    //down
    positionY=positionY+(1*speed)/4;
    movement=3;
  }
  public void left(){
    //left 
    positionX=positionX-1*speed;
    movement=4;
  }
  public void stop(){
    movement = 0;
  }
  public void injured(){
    movement=5;
  }
  public void falling(){
    if(counter.getCurrentTime()-lastJumped>500000000){     //delay the fall after a jump
      positionY=positionY+1.2;
    }
  }
  public int getMovement(){   //returns direction of input
    return movement;
  }
  public void resetJumps(){ 
    hasJumps=5;
  }
  abstract void updateMove();  ///overriden
  abstract void updateAttack(int attack);  //overriden
  abstract boolean getOrientation();   //overriden   
    abstract void draw(Graphics g);  ///overridden
    
  //position methods
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
  
 //health methods
  public int getHealth(){
    return health;
  }
  public void setHealth(int health){
    this.health=this.health+health;
  }
  
  //death methods
  public boolean getDead(){
    return dead;
  }
  public void setDead(boolean dead){
    this.dead=dead;
  }
    //attack methods
  public int getDamage(){
    return damage;
  }
  public void setDamage(int damage){
    this.damage = damage;
  }
  abstract void normalAttack();     //overridden
  abstract void specialAttack();    //overridden
  
  //shield methods
  public void updateShield(int damage){
    characterShield.update(positionX,positionY,damage);     //update position
  }
  public void drawShield(Graphics g){
    if(characterShield.getShieldDestroyed()!=true){
      characterShield.draw(g);  
    }
  }
  public boolean getShieldCreated(){
    return characterShield.getShieldCreated();
  }
  public void setShieldCreated(boolean created){
    characterShield.setShieldCreated(created);  
  }
  
  //draw attack methods
  public boolean getAttackBoxCreated(){      //get punch attack hitbox
    return attackBoxCreated;
  }
  public void setAttackBoxCreated(boolean created){   //set punch attack hitbox
    this.attackBoxCreated=created;
  }
  //image methods
  abstract int getImageHeight(); //overridden
  abstract int getImageWidth();  //overridden

  //hitbox methods
  public Collision getCharacterHitbox(){  //return character hitbox
    return characterHitbox;
  }
  public void updateCharacterHitbox(int height,int width){
    characterHitbox.update(positionX,positionY,height,width);
  }
  
  //attack hitbox methods
  abstract Collision getAttackHitbox();       //overriden
  abstract void updateAttackHitbox();      //overridden 
  
  //projectile methods(all are overriden by character class)
  public boolean getProjectileCreated(){  //overriden
    boolean temp=false;
    return temp;
  }
  public void setProjectileCreated(boolean created){//overriden
  }
  public void moveProjectile(){//overriden
  }
  public void drawProjectile(Graphics g){//overriden
  }
  public double getProjectileX(){//overriden
    double temp=0;
    return temp;
  }
  public double getProjectileY(){//overriden
    double temp=0;
    return temp;
  }
  public int getProjectileImageHeight(){//overriden
    int temp=0;
    return temp;
  }
  public int getProjectileImageWidth(){//overriden
    int temp=0;
    return temp;
  }
  public int getProjectileDamage(){//overriden
    int temp=0;
    return temp;
  }
  public void setProjectileDirection(){//overriden
  }
  public void updateProjectile(){//overriden
  }
  public void projectileAttack(){//overriden
  }
  public Collision getProjectileHitbox(){//overriden
    Collision temp=new Collision(0,0,0,0);
    return temp;
  }
  public void updateProjectileHitbox(int height, int width){//overriden
  }
  
}