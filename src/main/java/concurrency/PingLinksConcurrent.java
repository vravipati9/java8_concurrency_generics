package concurrency;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingLinksConcurrent implements PingLinks{
	private Set<String> visited = new HashSet<>();
	private ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 10);
	
	public long ping(String[] urls) {
		System.out.println("Available Processes" +Runtime.getRuntime().availableProcessors() );
		for (String url : urls) {
			if (!visited.contains(url))  
				executor.submit(() -> pingEachLink(url));
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
 
		}
		return visited.size();
	}
	
	private void pingEachLink(String url) {
		visited.add(url);
		String result = "";
		int code  = 0;
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			Thread.sleep(100);
			code = connection.getResponseCode();
			if (code == 200) {
				result = "Green\t";
			}
		} catch (Exception e) {
			result = "->Red<-\t";
		}
		System.out.println(url + "\t\tStatus:" + result + "\t\tCode:" +code);
	}
}
