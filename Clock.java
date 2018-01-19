/*
 * [Clock.java]
 * A class that tracks the time
 * January 1,2017
 * Author: Jaden Tang
*/

class Clock{
  //variables
  long elapsedTime;
  long lastTimeCheck;
  long currentTime=System.nanoTime();
  long winScreenTime;
  long winScreenCount=0;
  
  //constructor
  public Clock(){
    lastTimeCheck = System.nanoTime();
    elapsedTime = 0;
  }
  
  //methods 
  public void update(){
    currentTime = System.nanoTime();
    elapsedTime = currentTime - lastTimeCheck;
    lastTimeCheck = currentTime;
  }
  public long getCurrentTime(){
    currentTime=System.nanoTime();
    return currentTime;
  }
    public double getElapsedTime(){
    return elapsedTime;
  }
  
   //win screen methods
  public void setWinScreenTime(){  //for determining the time when the game finishes
    if(winScreenCount==0){
       winScreenTime=System.nanoTime();
       winScreenCount=1;
    }
  }
  public long getWinScreenTime(){
   return winScreenTime; 
  }

}