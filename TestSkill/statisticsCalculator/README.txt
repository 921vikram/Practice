Instruction to run the Statistics calculator-

1. We can run from the main method of StatisticsCalculatorDriver class. Here we are using Executor service to run 10 parallel threads
   to put events on Statistic Calculator. We are printing Mean, Variance, Min and Max of all the events on each time an event is
   received.

2. Mean of events received in last N minutes can also we fetched. currently only last 30 minutes of data only used.

Assumptions-

   We are storing only last 30 minutes of events data with their timestamp. This can be changed based on requirement. Any event older
   than last 30 minutes will be removed


    We can calculate current mean and variance from the previous mean and variance values using below formulas.


New Mean = (Old Mean * n)/(n+1) + value/(n+1)


1. if NewMean is more than old mean -

New Variance = (old Variance/n+1)*n
                + (value - new Mean)*(value - new Mean)/n+1
                + n * (new mean - old mean) * (new mean - old mean)
                - 2 * (new mean - old mean) * n * old Z / n+1

new Z =  n * old Z / n+1
        - n * (new mean - old mean) / n+1
        + (value - new mean) / n+1


2. if NewMean is less than old mean -

New Variance = (old Variance/n+1)*n
                + (value - new Mean)*(value - new Mean)/n+1
                + n * (old mean - new mean) * (new mean - old mean)
                + 2 * (old  mean - new mean) * n * Z / n+1

new Z =  n * old Z / n+1
        + n * (new mean - old mean) / n+1
        + (value - new mean) / n+1


Note-
value = new event
and Z can be calculated by mean of diff sum