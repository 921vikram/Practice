package searchAlgo;

public class QuickSort {

  public static void main(String[] args) {
    int[] s = new int[]{ 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
    quickSort(s, 0, s.length -1);
    for(int i=0;i<s.length;i++) {
      System.out.println("sorted "+s[i]);
    }
  }

  private static void quickSort(int[] s, int low, int high) {
    if(low < high) {
      int p = partition(s, low, high);
      quickSort(s, low, p-1);
      quickSort(s, p+1, high);
    }
  }

  private static int partition(int[] s, int low, int high) {
    int pivot = s[high];
    int i = low;
    for(int j=low; j < high-1; j++) {
      if(s[j] < pivot) {
        i++;
        swap(s,i,j);
      }
    }
    swap(s,i+1, high);
    return i+1;
  }

  public static void swap(int[] s, int i, int j) {
    int tmp = s[i];
    s[i] = s[j];
    s[j] = tmp;
  }

}
