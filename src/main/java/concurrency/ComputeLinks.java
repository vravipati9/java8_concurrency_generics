package concurrency;

import java.util.Map;

/*
 * Using Synchronize and Suffer model

	A sequential version of code is given, your task - create a concurrent version using
	thread pools (executor services) and synchronization.
	
	The given sequential code starts at a URL and does a deep search to get the number of links.
	If a link has been traversed already, it skips traversing that link. When done, it returns
	the total number of links starting at the given link.
	
	Before you write any code, run the given code, see its sequential output. Then start on your
	efforts to create the concurrent version.
 */
public interface ComputeLinks {
	  final static String TOPURL = "http://www.agiledeveloper.com/venkat/countlinkssample/index.html";

	  static void reportResultAndTime(String startingURL, ComputeLinks computeLinks) {
	    try {
	      Map<String, Object> response = Timeit.measure(() -> computeLinks.countLinks(startingURL));
	      System.out.println("The number of links is: " +  response.get("result"));
	      System.out.printf("%s Time taken(s): %s\n", 
	        computeLinks.getClass().getSimpleName(), response.get("Time"));
	    } catch(Exception ex) {
	      System.out.println("Error processing: " + ex.getMessage());
	    }    
	  }
	  
	  long countLinks(String url);

	  
	  static void main(String[] args) {
	    //ComputeLinks.reportResultAndTime(TOPURL, new ComputeLinksSequential());
	    ComputeLinks.reportResultAndTime(TOPURL, new ComputeLinksConcurrent());
	  }  
	}