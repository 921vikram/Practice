package linklist;

public class AddTwoIntegers {
  
  public static void main(String args[]) {

    ListNode n = new ListNode(4);
    n.setNext(new ListNode(6));
    ListNode m = new ListNode(2);
    m.setNext(n);

    ListNode q = new ListNode(6);
    ListNode r = new ListNode(7);
    r.setNext(new ListNode(8));
    q.setNext(r);
    ListNode p = new ListNode(5);
    p.setNext(q);

    ListNode res = addTwoNumbers(m,p);
    while(res != null) {
      System.out.println("Value "+res.getValue());
      res = res.getNext();
    }


  }

  private static class ListNode {
    private ListNode next;
    private int value;

    public ListNode(int value) {
      this.value = value;
    }

    public ListNode getNext() {
      return next;
    }

    public void setNext(ListNode next) {
      this.next = next;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode old = null;
    ListNode start = null;
    int reminder = 0;
    if(l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else {

      while (l1 != null && l2 != null) {
        ListNode tmpNode = new ListNode(0);
        int tmp = reminder + l1.getValue() + l2.getValue();
        if (tmp > 9) {
          tmpNode.setValue(tmp % 10);
          reminder = 1;
        } else {
          reminder = 0;
          tmpNode.setValue(tmp);
        }
        if (old == null) {
          old = tmpNode;
          start = old;
        } else {
          old.setNext(tmpNode);
          old = tmpNode;
        }
        l1 = l1.getNext();
        l2 = l2.getNext();
      }
      while (l1 != null) {
        ListNode tmpNode = new ListNode(0);
        int tmp = reminder + l1.getValue();
        if (tmp > 9) {
          tmpNode.setValue(tmp % 10);
          reminder = 1;
        } else {
          tmpNode.setValue(tmp);
          reminder = 0;
        }
        old.setNext(tmpNode);
        old = tmpNode;
        l1 = l1.getNext();
      }

      while (l2 != null) {
        ListNode tmpNode = new ListNode(0);
        int tmp = reminder + l2.getValue();
        if (tmp > 9) {
          tmpNode.setValue(tmp % 10);
          reminder = 1;
        } else {
          tmpNode.setValue(tmp);
          reminder = 0;
        }
        old.setNext(tmpNode);
        old = tmpNode;
        l2 = l2.getNext();
      }

      if(reminder == 1) {
        old.setNext(new ListNode(1));
      }

    }
    return start;
  }

}
