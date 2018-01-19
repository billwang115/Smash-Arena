/*win screen class
 * outputs the result
 * By:William Wang
 */
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;

class WinScreen{
  //declare variables
  BufferedImage gokuWinScreen;
  BufferedImage narutoWinScreen= new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_INDEXED);
  Font winFont=new Font("SansSerif",Font.BOLD,70);
  int screenHeight;
  int screenWidth;
  Color c = new Color(255,255,255);
  
  //constructor
  WinScreen(int screenWidth,int screenHeight){
    this.screenWidth=screenWidth;
    this.screenHeight=screenHeight;
    try{
      gokuWinScreen= new BufferedImage(screenWidth,screenHeight, BufferedImage.SCALE_DEFAULT);
      gokuWinScreen=ImageIO.read(new File("gokuWinScreen.png"));
    }catch(IOException e){
      System.out.println("goku win screen error"); 
    }
    try{
      narutoWinScreen=ImageIO.read(new File("narutoWinScreen.png"));
    }catch(IOException e){
      System.out.println("naruto win screen error"); 
    }
    
  }
  
  //methods
  public void draw(Graphics g,int characterWon,int playerWon){
    if(characterWon==1){
      g.drawImage(gokuWinScreen,0,0,screenWidth,screenHeight,null);
      g.setFont(winFont);
      g.setColor(c);
      g.drawString("The winner is ",100,550);
      g.drawString("PLAYER "+playerWon,100,630);
    }else if(characterWon==2){
      g.drawImage(narutoWinScreen,0,0,screenWidth,screenHeight,null); 
      g.setFont(winFont);
      g.drawString("The winner is ",100,550);
      g.drawString("PlAYER "+playerWon,100,630);
    }    
  }
  
}