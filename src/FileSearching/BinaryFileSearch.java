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
 * String for file name
 * String for directory name
 * 
 * }
 * */
/****************************************************/

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileSearch {

  private String fileNameToSearch;
  private List<String> result = new ArrayList<String>();
	
  public String getFileNameToSearch() {
	return fileNameToSearch;
  }

  public void setFileNameToSearch(String fileNameToSearch) {
	this.fileNameToSearch = fileNameToSearch;
  }

  public List<String> getResult() {
	return result;
  }

  public static void main(String[] args) {

	BinaryFileSearch binaryFileSearch = new BinaryFileSearch();
  
        //try different directory and filename :)
	binaryFileSearch.searchDirectory(new File("/Users/Quigy Laptop/workspace/"), "shape.java");

	int count = binaryFileSearch.getResult().size();
	if(count ==0){
	    System.out.println("\nNo result found!");
	}else{
	    System.out.println("\nFound " + count + " result!\n");
	    for (String matched : binaryFileSearch.getResult()){
		System.out.println("Found : " + matched);
	    }
	}
  }

  public void searchDirectory(File directory, String fileNameToSearch) {

	setFileNameToSearch(fileNameToSearch);

	if (directory.isDirectory()) {
	    search(directory);
	} else {
	    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
	}

  }

  private void search(File file) {

	if (file.isDirectory()) {
	  System.out.println("Searching directory ... " + file.getAbsoluteFile());
		
            //do you have permission to read this directory?	
	    if (file.canRead()) {
		for (File temp : file.listFiles()) {
		    if (temp.isDirectory()) {
			search(temp);
		    } else {
			if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {			
			    result.add(temp.getAbsoluteFile().toString());
		    }

		}
	    }

	 } else {
		System.out.println(file.getAbsoluteFile() + "Permission Denied");
	 }
      }

  }

}