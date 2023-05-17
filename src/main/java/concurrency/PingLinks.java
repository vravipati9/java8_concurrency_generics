package concurrency;

import java.util.Map;

public interface PingLinks {
	  final static String[] hostList = { 
			    "http://crunchify.com", 
			    "https://yahoo.com",
				"https://www.ebay.com", 
				"https://google.com",
				"http://www.example.co", 
				"https://paypal.com",
				"http://bing.com/", 
				"https://www.amazon.com/",
				"http://techcrunch.com/",
				"http://mashable.com/", 
				"http://thenextweb.com/",
				"http://wordpress.com/", 
				"http://wordpress.org/",
				"http://example.com/", 
				"http://sjsu.edu/",
				"https://www.amazon.com/",
				"http://ebay.co.uk/", 
				"http://google.co.uk/",
				"http://www.wikipedia.org/",
				"http://en.wikipedia.org/wiki/Main_Page", 
				"https://www.agiledeveloper.com/", 
				"https://www.amazon.com/",
				"https://www.youtube.com"
				};
	  
	  static void reportResultAndTime(String[] links, PingLinks pingLinks) {
	    try {
	      Map<String, Object> response = Timeit.measure(() -> pingLinks.ping(links));
	      System.out.println("The number of links is: " +  response.get("result"));
	      System.out.printf("%s Time taken(s): %s\n", 
	        pingLinks.getClass().getSimpleName(), response.get("Time"));
	    } catch(Exception ex) {
	      System.out.println("Error processing: " + ex.getMessage());
	    }    
	  }
	  
	  long ping(String[] urls);

	  
	  static void main(String[] args) {
	    //PingLinks.reportResultAndTime(hostList, new PingLinksSequential());
	    PingLinks.reportResultAndTime(hostList, new PingLinksConcurrent());
	  }  
	}