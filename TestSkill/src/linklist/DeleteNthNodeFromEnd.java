package linklist;

import java.util.LinkedList;

public class DeleteNthNodeFromEnd {
  // Head of list
  private static Node head;

  // Linked list Node
  private static class Node {
    int data;
    Node next;
    Node(int d)
    {
      data = d;
      next = null;
    }
  }

  // Function to insert a new Node at front of the list
  public static void push(int new_data)
  {
    Node new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
  }

  // Function to print the linked list
  public static void printList()
  {
    Node tnode = head;
    while (tnode != null) {
      System.out.print(tnode.data + " ");
      tnode = tnode.next;
    }
  }

  private static void deleteNode(int n) {
    Node first = head;
    Node second = head;

    for(int i =0; i< n; i++) {
      // Linked list has less elements than n
      if(second.next == null) {
        if(n -1 == i ) {
          head = head.next;
          return;
        }
      }
      // move second till n
      second = second.next;
    }

    while (second.next != null) {
      second = second.next;
      first = first.next;
    }

    first.next = first.next.next;
  }

  // Driver code
  public static void main(String[] args)
  {
    DeleteNthNodeFromEnd llist = new DeleteNthNodeFromEnd();

    llist.push(7);
    llist.push(1);
    llist.push(3);
    llist.push(2);

    System.out.println("\nCreated Linked list is:");
    printList();

    int N = 1;
    deleteNode(N);

    System.out.println("\nLinked List after Deletion is:");
    printList();
  }

}
