package concurrency;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YahooFinance {
	public static double getPrice1(final String ticker) {
		try {
			final URL url = 
					new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
			final BufferedReader reader = 
					new BufferedReader(new InputStreamReader(url.openStream()));
			final String data = reader.lines().skip(1).limit(1).findFirst().get();
			final String[] dataItems = data.split(",");
			double price = Double.parseDouble(dataItems[dataItems.length - 1]);      
			return price;
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
		public static double getPrice(final String ticker)  {
			try {
				String sURL = "https://query1.finance.yahoo.com/v7/finance/chart/"; 
				
				URL url = new URL(sURL.concat(ticker));
				HttpURLConnection request = (HttpURLConnection) url.openConnection();
				request.connect();
				
				// Convert to a JSON object to print data
				JsonParser jp = new JsonParser(); //from gson
				
				JsonElement jelement = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			    JsonObject  jobject = jelement.getAsJsonObject();
			    jobject = jobject.getAsJsonObject("chart");
			    JsonArray jarray = jobject.getAsJsonArray("result");
			    
			    jobject = jarray.get(0).getAsJsonObject();
			    jobject = jobject.getAsJsonObject("meta");
			    
			    Double quote = jobject.get("previousClose").getAsDouble();
			    
				//System.out.println("The value of "+ticker + " Quote is "+ quote);
				return quote;
			} catch (JsonIOException | JsonSyntaxException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
	}
