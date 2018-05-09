import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/****************************************/
/*			CLASS DESCRIPTION			*/
/* This class, FractalFlake, will use	*/
/* recursion in the draw() method to	*/
/* create a shape with branches (flake)	*/
/****************************************/

public class FractalFlake extends Shape {

	private final int size;
	private final int numBranches;

	/*First constructor has 4 arguments
	 * for the x and y starting points and to set the 
	 * limit and numBranches instance values.
	 * The points' values are passed in through
	 * this constructor which invokes the super()
	 * class constructor in Shape.
	 * The size and branches values are then assigned to
	 * the limit and numBranches instance variables.
	 * */
	public FractalFlake(int x, int y) {
		super(x,y);
		this.size = 10;
		this.numBranches = 3;
	}

	@Override
	public void draw(Graphics g) { //a redirect or facade
		draw(g,getX(), getY(),size, numBranches);
	}

	/*This draw() method overrides the draw() method above
	 * This will take in the x,y coordinate pair
	 * and the LIMIT and NUMBRANCHES values
	 * to draw lines to the screen with the size
	 * attributes specified.
	 * */
	public void draw(Graphics g, int x, int y, int size, int numBranches) {
		for (int a = 0; a < 360; a += 60) {
			double rad = a * Math.PI / 180;
			int x2 = (int) (x + Math.cos(rad) * size);
			int y2 = (int) (y + Math.sin(rad) * size);
			g.drawLine(x, y, x2, y2);
			if (numBranches > 0) {
				draw(g, x2, y2, size/3, numBranches-1);
			}
		}
	}
}