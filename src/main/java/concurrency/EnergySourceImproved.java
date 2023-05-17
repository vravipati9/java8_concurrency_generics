package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EnergySourceImproved {
	  private final long MAXLEVEL = 100;
	  private long level = MAXLEVEL;
	  // We can use AtomicLong, AtomicLong crosses memory barrier
	  private static ScheduledExecutorService timer = Executors.newScheduledThreadPool(10);
	  
	  public EnergySourceImproved() {
	    
	  }

	  public static EnergySourceImproved create() {
		  EnergySourceImproved obj = new EnergySourceImproved();
		  obj.init();
		  return obj;
	  }
	  private void init() {
		  timer.scheduleAtFixedRate(this::replenish, 0, 1, TimeUnit.SECONDS);
	  }
	  
	  public static void stopAllEnergySources() {
		  timer.shutdown();
	  }
	  
	  public synchronized long getUnitsAvailable() { return level; }

	  public synchronized boolean useEnergy(final long units) {
	    if (units > 0 && level >= units) {
	      level -= units;
	      System.out.println("Level:"+level);
	      return true;
	    }
	    return false;
	  }


	  private synchronized void replenish() {
		  System.out.println("replenish called");
		  if (level < MAXLEVEL) level++;
	  }
	}