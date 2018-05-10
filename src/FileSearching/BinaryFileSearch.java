package FileSearching;

/****************************************************/
/*						DESCRIPTION					*/
/* This class will search for a file by name in a	*/
/* given directory two ways. One is iteratively, the*/
/* other recursive.	Below is some pseudocode of the */
/* class.*/
/****************************************************/

/****************************************************/
/*						PSEUDOCODE					*/
/* class BinaryFileSearch{
 * 
 * method for searching takes two parameters for path
 * and file name.
 * 
 * create file object to get access to IO methods
 * 
 * declare counter for counting results
 * 
 * check condition 1:
 * 		condition 1: if the path is the same as the file name, 
 * 		then file has been found, increase counter
 * check condition 2 (if 1 is not satisfied):
 * 		is the file object a directory, if not, pass
 * 		current name of object as file name to method (recursive call)
 * 		to check again. If condition satisfied, then file is found and
 * 		increase counter.
 * }
 * */
/****************************************************/

import java.io.File;

public class BinaryFileSearch {

	/* Two arg method for searching for a file by name
	 * contained in a String variable. This method will
	 * check the directory and fileName String values
	 * against the conditions within. Declaring a new File
	 * Object gives access to methods such as isDirectory
	 * that can check for path values. If the value is a directory,
	 * then make the recursive call to the method to pass
	 * the fileName value in again and run it against the conditions
	 * until one is satisfied.*/
	public int searchForFile(String directory, String fileName){
		File file = new File(directory);
		int resultTotal = 0;
		
		if(directory.endsWith(fileName)){
			resultTotal++;
		}
		
		//isDirectory() is a method of the File class
		//that can check is the value of the object
		//is a path.
		if(file.isDirectory()){
			for(File nextPathLevel : file.listFiles()){
				resultTotal += this.searchForFile(nextPathLevel.getAbsolutePath(), fileName); //recursive call
				
				
				/*iterative searching
				 * if(nextPathLevel.getAbsolutePath().endsWith(fileName)){
				 * resultTotal++;
				 * }
				 * */
			}
		}
		return resultTotal;
	}
	
	public static void main(String[] args){
		BinaryFileSearch bfs = new BinaryFileSearch();
		String directory = "C:/Users/Quigy Laptop/workspace/";
		String fileName = ".java";
		int results = bfs.searchForFile(directory, fileName);
		System.out.printf("Total of : " + results + ", " + fileName);
	}
}