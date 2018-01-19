/*Sprite class
 * draw the sprite images
 * By:William Wang
 */
//import classes
import java.awt.image.BufferedImage;
import java.awt.image.AffineTransformOp;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Sprites{
  //declare variables
  private double positionX;
  private double positionY;
  private boolean facingLeft;
  //goku movement sprites
  BufferedImage currentImage=null;
  BufferedImage gokuJump= new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage gokuCrouch=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage gokuRight=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage gokuStance=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage gokuInjured=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  //goku attack sprites
  BufferedImage gokuNormalAttack=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage gokuSpecialAttack=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage gokuSpecialProjectile=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  
  //naruto movement sprites
  BufferedImage narutoJump=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage narutoCrouch=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage narutoRight=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage narutoStance=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage narutoInjured=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  //naruto attack sprites
  BufferedImage narutoNormalAttack=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage narutoSpecialAttack=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  BufferedImage narutoSpecialProjectile=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
//constructor
  Sprites(double positionX,double positionY){
    this.positionX=positionX;
    this.positionY=positionY;
    try{
      gokuJump=ImageIO.read(new File("gokuJump.png"));
      gokuCrouch=ImageIO.read(new File("gokuCrouch.png"));
      gokuRight=ImageIO.read(new File("gokuRun.png"));
      gokuStance=ImageIO.read(new File("gokuStance.png"));
      gokuInjured=ImageIO.read(new File("gokuInjured.png"));
      gokuNormalAttack=ImageIO.read(new File("gokuNormalAttack.png"));
      gokuSpecialAttack=ImageIO.read(new File("gokuSpecialAttack.png"));
      gokuSpecialProjectile=ImageIO.read(new File("gokuSpecialProjectile.png"));
    }catch(IOException e){
      System.out.println("Goku Error: "+e);
    }
    try{
      narutoJump=ImageIO.read(new File("narutoJump.png"));
      narutoCrouch=ImageIO.read(new File("narutoCrouch.png"));
      narutoRight=ImageIO.read(new File("narutoRun.png"));
      narutoStance=ImageIO.read(new File("narutoStance.png"));
      narutoInjured=ImageIO.read(new File("narutoInjured.png"));
      narutoNormalAttack=ImageIO.read(new File("narutoNormalAttack.png"));
      narutoSpecialAttack=ImageIO.read(new File("narutoSpecialAttack.png"));
      narutoSpecialProjectile=ImageIO.read(new File("narutoSpecialProjectile.png"));
    }catch(IOException e){
      System.out.println("Naruto Error: "+e);
    }
  }
  
//methods
  //set movement image
  //goku movement
  public void move(int movement){
    if(movement==0){     //standing
      currentImage=gokuStance;
    }
    if (movement==1){        //up
      currentImage=gokuJump; 
    }
    if(movement==2){       //right
      currentImage=gokuRight;
      facingLeft=false;
    }
    if(movement==3){       //down
      currentImage=gokuCrouch;
    }
    if(movement==4){       //left
      BufferedImage gokuLeft=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
      gokuLeft=gokuRight;
      currentImage=gokuLeft;   //image is flipped in the draw method
      facingLeft=true;
    }    
    if(movement==5){
             currentImage=gokuInjured;
    }
  }
  //naruto movement
  public void move2(int movement){
    if(movement==0){     //standing
      currentImage=narutoStance;
    }
    if (movement==1){     //up
      currentImage=narutoJump; 
    }
    if(movement==2){      //right
      currentImage=narutoRight;
      facingLeft=false;
    }
    if(movement==3){      //down
      currentImage=narutoCrouch;
    }
    if(movement==4){      //left
      BufferedImage narutoLeft=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
      narutoLeft=narutoRight;
      currentImage=narutoLeft;      //image is flipped in the draw method
      facingLeft=true;
    }
    if(movement==5){
      currentImage=narutoInjured;
    }
  }
  //set Attack image
  //goku attacks
  public void attack(int attack){
    if(attack==1){        //normal
      currentImage=gokuNormalAttack;
    }
    if(attack==2){      //special
      currentImage=gokuSpecialAttack;
    }
  }
  public void projectileAttack(){
    currentImage=gokuSpecialProjectile;
  }
  
  //naruto attacks
  public void attack2(int attack){
    if(attack==1){     //normal
      currentImage=narutoNormalAttack;
    }
    if(attack==2){     //special
      currentImage=narutoSpecialAttack;
    }
  }
   public void projectileAttack2(){
    currentImage=narutoSpecialProjectile;
   }
      
  //return orientation                         //these methods are only used by the projectile classes
  public boolean getFacingLeft(){
    return facingLeft;
  }
  public void setFacingLeft(boolean direction){
    this.facingLeft=direction;
  }
  
  //get image size
    public int getImageHeight(){
    int height = 21;
    if (currentImage != null){
      height = currentImage.getHeight();
    }
    return height;
  }  
  public int getImageWidth(){
    int width = 69;
    if (currentImage != null){
      width = currentImage.getWidth();
    }
    return width;
    }
  
  //draw sprites
  public void draw(Graphics g,double positionX,double positionY){
    if(facingLeft==true){
      BufferedImage flippedImage=new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
      flippedImage=currentImage;
      AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
      tx.translate(-flippedImage.getWidth(null), 0);
      AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
      flippedImage=op.filter(flippedImage,null);
      g.drawImage(flippedImage,(int)positionX,(int)positionY,null);
    }else{
      g.drawImage(currentImage,(int)positionX,(int)positionY,null);
    }
  }
    
}