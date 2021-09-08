import java.util.ArrayList;

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

  private static ArrayList<Sample> samples = new ArrayList<>();

  private static float mean = 0;
  private static float variance = 0;
  private static float diffSum = 0;
  private static int numOfSamples = 0;
  private static int min = Integer.MAX_VALUE;
  private static int max = Integer.MIN_VALUE;
  private static long ONE_HOUR = 1000*60*60;

  @Override
  public void event(int value) {
    // Store samples
    Long sampleTime = System.currentTimeMillis();
    samples.add(new Sample(sampleTime, value));
    Sample sam = samples.get(samples.size() -1);
    if(sam.getTimestamp() + ONE_HOUR < sampleTime) {
      samples.remove(samples.size() -1);
    }

    if(value < min) {
      min = value;
    }
    if(value > max) {
      max = value;
    }
    if(numOfSamples == 0) {
      mean = value;
    } else {
      float newMean = (mean/(numOfSamples +1))*numOfSamples+ value/(numOfSamples+1);
      if(newMean >= mean) {
        float diff = newMean - mean;

        variance = (variance/(numOfSamples +1))*numOfSamples + ((value - newMean)/(numOfSamples+1)) + (diff*diff)/(numOfSamples+1)*numOfSamples
          - ((diff)/(numOfSamples+1))*numOfSamples*numOfSamples*diffSum;

        diffSum =  (diffSum/(numOfSamples +1))*numOfSamples - (diff/(numOfSamples +1))*numOfSamples + ((value - newMean)/(numOfSamples+1));

      } else if (newMean < mean) {
        float diff = mean - newMean;

        variance = (variance/(numOfSamples +1))*numOfSamples + ((value - newMean)/(numOfSamples+1)) + (diff*diff)/(numOfSamples+1)*numOfSamples
          + ((diff)/(numOfSamples+1))*numOfSamples*numOfSamples*diffSum;

        diffSum =  (diffSum/(numOfSamples +1))*numOfSamples - (diff/(numOfSamples +1))*numOfSamples + ((value - newMean)/(numOfSamples+1));

      }
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
    Long sampleTime = currentTime - lastNMinutes*60*1000;
    int sum = 0;
    int sampleCount = 0;
    for(Sample sample : samples) {
      sampleCount++;
      if(sample.getTimestamp() < sampleTime) {
        break;
      } else {
        sum += sample.getSample();
      }
    }
    return sum/sampleCount;
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
}
