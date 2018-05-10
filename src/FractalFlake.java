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

	private int size;
	private int limit;

	/* This constructor takes the x and y coordinate
	 * values in through the constructor here. 
	 * The values are passed to the super class (Shape)
	 * constructor for assignment. The values are obtained
	 * by calling getX() or getY() from this class. 
	 * The constructor below will also set the "size"
	 * of the line to the private instance variable
	 * and the "numBranches" to the variable for the
	 * number of "branches", or recursive passes that will
	 * be made before the base case is reached
	 * */
	public FractalFlake(int x, int y, int size, int limit) {
		super(x,y); //passed to the super class
		this.size = size;
		this.limit = limit;
	}

	/* This method is overridden by the method below and called
	 * when the line is bring drawn for each recursive call.
	 * */
	@Override
	public void draw(Graphics g){
		draw(g, getX(), getY(),size, limit);
	}

	public void draw(Graphics g, int x, int y, int size, int limit) {
		for (int i=0;i<360;i+=60) { //go in a complete circle
			double rad = i * Math.PI / 180; //convert radians to degrees
			/*using the cos() and sin() functions we can get 
			 * the offset for the points to draw TO which should be 
			 * the action of setting new x,y coordinates to set 
			 * the line to draw TO.*/
			final int x2 = (int) (x + Math.cos(rad) * size);
			final int y2 = (int) (y + Math.sin(rad) * size);

			if (limit >= 3) { //when recursive call takes in parameter value for "limit" and "limit" is less than or equal to 3
				//then the base case has been reached and the calls stop.
				g.drawLine(x, y, x2, y2);
				/*will send these values up to the draw() method above that's overloaded
				 * and only happens after a line is drawn. This ensures that when the line is drawn,
				 * the next one is drawn from that last "suspended" position, and then only continues
				 * to the next line when the base case is met. This happens until limit-1 <= 3*/
				draw(g, x2, y2, size/3, limit-1);
			}
		}
	}
}