
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        Doubly dub = new Doubly();
        boolean flag = true;
        while(flag == true) {
            System.out.println("----- CONTACT LIST -----");
            System.out.println("1. Add at Start");
            System.out.println("2. Add at Last");
            System.out.println("3. Add at any position");

            System.out.println("4. Delete Start Node");
            System.out.println("5. Delete Last Node");
            System.out.println("6. Delete Node at Position");
            System.out.println("7. View List Forward");
            System.out.println("8. View List Backward");
            System.out.println("9. Search");
            System.out.println("10. View List Size");
            System.out.println("11. Exit");

            System.out.println("\nEnter your choice: ");
            int choice = sc.nextInt();
            String data;
            int pos;

            switch(choice) {
                case 1 :
                    System.out.println("Enter the Element :");
                    sc.nextLine();
                    data = sc.nextLine();
                    dub.insertAtStart(data);
                    break;

                case 2:
                    System.out.println("Enter the Element :");
                    sc.nextLine();
                    data = sc.nextLine();
                    dub.insertAtLast(data);
                    break;

                case 3 :
                    System.out.println("Enter the position :");
                    pos=sc.nextInt();
                    System.out.println("Enter the Element :");
                    sc.nextLine();
                    data = sc.nextLine();
                    dub.insertAtPosition(data,pos);
                    break;

                case 4:
                    dub.deleteAtStart();
                    break;

                case 5:
                    dub.deleteAtLast();
                    break;

                case 6:
                    System.out.println("Enter the Position: ");
                    pos=sc.nextInt();
                    dub.deleteAtPosition(pos);
                    break;
                case 7 :
                    dub.printList();
                case 8 :
                    dub.backList();

                case 9:
                    System.out.println("Enter the data to search: ");
                    sc.nextLine();
                    data = sc.nextLine();
                    if (dub.search(data))
                        System.out.println("Data found in the list."+ data);
                    else
                        System.out.println("Data not found in the list.");
                    break;

                case 10:
                    System.out.println("List size: " + dub.getSize());
                    break;

                case 11:
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");



            }
        }

    }

}


class Node {
    Node nextnode;
    Node prevnode;
    String data;

    public Node() {
        data = null;
        nextnode=null;
        prevnode=null;

    }

    public Node(String data) {

        this.nextnode = null;
        this.prevnode = null;
        this.data = data;
    }

}


class Doubly{
    Node head;
    Node tail;
    int size;
    public Doubly() {

        this.head = head;
        this.tail = tail;
        this.size = size;
    }
    public Doubly(int size) {
        head = null;
        tail = null;


        size = 0;
    }


    public void insertAtStart(String data) {

        Node NewNode;
        if(head==null) {
            NewNode = new Node(data);
            head=tail=NewNode;
            head.prevnode=null;
            tail.nextnode=null;
            size++;
            System.out.println(data + " insert data in 1st position");
        }

        else {
            NewNode= new Node(data);
            head.prevnode=NewNode;
            NewNode.nextnode=head;
            head=NewNode;
            size++;
            System.out.println(data +" insert data at first position");
        }
    }

    public void insertAtLast(String data) {
        Node NewNode;
        Node temp = tail;
        if(head==null) {
            NewNode = new Node(data);
            head=tail=NewNode;
            head.prevnode=null;
            tail.nextnode=null;
            size++;
            System.out.println(data + " insert data in last position");
        }
        else {
            NewNode = new Node(data);
            NewNode.prevnode=temp;
            temp.nextnode=NewNode;
            tail=NewNode;
            size++;
            System.out.println(data +" insert at last position");

        }
    }
    public void insertAtPosition(String data, int pos) {
        Node temp = head;
        Node NewNode = new Node(data);
        if(pos==1) {
            insertAtStart(data);
        }
        if(pos == size+1){
            insertAtLast(data);
        }
        if(pos>1&& pos<=size) {
            for(int i =1;i<pos-1;i++) {
                temp=temp.nextnode;
            }
            Node t = temp.nextnode;
            temp.nextnode=NewNode;
            NewNode.prevnode=temp;
            NewNode.nextnode=t;
            t.prevnode=NewNode;
            size++;

        }
    }


    public void deleteAtStart() {
        if(head==null) {
            System.out.println("null");
        }
        else {
            Node n = head.nextnode;
            head=n;
            head.prevnode=null;
            size--;
            System.out.println("Data Delete At Start ");
        }
    }

    public void deleteAtLast() {
        if(head==null) {
            System.out.println("null");
        }
        else {
            Node n = tail.prevnode;
            tail = n;
            tail.nextnode=null;
            System.out.println("data Delete At Last ");
        }
    }

    public void deleteAtPosition(int pos) {
        if(head == null) {
            System.out.println("Null");
            return;
        }

        if(pos == 1) {
            deleteAtStart();
            return;
        }

        if(pos == size) {
            deleteAtLast();
            return;
        }

        if(pos > 1 && pos < size) {
            Node temp = head;
            for(int i = 1; i < pos; i++) {
                temp = temp.nextnode;
            }

            Node n = temp.nextnode;
            temp.nextnode = n.nextnode;
            if (n.nextnode != null) { // If not deleting last node
                n.nextnode.prevnode = temp;
            }
            n = null;
            size--;
            System.out.println("Delete Item");
        } else {
            System.out.println("Invalid Output");
        }
    }

    public void printList() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.nextnode;
        }
        System.out.println("Null");
    }


    public void backList() {
        Node temp = tail;
        while(temp!=null) {
            System.out.print(temp.data+"<-");
            temp=temp.prevnode;
        }
        System.out.println("Null");
    }

    public boolean search(String data) {
        Node temp = head;
        for(int i=1;i<=size;i++) {
            if(temp.data.equals(data)) {
                return true;
            }
            temp=temp.nextnode;
        }
        return false;
    }
    public int getSize() {
        return size;
    }


}
