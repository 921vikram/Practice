package searchAlgo;

public class MergeSort {

  public static void main(String[] args) {
    int[] s = new int[]{ 14, 2222, 3, 56, 8, 134, 21, 34, 545, 89, 144, 33, 37, 610};
    mergeSort(s, 0, s.length -1);
    for(int i=0;i<s.length;i++) {
      System.out.println("sorted "+s[i]);
    }
  }

  private static void mergeSort(int[] s, int low, int high) {
    if(low < high) {
      int m = low + (high - low)/2;
      mergeSort(s, low, m);
      mergeSort(s, m+1, high);
      merge(s,low,m,high);
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
