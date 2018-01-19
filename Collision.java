/*collision class
 * Creates the bounding boxes for the characters and detect collision
 * By:William Wang
 */

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;

class Collision{
  //declare variables
  double positionX, positionY;
  double speedX;
  int height, width;
  Rectangle boundingBox;
  Color c = new Color(1f,0f,0f,0.2f);
  
  //constructor
  Collision(double x,double y,int h,int w){
    positionX = x;
    positionY = y;
    height = h;
    width = w;
    boundingBox = new Rectangle((int)positionX,(int)positionY,height,width);
  }
  
  //methods
  
  //Update the content
  public void update(double positionX, double positionY,int height,int width){
    boundingBox.x = (int)positionX;
    this.positionX = positionX;
    boundingBox.y = (int)positionY;
    this.positionY = positionY;
     boundingBox.height = height;
    boundingBox.width = width;
  }
  
  public void draw(Graphics g){   //draw the hitbox (for testing)
    g.setColor(c);
    g.fillRect((int)boundingBox.x, (int)boundingBox.y, (int)boundingBox.width, (int)boundingBox.height);
  }
}