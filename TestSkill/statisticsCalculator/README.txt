We can calculate mean and variance from the previous mean and variance values using below formulas.


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