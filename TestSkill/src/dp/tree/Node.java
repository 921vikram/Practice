package dp.tree;

public class Node {

  protected Node left;
  protected Node right;
  private int value;
  private char strValue;

  protected Node next;

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public char getStrValue() {
    return strValue;
  }

  public void setStrValue(char strValue) {
    this.strValue = strValue;
  }

  public Node(char value) {
    this.strValue = value;
  }

  public Node(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
