package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseEnergySourceImproved {
	  public static void main(String[] args) throws Exception {
	    final EnergySourceImproved energySource = EnergySourceImproved.create();

	    ExecutorService executorService = Executors.newFixedThreadPool(50);

	    for(int i = 0; i < 50; i++) {
	      executorService.execute(() -> energySource.useEnergy(1));
	    }
	    executorService.shutdown();

	    Thread.sleep(1000);
	    System.out.println("Available: " + energySource.getUnitsAvailable());
	    EnergySourceImproved.stopAllEnergySources();
	  }
	}