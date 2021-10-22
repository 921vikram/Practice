package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateSortedArray {

  public static void main(String[] args)
  {
    // creating array list
    List<Integer> my_list = new ArrayList<>();
    my_list.add(10);
    my_list.add(20);
    my_list.add(30);
    my_list.add(40);
    my_list.add(50);
    my_list.add(60);
    my_list.add(70);

    // Printing list before rotation
    System.out.println("List Before Rotation : " + Arrays.toString(my_list.toArray()));
    int n = my_list.size();
    int m = 4;
    // Loop according to the number of rotations
    for (int i = 0; i < m; i++) {
      // storing the first element in the list
      int temp = my_list.get(0);
      // traverse the list and move elements to left
      for (int j = 0; j < n-1; j++) {
        my_list.set(j, my_list.get(j + 1));
      }
      my_list.set(n-1, temp);
    }

    // Printing list after rotation
    System.out.println("List After Rotation :  " + Arrays.toString(my_list.toArray()));
  }
}
