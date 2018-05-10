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
	 * of the line to the private final int instance variable
	 * and the "numBranches" to the variable for the
	 * number of "branches", or recursive passes that will
	 * be made before the base case is reached
	 * */
	public FractalFlake(int x, int y, int size, int limit) {
		super(x,y); //passed to the super class
		this.size = size;
		this.limit = limit;
	}

		@Override
		public void draw(Graphics g){
			draw(g, getX(), getY(),size, limit);
		}
		
		/**/
		public void draw(Graphics g, int x, int y, int size, int limit) {
		    for (int a = 0; a < 360; a += 60) { //go in a complete circle
		        double rad = a * Math.PI / 180;
		        int x2 = (int) (x + Math.cos(rad) * size);
		        int y2 = (int) (y + Math.sin(rad) * size);
		        if (limit >= 3) {
		        	g.drawLine(x, y, x2, y2);
		            draw(g, x2, y2, size/3, limit-1);
		        }
		    }
		}
}