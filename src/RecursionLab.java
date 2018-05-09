/*-----------------------------------------------------------------------------------
 * 
 *	sum( n ) is a summation algorithm defined as follows:
 *				
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *			
 *	(2)	    sum( n ) = n + sum( n - 1 ) 
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 ) 
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1 
 *
 *----------------------------------------------------------------------------------- */ 

import java.awt.Dimension;

import javax.swing.*;

public class RecursionLab {

	private static JTextArea myArea = new JTextArea();
	private static int count = 0;

	public static void main( String args[] ) {	//invoke the recursive method here...

		/**
		 * TODO: switch between the two commented lines below and execute this code, 
		 * observing the output for both the iterative solution and the recursive solution.
		 * To watch the recursive behavior in action, set a breakpoint on the if statement
		 * inside the recursiveSum() function
		 * 
		 */
		//int solution = iterativeSum( 20 );
		//int solution = recursiveSum( 20 );

		/****************************************************/
		/*					Methods for Lab					*/
		/****************************************************/
		//int solution = recursiveFactorialSum(20); //used int = 4 for testing, should return 24
		//int solution = exponentialRecursion(2,3); //needs two args - 1 for the base and the other 
		//for the exponent to raise the base to. (2,3) should produce 9 because it's 3^2
		//int solution = quickExponents(2,3);
		int solution = fibonacciRecursion();
		/******************End Method Calls******************/


		//Some GUI details
		myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
		JScrollPane myPane = new JScrollPane( myArea );
		myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myPane.setPreferredSize(new Dimension(600,300));
		JOptionPane.showMessageDialog( null, myPane );

		//good form to include an exit call when GUIing in Java 
		System.exit(0);
	}

	/****************************************************/
	/*				The Recursion Methods				*/
	/****************************************************/

	/** recursion is similar to iterative looping, but we
	 *  use method calls to repeat computations (or decompose the problem) 
	 *  instead of explicit looping control structures 
	 */
	public static int recursiveSum( int n ) {
		updateRecursiveDisplay(n);			//overhead for nice output, not required
		if( n == 1)			//if we're at the base case...
			return 1;		//then return the answer to the simplest problem which we know how to solve
		else				//otherwise, we rely on the fact that sum( n ) = n + sum( n - 1 ) and keep recursing
			return ( n + recursiveSum( n - 1) );
	}						//for this method to terminate, we must be breaking the problem down into smaller
	//and smaller problems, until we reach the simplest form of the problem which we know
	//how to solve (in this case, it's the fact that sum( 1 ) == 1 )

	//the iterative counterpart to the above recursion
	//notice how it's longer? At times, an iterative solution may require more code than the recursive counterpart, 
	//but, the recursive solution is slower and more memory intensive.  We can always recast recursion as iteration.
	public static int iterativeSum( int i ) {
		int total = 0;

		for( int n = i; n >= 1; n--) {
			updateIterativeDisplay(n);
			total = total + n;
		}
		return total;
	}			

	/****************************************************/
	/* Factorial sum using recursion to get the answer	*/
	/* This method uses the following logic, 			*/
	/* n! = n(n-1). This expressed recursively looks like*/
	/* n! = n * (n - 1) * (n - 2) * (n - 3)...			*/
	/****************************************************/
	public static int recursiveFactorialSum(int n){
		updateRecursiveFactorialSum(n);

		if(n == 1){
			return 1; //the base case, such that when n is 1, return this as the final solution
		}else{
			return (n * recursiveFactorialSum(n-1)); //the execution of the method while running will
			//place it into a suspended state, and run again with the new value of n.
		}
	}

	/****************************************************/
	/* The value of a base raised to a given exponent is*/
	/* determined here. The exponent and base values are*/
	/* passed in through the parameters and then the	*/
	/* update method is called. Then if the exponent is	*/
	/* not 1 or negative, the recursive call is made in */
	/* the return value of the base ## multiplied by the*/
	/* value of the base ## raised to the value of the	*/
	/* exponent -1. */
	/****************************************************/
	public static int exponentialRecursion(int exp, int base){
		updateExponentialRecursionDisplay(exp, base);
		if(exp == 1){
			return base;
		}else if (exp <= 0){
			return base * exp;
		}else{
			return (base * exponentialRecursion(exp-1,base));
		}
	}

	/****************************************************/
	/* This method will do the same as the one above	*/
	/* with the exception to the way it is called		*/
	/* recursively with respect to how n is decremented.*/
	/****************************************************/
	public static int quickExponents(int exp, int base){
		updateQuickExponentsDisplay(exp,base);
		if(exp==0){
			return 1; //the base case for this recursive call
		}else if(exp % 2 == 0){
			return base*quickExponents(exp/2,base);
		}else {
			return base*quickExponents((exp-1)/2,base);
		}

	}
	
	/****************************************************/
	/* TEXT HERE */
	/****************************************************/
	public static int fibonacciRecursion(){
		updateFibonacciRecursion();
	}

	/****************************************************/
	/*					Display Methods					*/
	/****************************************************/

	public static void updateIterativeDisplay(int n) {
		count++;
		String text = myArea.getText();

		text += "\n/*******************Loop iteration " + count + "**************************************";
		text += "\n Calling iterativeSum( int n = " + n +" ). Total += " + n;
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}


	//ignore this method unless interested in the output string						
	public static void updateRecursiveDisplay(int n) {

		count++;
		String text = myArea.getText();


		if( count == 1 )  {
			text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}


		text += "\n/*******************Method invocation " + count + "*********************";


		text += "\n Calling recursiveSum( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";

		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( "+ (n - 1) +" ));";
		} else {
			text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );

	}

	public static void updateRecursiveFactorialSum(int n){
		count++;
		String text = myArea.getText();


		if( count == 1 )  {
			text += "\n       return ( n + recursiveFactorialSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}


		text += "\n/*******************Method invocation " + count + "*********************";


		text += "\n Calling recursiveFactorialSum( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";

		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveFactorialSum( "+ (n - 1) +" ));";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}

	public static void updateExponentialRecursionDisplay(int exp, int base){
		count++;
		String text = myArea.getText();

		if( count == 1 )  {
			text += "\n       return ( n + exponentialRecursion( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}


		text += "\n/*******************Method invocation " + count + "*********************";


		text += "\n Calling exponentialRecursion( int n = " + exp +" ). ";
		text += "\n The return statement from this function will resolve in " + (exp-1) + " more recursive method calls...";

		if( exp != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + exp + " * exponentialRecursion( "+ (exp - 1) +","+base+"));";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}

	public static void updateQuickExponentsDisplay(int exp, int base){
		count++;
		String text = myArea.getText();

		if( count == 1 )  {
			text += "\n       return ( n + exponentialRecursion( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}


		text += "\n/*******************Method invocation " + count + "*********************";


		text += "\n Calling exponentialRecursion( int n = " + exp +" ). ";
		text += "\n The return statement from this function will resolve in " + (exp-1) + " more recursive method calls...";

		if( exp != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + exp + " * exponentialRecursion( "+ (exp - 1) +","+base+"));";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}
	
	public static void updateFibonacciRecursion(){
		count++;
		String text = myArea.getText();

		if( count == 1 )  {
			text += "\n       return ( n + exponentialRecursion( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}


		text += "\n/*******************Method invocation " + count + "*********************";


		text += "\n Calling exponentialRecursion( int n = " + exp +" ). ";
		text += "\n The return statement from this function will resolve in " + (exp-1) + " more recursive method calls...";

		if( exp != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + exp + " * exponentialRecursion( "+ (exp - 1) +","+base+"));";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}
}