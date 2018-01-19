/*main method class
 * has main method and gui
 * By:William Wang and Jaden Tang
 */

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.ImageIcon;

class PlayerMapMovement{     //main class 
  public static void main(String[] args){
    GUI game = new GUI();
  }
}

class GUI extends JFrame{   //gui class
  public GUI(){
    setTitle("Smash Arena");
    setSize(1000,1024);
    setResizable(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add( new GamePanel());
    pack();
    setVisible(true);
  }
}

class GamePanel extends JPanel implements KeyListener{   //game panel
  Player one = new Player();
  Player two = new Player();  
  Character character1 = new Goku(0,200,350,20);
  Character character2 = new Naruto(0,700,350,20);
  GameUI inGame= new GameUI();
  Stage finalDest = new FinalDestination(1024,768);
  Clock clock;
  Screen gameScreens=new Screen(1024,768);
  Boolean keyPressed=false;
  int inputKey;   //variable to set player one keyboard input
  int inputKey2;  //variable to set player two keyboard input
  
  public GamePanel(){     //constructor
    setPreferredSize(new Dimension(1024,768));
    addKeyListener(this);
    setFocusable(true);
    requestFocusInWindow();
    clock = new Clock();
    one.setLives(3);
    two.setLives(3);
  }
  
  
  public void paintComponent(Graphics g){    //paint compoenent
    super.paintComponent(g);
    if(gameScreens.getGameRunning()!=true&&gameScreens.getCurrentScreen()==0){
      gameScreens.drawStartScreen(g);
      if(keyPressed==true){
        gameScreens.setCurrentScreen(1);
        keyPressed=false;
      }
    }
    if(gameScreens.getGameRunning()!=true&&gameScreens.getCurrentScreen()==1){     //draw control screen
      gameScreens.drawControlScreen(g);
      if(keyPressed==true){
        gameScreens.setCurrentScreen(2);
        keyPressed=false;
      }
    }
    if(gameScreens.getGameRunning()!=true&&gameScreens.getCurrentScreen()==2){    //draw character select screen
      gameScreens.moveButtons(inputKey,inputKey2);  
      gameScreens.drawCharacterSelectScreen(g);
      if(gameScreens.getCharacter1()==1){
        character1=new Goku(0,200,350,20);
      }
      if(gameScreens.getCharacter1()==2){
        character1=new Naruto(0,200,350,20);
      }
      if(gameScreens.getCharacter2()==1){
        character2=new Goku(0,700,350,20);
      }
      if(gameScreens.getCharacter2()==2){
        character2=new Naruto(0,700,350,20);
      }
      gameScreens.updateScreen();
    }
    if(gameScreens.getGameRunning()==true){          //if game is running
      //detect input key pressed(input handler)
      //character 1
      if(inputKey==1){
        character1.left();
        character1.updateMove(); 
        inputKey=0;
      }
      if(inputKey==2){
        character1.down();
        character1.updateMove();
        inputKey=0;
      }
      if(inputKey==3){
        character1.right();
        character1.updateMove();
        inputKey=0;
      }
      if(inputKey==4){
        character1.jump();
        character1.updateMove();
        inputKey=0;
      }
      if(inputKey==5){
        character1.normalAttack();
        inputKey=0;
      }
      if(inputKey==6){
        character1.specialAttack();
        inputKey=0;
      }
      if(inputKey==7){
        character1.setShieldCreated(true);
        inputKey=0;
      }
      //character2
      if(inputKey2==1){
        character2.left();
        character2.updateMove();
        inputKey2=0;
      }
      if(inputKey2==2){
        character2.down();
        character2.updateMove();
        inputKey2=0;
      }
      if(inputKey2==3){
        character2.right();
        character2.updateMove();
        inputKey2=0;
      }
      if(inputKey2==4){
        character2.jump();
        character2.updateMove();
        inputKey2=0;
      }
      if(inputKey2==5){
        character2.normalAttack();
        inputKey2=0;
      }
      if(inputKey2==6){
        character2.specialAttack();
        inputKey2=0;
      }
      if(inputKey2==7){
        character2.setShieldCreated(true);
        inputKey2=0;
      }
      //detect input key released
      //character 1
      if(inputKey==-1){
        character1.stop();
        character1.updateMove();
      }
      if(inputKey==-2){
        character1.stop();
        character1.updateMove();
      }
      if(inputKey==-3){
        character1.stop();
        character1.updateMove();
      }
      if(inputKey==-4){
        character1.stop();
        character1.updateMove();
      }
      if(inputKey==-5){
        character1.stop();
        character1.updateMove();
        character1.setAttackBoxCreated(false);
      }
      if(inputKey==-6){
        character1.stop();
        character1.updateMove();
      }
      if(inputKey==-7){
        character1.setShieldCreated(false);
      }
      
      //character 2
      if(inputKey2==-1){
        character2.stop();
        character2.updateMove();  
      }
      if(inputKey2==-2){
        character2.stop();
        character2.updateMove();
      }
      if(inputKey2==-3){
        character2.stop();
        character2.updateMove();
      }
      if(inputKey2==-4){
        character2.stop();
        character2.updateMove();
      }
      if(inputKey2==-5){
        character2.stop();
        character2.updateMove();
        character2.setAttackBoxCreated(false);
      }
      if(inputKey2==-6){
        character2.stop();
        character2.updateMove();
      }
      if(inputKey2==-7){
        character2.setShieldCreated(false);
      }
      //end of input handler
      
      if (character2.getHealth() >= 100){  //if health is over 100
        character2.setDead(true);
        two.reduceLives();
      }
      if (character1.getHealth() >= 100){   //if health is over 100
        character1.setDead(true);
        one.reduceLives();
      }
      if (!character2.getCharacterHitbox().boundingBox.intersects(finalDest.getMapHitbox().boundingBox)){   //if character2 is offscreen
        character2.setDead(true);
        two.reduceLives();
      }
      if (!character1.getCharacterHitbox().boundingBox.intersects(finalDest.getMapHitbox().boundingBox)){   //if character1 is offscreen
        character1.setDead(true);
        one.reduceLives();
      }
      if (character2.getCharacterHitbox().boundingBox.intersects(finalDest.getStageHitbox().boundingBox)){  //if character2 is offstage
        if(character2.getPositionY() >= finalDest.getStageHitbox().positionY){
          character2.setPositionY(finalDest.getStageHitbox().positionY);
          character2.resetJumps();
        }else{
          character2.falling(); 
        }
      }else{
        character2.falling();
      }
      if (character1.getCharacterHitbox().boundingBox.intersects(finalDest.getStageHitbox().boundingBox)){   //if character1 is offstage
        if(character1.getPositionY() >= finalDest.getStageHitbox().positionY){
          character1.setPositionY(finalDest.getStageHitbox().positionY);
          character1.resetJumps();
        }else{
          character1.falling();
        }
      }else{
        character1.falling();
      }
      if(one.getLose()==true){       //if player one loses
        finalDest.draw(g);
        inGame.drawGameOver(g);
        clock.setWinScreenTime();
        if((clock.getCurrentTime()-clock.getWinScreenTime())>(5*300000000)){
          gameScreens.drawWinScreen(g,gameScreens.getCharacter2(),2);
        }     
      }else if(two.getLose()==true){    //if player two loses
        finalDest.draw(g);
        inGame.drawGameOver(g);
        clock.setWinScreenTime();
        if((clock.getCurrentTime()-clock.getWinScreenTime())>(5*300000000)){
          gameScreens.drawWinScreen(g,gameScreens.getCharacter1(),1);
        }
      }else{
        finalDest.draw(g);
        inGame.drawIcons(g,gameScreens.getCharacter1(),gameScreens.getCharacter2(),one.getLives(),two.getLives(),character1.getHealth(),character2.getHealth());
        if((character1.getDead())==true){   //respawn characters
          if(gameScreens.getCharacter1()==1){
            character1=new Goku(0,finalDest.respawnPointX(),finalDest.respawnPointY(),20);
          }else if(gameScreens.getCharacter1()==2){
            character1=new Naruto(0,finalDest.respawnPointX(),finalDest.respawnPointY(),20);
          }
          character1.updateMove();
          character1.setDead(false);
        }
        if((character2.getDead())==true){    //respawn characters
          if(gameScreens.getCharacter2()==2){
            character2=new Naruto(0,finalDest.respawnPointX(),finalDest.respawnPointY(),20);
          }else if(gameScreens.getCharacter2()==1){
            character2=new Goku(0,finalDest.respawnPointX(),finalDest.respawnPointY(),20);
          }
          character2.updateMove();
          character2.setDead(false);
        }
        //character 1 draw
        character1.draw(g);
        if(character1.getProjectileCreated()==true){   //draw projectile
          character1.moveProjectile();
          character1.drawProjectile(g); 
        }
        //character 2 draw
        character2.draw(g);
        if(character2.getProjectileCreated() == true){  //draw projectile 
          character2.moveProjectile();
          character2.drawProjectile(g);
        }
        character2.updateCharacterHitbox(character2.getImageHeight(), character2.getImageWidth());   //update character hitbox
        character1.updateCharacterHitbox(character1.getImageHeight(), character1.getImageWidth());   //update character hitbox
        if(character2.getAttackBoxCreated() == true){   //update attack hitbox
          character2.updateAttackHitbox();
        }
        if(character1.getAttackBoxCreated()==true){    //update attack hitbox
          character1.updateAttackHitbox();
        }
        if (character2.getAttackHitbox().boundingBox.intersects(character1.getCharacterHitbox().boundingBox)&&character2.getAttackBoxCreated()==true){ //if character2 attack collides with character 1
          character2.setAttackBoxCreated(false);
          character1.injured();
          inputKey=0;
          character1.updateMove();
          character1.setHealth(character2.getDamage());
        }
        
        if (character2.getProjectileHitbox().boundingBox.intersects(character1.getCharacterHitbox().boundingBox)&&character2.getProjectileCreated()==true){ //if character2 projectile collides with character1
          character1.injured();
          inputKey=0;
          character1.updateMove();
          character1.setHealth(character2.getProjectileDamage());
          character2.setProjectileCreated(false);
        }
        if (!character2.getProjectileHitbox().boundingBox.intersects(finalDest.getMapHitbox().boundingBox)){   //if character2 projectile is offscreen
          character2.setProjectileCreated(false);
        }
        if (character1.getAttackHitbox().boundingBox.intersects(character2.getCharacterHitbox().boundingBox)&&character1.getAttackBoxCreated()==true){ //if character1 hitbox collides with character2 
          character1.setAttackBoxCreated(false);
          character2.injured();
          inputKey2=0;
          character2.updateMove();
          character2.setHealth(character1.getDamage());
        }
        if (character1.getProjectileHitbox().boundingBox.intersects(character2.getCharacterHitbox().boundingBox)&&character1.getProjectileCreated()==true){ //if character1 projectile collides with charracter2
          character1.setProjectileCreated(false);
          character2.injured();
          inputKey2=0;
          character2.updateMove();
          character2.setHealth(character1.getProjectileDamage());
        }
        if (!character1.getProjectileHitbox().boundingBox.intersects(finalDest.getMapHitbox().boundingBox)){  //if character1 projectile is offscreen
          character1.setProjectileCreated(false);
        }
        //shield stuff
        if(character1.getShieldCreated()==true){  //if character1 shield is created
          character1.updateShield(0);
          character1.drawShield(g);
        }else{
          character1.setShieldCreated(false);
        }
        if(character2.getShieldCreated()==true){  //if character2 shield is created
          character2.updateShield(0);
          character2.drawShield(g);
        }else{
          character2.setShieldCreated(false);
        }
        inGame.drawFrameRate(g);   //draw framerate
      }
    }
    repaint();
  }
  
  public void keyTyped(KeyEvent e){
  }
  
  public void keyPressed(KeyEvent e){    //key pressed
    //player 1 stuff
    keyPressed=true;   //for the controls screen to determine when any button is pressed not just the specific ones in the if statements
    if(e.getKeyChar() == 'a'){  
      inputKey=1;
    } 
    if(e.getKeyChar() == 's' ){
      inputKey=2;
    }
    if(e.getKeyChar() == 'd' ){
      inputKey=3;
    }
    if(e.getKeyChar() == 'w' ){
      inputKey=4;
    }
    if(e.getKeyChar() == 'v' ){   
      inputKey=5;
    }
    if(e.getKeyChar() == 'b' ){
      inputKey=6;
    }
    if(e.getKeyChar()== 'c'){
      inputKey=7;
    }
    
    //player 2 stuff
    if(e.getKeyCode() == KeyEvent.VK_LEFT){     
      inputKey2=1;
    } 
    if(e.getKeyCode() == KeyEvent.VK_DOWN){
      inputKey2=2;
    }
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      inputKey2=3;
    }
    if(e.getKeyCode() == KeyEvent.VK_UP){
      inputKey2=4;
    }
    if(e.getKeyChar() == ','){
      inputKey2=5;
    }
    if(e.getKeyChar() == '.'){
      inputKey2=6;
    }
    if(e.getKeyChar()=='/'){
      inputKey2=7;
    }
  }
  
  public void keyReleased(KeyEvent e){
    //player 1 stuff
    if(e.getKeyChar() == 'a'){
      inputKey=-1;
    }
    if(e.getKeyChar() == 's' ){
      inputKey=-2;
    }
    if(e.getKeyChar() == 'd' ){
      inputKey=-3;
    }
    if(e.getKeyChar() == 'w' ){
      inputKey=-4;
    }
    if(e.getKeyChar() == 'v' ){
      inputKey=-5;
    }
    if(e.getKeyChar() == 'b' ){
      inputKey=-6;
    }
    if(e.getKeyChar() == 'c'){
      inputKey=-7;
    }
    
    //player 2 stuff
    if(e.getKeyCode() == KeyEvent.VK_LEFT){
      inputKey2=-1;
    }
    if(e.getKeyCode() == KeyEvent.VK_DOWN){
      inputKey2=-2;
    }
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      inputKey2=-3;
    }
    if(e.getKeyCode() == KeyEvent.VK_UP){
      inputKey2=-4;
    }
    if(e.getKeyChar() == ',' ){
      inputKey2=-5;
    }
    if(e.getKeyChar() == '.' ){
      inputKey2=-6;
    }
    if(e.getKeyChar() == '/' ){
      inputKey2=-7;
    }
  }
}

