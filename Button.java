import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

class Button{
  int x, y;
  int xdirection, ydirection;
  
  BufferedImage redButton;
  BufferedImage blueButton;
  //constructor
  public Button(){
    loadButton();
    loadButton2();
    this.x = 50;
    this.y = 50;
    this.xdirection = 0;
    this.ydirection = 0;
  }
  //methods to get pictures
  public void loadButton(){
    try {
      redButton = ImageIO.read(new File("redButton.png"));
    } catch (Exception e){
      System.out.println("error loading red button");
    }
  }
  public void loadButton2(){
    try {
      blueButton = ImageIO.read(new File("blueButton.png"));
    } catch (Exception e){
      System.out.println("error loading blue button");
    }
  }
  //method to draw buttons
  public void draw(Graphics g){
    g.drawImage(redButton,x,y,50,50,null);
  }
  public void draw2(Graphics g){
    g.drawImage(blueButton,x,y,50,50,null);
  }
  
  public void move(){
    this.x = this.x + this.xdirection;
    this.y = this.y + this.ydirection;
  }
}