import java.awt.Graphics;

/****************************************/
/*			CLASS DESCRIPTION			*/
/* This class, FractalFlake, will use	*/
/* recursion in the draw() method to	*/
/* create a shape with branches (flake)	*/
/****************************************/

public class FractalFlake extends Shape {

	private final int LIMIT;
	private final int NUMBRANCHES;

	/*First constructor has 4 arguments
	 * for the x and y starting points and to set the 
	 * limit and numBranches instance values.
	 * The points' values are passed in through
	 * this constructor which invokes the super()
	 * class constructor in Shape.
	 * The size and branches values are then assigned to
	 * the limit and numBranches instance variables.
	 * */
	public FractalFlake(int x, int y, int size, int branches) {
		super(x,y);
		LIMIT = size;
		NUMBRANCHES = branches;
	}


	@Override
	public void draw(Graphics g) { 
		draw(g,getX(), getY(),LIMIT);
	}

	/*This draw() method overrides the draw() method above
	 * This will take in the x,y coordinate pair
	 * and the LIMIT and NUMBRANCHES values
	 * to draw lines to the screen with the size
	 * attributes specified.
	 * */
	private void draw(Graphics g, int startX, int startY, int limit) {
		if(limit>= 3) { //base case is depth <3
			for ( int i = 0; i < NUMBRANCHES; i++ )
			{
				int x2 = startX + (int) (LIMIT *
						Math.cos( (2 * Math.PI / NUMBRANCHES) * i ));
				int y2 = startY - (int) (LIMIT *
						Math.sin( (2 * Math.PI / NUMBRANCHES) * i ));
				g.drawLine( startX, startY, x2, y2 ); //do a branch
				draw(g, x2, y2, limit/3); //recursive call
			}
		}
	}

	//	public static void main(String[] args) {
	//		FractalFlake ff = new FractalFlake(1,1,1,1);
	//	}
}
