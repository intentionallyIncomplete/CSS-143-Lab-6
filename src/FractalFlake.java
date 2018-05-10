import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/****************************************/
/*			CLASS DESCRIPTION			*/
/* This class, FractalFlake, will use	*/
/* recursion in the draw() method to	*/
/* create a recursive line				*/
/****************************************/

public class FractalFlake extends Shape {

	private final int LIMIT = 3;
	private int NUM_BRANCHES = 3;
	private int size;

	/* This constructor takes the x and y coordinate
	 * values in through the constructor here. 
	 * The values are passed to the super class (Shape)
	 * constructor for assignment. The values are obtained
	 * by calling getX() or getY() from this class. 
	 * The constructor below will also set the "size"
	 * of the line to the private final int instance variable
	 * and the "numBranches" to the variable for the
	 * number of "branches", or recursive passes that will
	 * be made before the base case is reached
	 * */
	public FractalFlake(int x, int y, int size) {
		super(x,y); //passed to the super class
		this.size = size;
	}

	public void draw(Graphics g, int size){
		int x2 = getX() + 10;
		int y2 = getY() + 5;
		if(size == 1){
			g.drawLine(getX(), getY(), x2, y2);
		}else{
			draw(g, size-1);
		}
	}
}