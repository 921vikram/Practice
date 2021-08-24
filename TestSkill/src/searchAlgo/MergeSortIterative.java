package searchAlgo;

public class MergeSortIterative {

  public static void main(String[] args) {
    int[] s = new int[]{ 14, 2222, 3, 56, 8, 134, 21, 34, 545, 89, 144, 33, 37, 610};
    mergeSort(s, s.length);
    for(int i=0;i<s.length;i++) {
      System.out.println("sorted "+s[i]);
    }
  }

  private static void mergeSort(int[] s, int n) {
    int curntSize;
    int leftStart;

    for(curntSize=1; curntSize < n; curntSize=2*curntSize) {
      for(leftStart=0;leftStart<n-1;leftStart=leftStart+2*curntSize) {
        int mid = Math.min(leftStart+curntSize-1, n-1);
        int right = Math.min(leftStart+(2*curntSize)-1, n-1);
        merge(s,leftStart, mid, right);
      }
    }
  }

  private static void merge(int[] s, int low, int m, int high) {
    int n1 = m - low + 1;
    int n2 = high - m;
    int[] L = new int[n1];
    int[] R = new int[n2];
    int i = low;
    int j =0;
    while(j<n1) {
      L[j] = s[i];
      i++;j++;
    }
    i = m+1;
    j = 0;
    while (j < n2) {
      R[j] = s[i];
      i++;j++;
    }

    i=0;
    j=0;
    int k =low;
    while (i < n1 && j < n2) {
      if(L[i] > R[j]) {
        s[k] = R[j];
        j++;
      } else {
        s[k] = L[i];
        i++;
      }
      k++;
    }

    while (i<n1) {
      s[k] = L[i];
      i++;
      k++;
    }

    while (j<n2) {
      s[k] = R[j];
      j++;
      k++;
    }
  }


}
