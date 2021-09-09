import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Statistics calculator keep tracks of Mean and Variations of all the events
 * received till the time
 */
public class StatisticsCalculator implements Statistic {

  /**
   * Sample class contains the timestamp at which sample is received and the sample value
   */
  public static class Sample {
    private Long timestamp;
    private Integer value;

    public Sample(Long timestamp, int value) {
      this.timestamp = timestamp;
      this.value = value;
    }

    public Long getTimestamp() {
      return timestamp;
    }

    public Integer getValue() {
      return value;
    }
  }

  // Stores samples for last Thirty Minutes it is configurable based on memory requirement
  private static List<Sample> samples = Collections.synchronizedList(new ArrayList<>());
  // Stores mean of all the events came till now
  private static float mean = 0;
  // Stores variance of all the events came till now
  private static float variance = 0;
  // This is requires of variance calculation
  private static float meanofDiffSum = 0;
  // Keeps tracks of number of events received
  private static int numOfSamples = 0;
  // Stores minimum of all the events received till now
  private static int min = Integer.MAX_VALUE;
  // Stores maximum of all the events received till now
  private static int max = Integer.MIN_VALUE;
  // Keeping all the events in last 30 minutes this is configurable parameter and can be increased and decreased based on memory requirement
  private static long THIRTY_MINUTES = 1000 * 60 * 30;

  @Override
  public void event(int value) {
    // Capture the timestamp at which sample received
    Long sampleTime = System.currentTimeMillis();
    // If multiple Threads are calling the event method we need to put in Synchronized block to update all the static fields updated serially
    synchronized (this) {
      System.out.println("Sample " + numOfSamples + " value " + value);
      // Removing element from list synchronously so that calculation of mean for last N minutes will not be affected.
      synchronized (samples) {
        samples.add(new Sample(sampleTime, value));
        Sample sam = samples.get(0);
        if (sam.getTimestamp() + THIRTY_MINUTES < sampleTime) {
          samples.remove(0);
        }
      }

      if (value < min) {
        min = value;
      }
      if (value > max) {
        max = value;
      }
      if (numOfSamples == 0) {
        mean = value;
      } else {
        // New mean can be calculated from the old mean value. Details formula derivation attached with readme file
        float newMean = (mean / (numOfSamples + 1)) * numOfSamples + ((float) value) / (numOfSamples + 1);
        if (newMean > mean) {
          float diff = newMean - mean;
          // There is a formula to derive variance from the old variance value and diff Sum value.  Details formula derivation attached with readme file
          variance = (variance / (numOfSamples + 1)) * numOfSamples
            + (((float) value - newMean) * ((float) value - newMean) / (numOfSamples + 1))
            + (diff * diff) / (numOfSamples + 1) * numOfSamples
            - ((diff) / (numOfSamples + 1)) * 2 * numOfSamples * meanofDiffSum;

          meanofDiffSum = (meanofDiffSum / (numOfSamples + 1)) * numOfSamples
            - (diff / (numOfSamples + 1)) * numOfSamples
            + (((float) value - newMean) / (numOfSamples + 1));

        } else if (newMean < mean) {
          float diff = mean - newMean;

          variance = (variance / (numOfSamples + 1)) * numOfSamples
            + ((newMean - value) * (newMean - value) / (numOfSamples + 1))
            + (diff * diff) / (numOfSamples + 1) * numOfSamples
            + ((diff) / (numOfSamples + 1)) * 2 * numOfSamples * meanofDiffSum;

          meanofDiffSum = (meanofDiffSum / (numOfSamples + 1)) * numOfSamples
            + (diff / (numOfSamples + 1)) * numOfSamples
            + (((float) value - newMean) / (numOfSamples + 1));

        }
        mean = newMean;
      }
      numOfSamples++;
      printValues();
    }
  }

  @Override
  public float mean() {
    return mean;
  }

  @Override
  /**
   * We will traverse the list from the end and get all the events came in last N minutes and calculate the mean
   */
  public float mean(int lastNMinutes) {
    Long currentTime = System.currentTimeMillis();
    Long sampleTime = currentTime - lastNMinutes * 60 * 1000;
    float sum = 0;
    int sampleCount = 0;
    synchronized (samples) {
      ListIterator<Sample> iterator = samples.listIterator(samples.size());
      while (iterator.hasPrevious()) {
        Sample sample = iterator.previous();
        sampleCount++;
        if (sample.getTimestamp() < sampleTime) {
          continue;
        } else {
          sum += sample.getValue();
        }
      }

    }
    return sum / sampleCount;
  }

  @Override
  public float variance() {
    return variance;
  }

  @Override
  public int minimum() {
    return min;
  }

  @Override
  public int maximum() {
    return max;
  }

  @Override
  public void printValues() {
    System.out.println("Mean " + this.mean());
    System.out.println("Variance " + this.variance());
    System.out.println("Min " + this.minimum());
    System.out.println("Max " + this.maximum());
  }

}
