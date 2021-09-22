package linklist;

import java.util.LinkedList;

public class ReverseSingleLinkedList {

  static class Node {

    int data;
    Node next;

    Node(int d)
    {
      data = d;
      next = null;
    }
  }

  /* Function to reverse the linked list */
  static Node reverse(Node node)
  {
    Node prev = null;
    Node current = node;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  // prints content of double linked list
  static void printList(Node node)
  {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  // Driver Code
  public static void main(String[] args)
  {
    Node list = new Node(85);
    list.next = new Node(15);
    list.next.next = new Node(4);
    list.next.next.next = new Node(20);

    System.out.println("Given Linked list");
    printList(list);
    Node n = reverse(list);
    System.out.println("");
    System.out.println("Reversed linked list ");
    printList(n);
  }
}
