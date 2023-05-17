package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Timeit {
	  public static Map<String, Object> measure(Supplier<Long> code) {
	    long start = System.nanoTime();
	    long count = code.get();
	    long end = System.nanoTime();
	    
	    Map<String, Object> response = new HashMap<>();
	    response.put("Time", (end - start)/1.0e9);
	    response.put("result", count);
	    return response;
	  }
	}