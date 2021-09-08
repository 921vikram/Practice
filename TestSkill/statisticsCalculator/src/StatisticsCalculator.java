import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class StatisticsCalculator implements Statistic {

  public static class Sample {
    private Long timestamp;
    private Integer sample;

    public Sample(Long timestamp, int sample) {
      this.timestamp = timestamp;
      this.sample = sample;
    }

    public Long getTimestamp() {
      return timestamp;
    }

    public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
    }

    public Integer getSample() {
      return sample;
    }

    public void setSample(Integer sample) {
      this.sample = sample;
    }
  }

  private static List<Sample> samples = Collections.synchronizedList(new ArrayList<>());

  private static float mean = 0;
  private static float variance = 0;
  private static float diffSum = 0;
  private static int numOfSamples = 0;
  private static int min = Integer.MAX_VALUE;
  private static int max = Integer.MIN_VALUE;
  private static long ONE_HOUR = 1000 * 60 * 60;

  @Override
  public void event(int value) {
    // Store samples
    Long sampleTime = System.currentTimeMillis();
    synchronized (samples) {
      samples.add(new Sample(sampleTime, value));
      Sample sam = samples.get(0);
      if (sam.getTimestamp() + ONE_HOUR < sampleTime) {
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
      float newMean = (mean / (numOfSamples + 1)) * numOfSamples + ((float) value) / (numOfSamples + 1);
      if (newMean >= mean) {
        float diff = newMean - mean;

        variance = (variance / (numOfSamples + 1)) * numOfSamples + (((float) value - newMean) * ((float) value - newMean) / (numOfSamples + 1))
          + (diff * diff) / (numOfSamples + 1) * numOfSamples
          - ((diff) / (numOfSamples + 1)) * numOfSamples * numOfSamples * diffSum;

        diffSum = (diffSum / (numOfSamples + 1)) * numOfSamples - (diff / (numOfSamples + 1)) * numOfSamples
          + (((float) value - newMean) / (numOfSamples + 1));

      } else if (newMean < mean) {
        float diff = mean - newMean;

        variance = (variance / (numOfSamples + 1)) * numOfSamples + ((newMean - value) / (numOfSamples + 1)) + (diff * diff) / (numOfSamples + 1) * numOfSamples
          + ((diff) / (numOfSamples + 1)) * numOfSamples * numOfSamples * diffSum;

        diffSum = (diffSum / (numOfSamples + 1)) * numOfSamples - (diff / (numOfSamples + 1)) * numOfSamples + ((value - newMean) / (numOfSamples + 1));

      }
      mean = newMean;
    }
    numOfSamples++;
  }

  @Override
  public float mean() {
    return mean;
  }

  @Override
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
          sum += sample.getSample();
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

  public static void main(String[] args) {
    Statistic statisticCalculator = new StatisticsCalculator();
    statisticCalculator.event(3);
    System.out.println("Mean " + statisticCalculator.mean());
    System.out.println("Variance " + statisticCalculator.variance());
    System.out.println("Min " + statisticCalculator.minimum());
    System.out.println("Max " + statisticCalculator.maximum());
    System.out.println("Mean Last Minute " + statisticCalculator.mean(1));

    statisticCalculator.event(4);
    System.out.println("Mean " + statisticCalculator.mean());
    System.out.println("Variance " + statisticCalculator.variance());
    System.out.println("Min " + statisticCalculator.minimum());
    System.out.println("Max " + statisticCalculator.maximum());
    System.out.println("Mean Last Minute " + statisticCalculator.mean(1));

    statisticCalculator.event(5);
    System.out.println("Mean " + statisticCalculator.mean());
    System.out.println("Variance " + statisticCalculator.variance());
    System.out.println("Min " + statisticCalculator.minimum());
    System.out.println("Max " + statisticCalculator.maximum());
    System.out.println("Mean Last Minute " + statisticCalculator.mean(1));


    statisticCalculator.event(8);
    System.out.println("Mean " + statisticCalculator.mean());
    System.out.println("Variance " + statisticCalculator.variance());
    System.out.println("Min " + statisticCalculator.minimum());
    System.out.println("Max " + statisticCalculator.maximum());
    System.out.println("Mean Last Minute " + statisticCalculator.mean(1));


  }

}
