package concurrency;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class PingLinksSequential implements PingLinks{
	private Set<String> visited = new HashSet<>();
	public long ping(String[] urls) {
		for (String url : urls) {
			if (!visited.contains(url))  
			pingEachLink(url);
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
