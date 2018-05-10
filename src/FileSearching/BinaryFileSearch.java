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
 * 
 * 
 * }
 * */
/****************************************************/

import java.io.File;

public class BinaryFileSearch {

	
	public int searchForFile(String directory, String fileName){
		File file = new File(directory);
		int resultTotal = 0;
		
		if(directory.endsWith(fileName)){
			resultTotal++;
		}
		
		if(file.isDirectory()){
			for(File nextPathLevel : file.listFiles()){
				resultTotal += this.searchForFile(nextPathLevel.getAbsolutePath(), fileName);
				
				
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
		String directory = args[0];
		String fileName = args[1];
		int results = bfs.searchForFile(directory, fileName);
		System.out.printf("Total of : " + results + "," + fileName);
	}
}