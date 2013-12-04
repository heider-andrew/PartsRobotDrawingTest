

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GUIPartsRobot{

	String name;
	//0 degrees means hand 1 is pointing up
	//part in hand 1
	//GUIPart handOnePart;
	//part in hand 2
	//GUIPart handTwoPart;
	//part in hand 3
	//GUIPart handThreePart;
	//part in hand 4
	//GUIPart handFourPart;
	//GUI Component for getting parts
	//GUIComponent getterComponent;
	//PartsRobot Agent
	//PartsRobotAgent myAgent;
	//Nests
	//GUINest nest1, nest2, nest3, nest4, nest5, nest6, nest7, nest8;
	//KitStands
	//GUIKitStand kitStand1, kitStand2;
	//GUIFactoryFloor
	//GUIComponent factoryFloor;
	//location and rotation information
	public int xPos, yPos, xDest, yDest;
	private static final int XIDLE = 20, YIDLE = 20;
	//0 degrees means hand 1 is pointing up
	private double rotationAngle, rotationDest;
	//image information
	private int width, heigth, armWidth, armHeigth, clampWidth, clampHeigth, beamWidth, beamHeigth;
	private static final int stdArmWidth = 11, stdArmHeigth = 28;
	private static final int stdClampWidth = 14, stdClampHeigth = 28;
	private static final int stdBeamWidth = 28, stdBeamHeigth = 5;
	private static final int stdWidth = 80, stdHeight = 80;
	private final ImageIcon myBodyImage = new ImageIcon("images/parts_robot_body.png");
	private final ImageIcon myArmImage = new ImageIcon("images/parts_robot_arm.png");
	private final ImageIcon myLeftClampImage = new ImageIcon("images/parts_robot_clampL.png");
	private final ImageIcon myRightClampImage = new ImageIcon("images/parts_robot_clampR.png");
	private final ImageIcon myGripperImage = new ImageIcon("images/parts_robot_gripBeam.png");
	private Rectangle2D.Double PartRobotPlaceHolder;
	
	public void update()
	{
		//sets frame for the robot's placeholder
		PartRobotPlaceHolder.setFrame(this.xPos, this.yPos, this.width, this.heigth);
	}
	
	public void draw(Graphics2D g)
	{
		fancyMove();
		double myCenterX = (xPos + (width / 2));
		double myCenterY = (yPos + (heigth / 2));
		//rotate the whole factory
		g.rotate(Math.toRadians(rotationAngle), myCenterX, myCenterY);
		//draw hands set 1
		g.drawImage(myLeftClampImage.getImage(), xPos + (width/2) - (beamWidth/2), yPos - armHeigth - (clampHeigth/2), clampWidth, clampHeigth, null);
		g.drawImage(myRightClampImage.getImage(), xPos + (width/2), yPos - armHeigth - (clampHeigth/2), clampWidth, clampHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw hands set 2
		g.drawImage(myLeftClampImage.getImage(), xPos + (width/2) - (beamWidth/2), yPos - armHeigth - (clampHeigth/2), clampWidth, clampHeigth, null);
		g.drawImage(myRightClampImage.getImage(), xPos + (width/2), yPos - armHeigth - (clampHeigth/2), clampWidth, clampHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw hands set 3
		g.drawImage(myLeftClampImage.getImage(), xPos + (width/2) - (beamWidth/2), yPos - armHeigth - (clampHeigth/2), clampWidth, clampHeigth, null);
		g.drawImage(myRightClampImage.getImage(), xPos + (width/2), yPos - armHeigth - (clampHeigth/2), clampWidth, clampHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw hands set 4
		g.drawImage(myLeftClampImage.getImage(), xPos + (width/2) - (beamWidth/2), yPos - armHeigth - (clampHeigth/2), clampWidth, clampHeigth, null);
		g.drawImage(myRightClampImage.getImage(), xPos + (width/2), yPos - armHeigth - (clampHeigth/2), clampWidth, clampHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw gripper 1
		g.drawImage(myGripperImage.getImage(), xPos + (width/2) - (beamWidth/2), yPos - armHeigth - (beamHeigth/2), beamWidth, beamHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw gripper 2
		g.drawImage(myGripperImage.getImage(), xPos + (width/2) - (beamWidth/2), yPos - armHeigth - (beamHeigth/2), beamWidth, beamHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw gripper 3
		g.drawImage(myGripperImage.getImage(), xPos + (width/2) - (beamWidth/2), yPos - armHeigth - (beamHeigth/2), beamWidth, beamHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw gripper 4
		g.drawImage(myGripperImage.getImage(), xPos + (width/2) - (beamWidth/2), yPos - armHeigth - (beamHeigth/2), beamWidth, beamHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw arm 1
		g.drawImage(myArmImage.getImage(), xPos + (width/2) - (armWidth/2), yPos - armHeigth, armWidth, armHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw arm 2
		g.drawImage(myArmImage.getImage(), xPos + (width/2) - (armWidth/2), yPos - armHeigth, armWidth, armHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw arm 3
		g.drawImage(myArmImage.getImage(), xPos + (width/2) - (armWidth/2), yPos - armHeigth, armWidth, armHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw arm 4
		g.drawImage(myArmImage.getImage(), xPos + (width/2) - (armWidth/2), yPos - armHeigth, armWidth, armHeigth, null);
		g.rotate(Math.toRadians(90), myCenterX, myCenterY);
		//draw body
		g.drawImage(myBodyImage.getImage(), xPos, yPos, width, heigth, null);
		//rotate canvas back
		g.rotate(Math.toRadians(-1 * rotationAngle), myCenterX, myCenterY);
	}
	
	//getter for xPos
	public int getX() 
	{
		return xPos;
	}

	//getter for yPos
	public int getY() 
	{
		return yPos;
	}
	
	//old move function, unused
	/*public void moveToDest()
	{
		if (yPos < yDest) {
			yPos++;
		} else if (yPos > yDest) {
			yPos--;
		}
		if (xPos < xDest) {
			xPos++;
		} else if (xPos > xDest) {
			xPos--;
		}
		if (rotationDest != rotationAngle)
		{
			rotationAngle++;
			rotationAngle %= 360;
		}
	}
	*/
	
	//updates the rotationDestination
	public void rotate(int degrees)
	{
		rotationDest += degrees;
		rotationDest %= 360;
	}
	
	//complex move that changes rotation speed based on distance needed to be traveled
	private void fancyMove()
	{
		//checks and updates y location
		if (yPos < yDest) {
			yPos++;
		} else if (yPos > yDest) {
			yPos--;
		}
		//checks and updates x location
		if (xPos < xDest) {
			xPos++;
		} else if (xPos > xDest) {
			xPos--;
		}
		
		double toRotate;
		if (rotationDest != rotationAngle)
		{
			//rotates the robot by a number of radians devided by the distance needed to be traveled
			if (xPos != xDest || yPos != yDest){
				if (rotationDest > rotationAngle){
					toRotate = (rotationDest - rotationAngle) / (Math.sqrt(Math.pow(Math.abs(xDest-xPos),2) + Math.pow(Math.abs(yDest-yPos),2)));
					rotationAngle += toRotate;
					rotationAngle %= 360;
				} else {
					toRotate = (rotationAngle - rotationDest) / (Math.sqrt(Math.pow(Math.abs(xDest-xPos),2) + Math.pow(Math.abs(yDest-yPos),2)));
					rotationAngle -= toRotate;
					rotationAngle %= 360;
				}
			//prevents divide by zero by still allowing to rotate if at the destination location/doesnt move
			} else {
				rotationAngle++;
				rotationAngle %= 360;
			}
		}
	}
	
	//basic constructors
	public GUIPartsRobot()
	{
		width = stdWidth;
		heigth = stdHeight;
		armWidth = stdArmWidth;
		armHeigth = stdArmHeigth;
		clampWidth = stdClampWidth;
		clampHeigth = stdClampHeigth;
		beamWidth = stdBeamWidth;
		beamHeigth = stdBeamHeigth;
		PartRobotPlaceHolder = new Rectangle2D.Double(xPos, yPos, width, heigth);
	}
	
}
