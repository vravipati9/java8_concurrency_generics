package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class GetStockPrice {
  private static Map<String, Integer> shares = new HashMap<String, Integer>() {
    {
      put("AMD", 20);
      put("HPQ", 30);
      put("IBM", 40);
      put("TXN", 50);
      put("VMW", 60);
      put("XRX", 70);
      put("AAPL", 80);
      put("ADBE", 90);
      put("AMZN", 100);
      put("CRAY", 110);
      put("CSCO", 120);
      put("SNE", 130);
      put("GOOG", 140);
      put("INTC", 150);
      put("INTU", 160);
      put("MSFT", 170);
      put("ORCL", 180);
      //put("TIBX", 190);
      put("VRSN", 200);
      //put("YHOO", 210);
    }
  };

  public static double totalNetAssetValue() {
    double netAssetValue = 0;
    for (String ticker : shares.keySet()) {
      netAssetValue += YahooFinance.getPrice(ticker) * shares.get(ticker);
    }

    return netAssetValue;
  }
  
  public static double totalNetAssetValue(Stream<String> stream) {
	  //return stream.map((t) -> YahooFinance.getPrice(t) * shares.get(t))
	  //		.reduce(0.0, Double::sum);
	  
	  // Another way
	  return stream.mapToDouble((t) -> YahooFinance.getPrice(t) * shares.get(t))
		  		.sum();
  }

  public static void main(String[] args) {
    TimeitStreams.code(() ->
      System.out.println("Result Imperative $" + totalNetAssetValue()));

    TimeitStreams.code(() ->
      System.out.println("Result Functional $" + totalNetAssetValue(shares.keySet().stream())));

    TimeitStreams.code(() ->
      System.out.println("Result Parallel $" + totalNetAssetValue(shares.keySet().parallelStream())));
  }
}