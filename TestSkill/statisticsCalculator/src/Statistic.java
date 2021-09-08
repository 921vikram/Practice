


/**Tracks statistics of stream of values. */
public interface Statistic {
  /*Called to update the statistic with a new sample value. */
  void event(int value);
  /* Returns the mean of received sample values. */
  float mean();
  /* Returns the mean of sample values received in last N minutes only*/
  float mean(int lastNMinutes);
  /* Returns an estimate of the variance of the total population given the received sample values. */
  float variance();
  /* Returns the minimal received sample value. */
  int minimum();
  /* Returns the maximal received sample value. */
  int maximum();
}
