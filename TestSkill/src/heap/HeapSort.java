package heap;

import java.util.Arrays;

public class HeapSort {


  private static void printArray(int[] a) {
    Arrays.stream(a).forEach(i -> System.out.println(i));
  }

  private void sort(int[] a) {
    int n = a.length;
    // Convert Array to max heap
    for(int i = n/2; i>=0; i--) {
      heapify(a,i,n);
    }

    for(int i = n-1; i>=0; i--) {
      // move first element to last
      int tmp = a[0];
      a[0] = a[i];
      a[i] = tmp;

      heapify(a, 0, i);
    }

  }

  private void heapify(int[] a, int i, int n) {
    int largestIndex = i;
    int leftChildIndex = 2*i + 1;
    int rightChildIndex = 2*i + 2;

    if(leftChildIndex < n && a[leftChildIndex] > a[largestIndex]) {
      largestIndex = leftChildIndex;
    }

    if(rightChildIndex < n && a[rightChildIndex] > a[largestIndex]) {
      largestIndex = rightChildIndex;
    }

    if(largestIndex != i) {
      int tmp = a[largestIndex];
      a[largestIndex] = a[i];
      a[i] = tmp;

      heapify(a,largestIndex,n);
    }
  }


  public static void main(String args[])
  {
    int A[] = {22, 21, 3, 25, 26, 7};
    int n = A.length;

    HeapSort ob = new HeapSort();
    ob.sort(A);

    System.out.println("Sorted array is");
    printArray(A);
  }


}
