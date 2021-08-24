package searchAlgo;

public class MergeSortLinkedList {
  static Node head = null;

  static class Node {
    Node next;
    int value;
    public Node(int value) {
      this.value = value;
    }
  }

  static void push(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  static Node mergeSort(Node head) {
    if(head == null || head.next == null) {
      return head;
    }
    Node middle = getMiddle(head);
    Node nextMiddle = middle.next;

    middle.next = null;

    Node left = mergeSort(head);
    Node right = mergeSort(nextMiddle);

    Node sorted = merge(left, right);

    return sorted;
  }

  static  Node merge(Node left, Node right) {
    Node sorted = null;
    if(null == left) {
      return right;
    }
    if(null == right) {
      return left;
    }

      if(left.value <= right.value) {
        sorted = left;
        sorted.next = merge(left.next, right);
      } else {
        sorted = right;
        sorted.next = merge(left, right.next);
      }

      return sorted;
  }


  static Node getMiddle(Node head) {
    if(null == head) {
      return head;
    }
    Node fast = head;
    Node slow = head;
    while (fast.next != null && fast.next.next !=null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  static void printList(Node head) {
    while (head != null) {
      System.out.println("value "+head.value);
      head = head.next;
    }
  }


  public static void main(String[] args) {
    MergeSortLinkedList linkedList = new MergeSortLinkedList();
    linkedList.push(15);
    linkedList.push(10);
    linkedList.push(5);
    linkedList.push(20);
    linkedList.push(3);
    linkedList.push(2);

   mergeSort(linkedList.head);

   printList(linkedList.head);
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
