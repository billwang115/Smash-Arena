/*game ui class
 * creates the character icons,health,lives and game over image
 *By:William Wang
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;

class GameUI{
  //declare variables 
  BufferedImage gameOver;
  BufferedImage gokuIcon;
  BufferedImage narutoIcon;
  Font livesFont=new Font("Century Gothic",Font.BOLD,40);
  FrameRate frameRate=new FrameRate();
  Color c = new Color(255,255,255);
  
//constructor
  GameUI(){
    try{
      gameOver=ImageIO.read(new File("gameOver.png"));
    }catch(IOException e){
      System.out.println("game over image error");
    } 
    try{
      gokuIcon=ImageIO.read(new File("gokuIcon.png"));
    }catch(IOException e){
      System.out.println("goku icon image error");
    }
    try{
      narutoIcon=ImageIO.read(new File("narutoIcon.png"));
    }catch(IOException e){
      System.out.println("naruto icon image error");
    }
  }
  
  //methods
  
  //drawFrameRate
  public void drawFrameRate(Graphics g){
    frameRate.update();
    frameRate.draw(g,0,500);
  }
  
  //draw gameover
  public void drawGameOver(Graphics g){
    g.drawImage(gameOver,300,300,null); 
  }
  
  //draw Icons,lives and health
  public void drawIcons(Graphics g,int character,int character2,int lives1,int lives2,int health1,int health2){
    if(character==1){
      g.drawImage(gokuIcon,70,50,null);
    }else if(character==2){
      g.drawImage(narutoIcon,70,50,null);
    }
    if(character2==1){
      g.drawImage(gokuIcon,830,50,null);
    }else if(character2==2){
      g.drawImage(narutoIcon,830,50,null);
    }
    //drawlives
    g.setColor(c);
    g.setFont(livesFont);
    g.drawString("x"+lives1,80,150);
    g.drawString("x"+lives2,840,150);
    //draw health
    g.setFont(livesFont);
    g.drawString(health1+"%",160,100);
    g.drawString(health2+"%",900,100);
  }
}