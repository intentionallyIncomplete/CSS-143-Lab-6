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
	
	/*This draw() method overrides the draw() method
	 * in the Shape super class.
	 * This will take in the x,y coordinate pair
	 * and the LIMIT and NUMBRANCHES values
	 * to draw lines to the screen with the size
	 * attributes specified.
	 * */
	
	public static void main(String[] args) {
		FractalFlake ff = new FractalFlake(1,1,1,1);
		
		
	}
}
