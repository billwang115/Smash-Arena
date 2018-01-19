/*Player class
 * Create players and keep track of scores
 * By:William Wang
 */

class Player{
  
  //declare variables
  int lives;
  boolean lose=false;
  
  //methods
  public boolean getLose(){
    if(lives==0){
      lose=true;
    }
    return lose;
  }
  public int getLives(){
    return lives;
  }
  public void setLives(int lives){
    this.lives=lives;
  }
  public void reduceLives(){
    this.lives=lives-1;
  }
  
}