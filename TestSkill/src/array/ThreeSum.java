package array;

import java.util.*;

public class ThreeSum {

  public static void main(String args[]) {
    //int arr[] = {0, -1, 2, -3, 1};
    int arr[] = {0, 0, 0, 0};
    int n = arr.length;
    findTriplets1(arr, n);
  }


  private static void findTriplets1(int[] arr, int n) {
    List<List<Integer>> list = new ArrayList<>();
    Map<Integer, Integer> twoSums = new HashMap<>();
    List<List<Integer>> uniqueIndexes = new ArrayList<>();
    boolean found = false;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int x = -(arr[i] + arr[j]);
        if (twoSums.keySet().contains(x)) {
          boolean exist = false;
          int index = twoSums.get(x);
          ArrayList<Integer> current = new ArrayList<>(Arrays.asList(index, i, j));
          for(List<Integer> t : uniqueIndexes) {
            current.removeAll(t);
            if(current.size() == 0) {
              exist = true;
              break;
            }
          }
          if(!exist && index != i  && i != j && index != j) {
            uniqueIndexes.add(Arrays.asList(index, i, j));
            boolean valueExist = false;
            ArrayList<Integer> current1 = new ArrayList<>(Arrays.asList(x, arr[i], arr[j]));
            for(List<Integer> t : list) {
              current1.removeAll(t);
              if(current1.size() == 0) {
                valueExist = true;
                break;
              }
            }
            if(!valueExist) {
              list.add(Arrays.asList(x, arr[i], arr[j]));
              System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
              found = true;
            }
          }
        } else {
          twoSums.put(arr[j], j);
        }
      }
    }
    if (found == false) {
      System.out.printf(" No Triplet Found\n");
    }
  }

  private static void findTriplets(int[] arr, int n) {
    List<List<Integer>> list = new ArrayList<>();
    Set<Integer> twoSums = new HashSet<>();
    List<List<Integer>> uniqueIndexes = new ArrayList<>();
    boolean found = false;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int x = -(arr[i] + arr[j]);
        if (twoSums.contains(x)) {
          list.add(Arrays.asList(x, arr[i], arr[j]));
          System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
          found = true;
        } else {
          twoSums.add(arr[j]);
        }
      }
    }
    if (found == false) {
      System.out.printf(" No Triplet Found\n");
    }
  }


}
