import java.util.*;
import java.io.*;

public class DoublyLinkedList {

    private int counter = 0;
    private Node first;
    private Node last;
    private Node temp;

    public DoublyLinkedList() {

    }

    class Node {
        public int Element;
        public Node next;
        public Node previous;

    }

    public DoublyLinkedList(String e)
    {
        String d = null;
        e = d;
    }

    public int Size()
    {return counter;}

    public void AddElem(int e){
        if (first == null){
            first = new Node();
            first.Element = e;
            last = first;
        } else {
            last.next = new Node();
            temp = last;
            last = last.next;
            last.Element = e;
            last.previous = temp;
        }
        counter++;
    }
    public int RemoveElem(int pos) {
        assert(pos >= 0 && pos < Size()):"That is an invalid position in the list";
        temp = first;
        if (pos == 0){
            int element = first.Element;
            first = first.next;
            counter--;
            return element;
        }
        for (int j=0;j<pos-1;j++){
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = temp2.next;
        int element = temp2.Element;
        temp.next.previous = temp;
        temp2 = null;
        counter--;
        return element;
    }

    public void view(int data){
        temp = first;
        System.out.println("These are the elements: ");
        if (Size()>0) {
            for(int k=0;k<Size();k++) {
                System.out.print(temp.Element + ", ");
                temp = temp.next;
            }
        }
        System.out.println("");
    }



    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println(" Please You are welcome to LinKed list");
            System.out.println("Select an operation: ");
            System.out.println("1. Choose an item to the list");
            System.out.println("2. Remove an item from the list");
            System.out.println("3. Preview the list");
            System.out.println("4. Quit");

            Scanner input = new Scanner(System.in);
            int choice = Integer.parseInt(input.next());
            int element= 0;
            switch(choice) {
                case 1:
                    System.out.println("Please Enter the item to be added to the list:");
                    element = Integer.parseInt(input.next());
                    list.AddElem(element);
                    break;
                case 2:
                    System.out.println("Please Select the position of the item you want to remove from the list:");
                    int pos = Integer.parseInt(input.next());
                    System.out.println("The element " + list.RemoveElem(pos) + " was removed.");
                    break;
                case 3:
                    list.view(element);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong input, Please try again.");
                    break;
            }

        }
    }
}