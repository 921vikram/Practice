package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationalSum {

  public static void main(String args[]) {
    ArrayList<Integer> arr = new ArrayList<>();

    arr.add(2);
    arr.add(4);
    arr.add(6);
    arr.add(8);

    int sum = 8;

    ArrayList<ArrayList<Integer>> ans = combinationalSum(arr, sum);

    // If result is empty, then
    if (ans.size() == 0) {
      System.out.println("Empty");
      return;
    }

    // print all combinations stored in ans

    for (int i = 0; i < ans.size(); i++) {

      System.out.print("(");
      for (int j = 0; j < ans.get(i).size(); j++) {
        System.out.print(ans.get(i).get(j) + " ");
      }
      System.out.print(")");
    }

  }

  private static ArrayList<ArrayList<Integer>> combinationalSum(ArrayList<Integer> arr, int sum) {
    ArrayList<ArrayList<Integer>> combinationalSums = new ArrayList<>();
    ArrayList<Integer> tmpArray = new ArrayList<>();

    Set<Integer> tmpSet = new HashSet<>(arr);
    arr.clear();
    arr.addAll(tmpSet);
    //Collections.reverse(tmpArray);
    Collections.sort(arr);
    findCombinations(combinationalSums, arr, 0, sum, tmpArray);
    return combinationalSums;
  }

  private static void findCombinations(ArrayList<ArrayList<Integer>> combinationalSums, ArrayList<Integer> arr,
                                       int i, int sum, ArrayList<Integer> tmpArray) {
    if(sum == 0) {
      combinationalSums.add(new ArrayList(tmpArray));
      return;
    }

    for(int index = i; index < arr.size(); index++) {

      if(sum - arr.get(index) >=0) {
        tmpArray.add(arr.get(index));

        findCombinations(combinationalSums, arr, index, sum - arr.get(index), tmpArray);

        tmpArray.remove(arr.get(index));

      }
    }


  }


}
