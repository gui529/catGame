package catGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
 private int xDirection, yDirection, xCoord, yCoord;
 private GameWindow gw;

 /**
  *Constructor passes GameWindow object.
  **/
 public Mouse(GameWindow gw) {
  this.gw = gw;
 }

 /**
  *Set Y Direction to either 0,1,-1.
  *@param dir direction to move. ( 0 stay still, 1 move up, -1 move down).
  *@throws Exception if dir not 0,1,-1.
  **/
 public void setXDirection(int dir) {
  if (dir > 1 || dir < -1)
   throw new IllegalArgumentException("Illegal X Direction: " + dir);
  xDirection = dir;
 }

 /**
  *Set Y Direction to either 0,1,-1.
  *@param dir direction to move. ( 0 stay still, 1 move right, -1 move left).
  *@throws Exception if dir not 0,1,-1.
  **/
 public void setYDirection(int dir) {
  if (dir > 1 || dir < -1)
   throw new IllegalArgumentException("Illegal Y Direction: " + dir);
  yDirection = dir;
 }

 /**
  *@return The direction of X. ( 0 still, 1 right, -1 left).
  **/
 public int getXDirection() {
  return xDirection;
 }

 /**
  *@return The direction of Y. ( 0 still, 1 Up, -1 down).
  **/
 public int getYDirection() {
  return yDirection;
 }

 /**
  *Get the coordinate of mouse and set xDirection and yDirection. 
  *@param e The X and Y coords of the mouse.
  **/
 @SuppressWarnings("static-access")
 public void mousePressed(MouseEvent e) {
  xCoord = e.getX();
  yCoord = e.getY();

  //Start game when clicked on start button.
  if (!gw.gamestart) {
   if (xCoord > 150 && xCoord < 450 && yCoord > 200 && yCoord < 300) {
    gw.gamestart = true;
   }
  }
  //When game Starts, get position of mouse and cat and compare.
  else {
   if (xCoord > gw.getx()) {
    setXDirection(1);
   }
   if (xCoord < gw.getx()) {
    setXDirection(-1);
   }
   if (yCoord > gw.gety()) {
    setYDirection(1);
   }
   if (yCoord < gw.gety()) {
    setYDirection(-1);
   }
  }
  //Draw on canvas with the new positions.
  gw.paintComponent(gw.dbg);
 }

 /**
  *@return X Coord of mouse.
  **/
 public int getXCoord() {
  return xCoord;
 }

 /**
  *@return Y Coord of mouse.
  **/
 public int getYCoord() {
  return yCoord;
 }
}