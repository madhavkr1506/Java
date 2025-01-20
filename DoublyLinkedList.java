import java.util.Scanner;

public class DoublyLinkedList{
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = this.prev = null;
        }
    }

    public static void traverse(Node ptr){
        while(ptr.next != null){
            ptr = ptr.next;
        }
        while(ptr != null){
            System.out.print(ptr.data + " ");
            ptr = ptr.prev;
        }
    }

    public static Node insertionNodeAtBeg(Node head,int data){
        Node ptr = new Node(data);
        ptr.data = data;
        ptr.next = head;
        ptr.prev = null;
        if(head != null){
            head.prev = ptr;
        }
        return ptr;
    }

    public static Node insertNodeAtLast(Node head, int data){
        Node ptr = new Node(data);
        Node p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = ptr;
        ptr.data = data;
        ptr.prev = p;
        ptr.next = null;

        return ptr;
    }

    public static Node insertAfterNode(Node head, int targetData, int data) {
        Node ptr = new Node(data);
        Node p = head;

        
        while (p != null && p.data != targetData) {
            p = p.next;
        }

        
        if (p != null) {
            ptr.next = p.next;
            ptr.prev = p;
            if (p.next != null) {
                p.next.prev = ptr;
            }
            p.next = ptr;
        } else {
            System.out.println("Target node not found");
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input node count : ");
        int nodeCount = sc.nextInt();

        Node head = null;
        Node tail = null;

        for(int i=0;i<nodeCount;i++){
            System.out.print("Input "+(i+1)+" Node : ");
            int value = sc.nextInt();
            Node newnode = new Node(value);

            if(head == null){
                head = newnode;
                tail = newnode;
            }
            else{
                tail.next = newnode;
                newnode.prev = tail;
                tail = newnode;
            }
        }

        System.out.println("Doubly Linked List : ");
        traverse(head);

        // System.out.println("\nInserting node at beginning : ");
        // int begNode = sc.nextInt();
        // Node headNode = insertionNodeAtBeg(head, begNode);
        // traverse(head);

        // System.out.println("\nInserting node at last : ");
        // int lastNode = sc.nextInt();
        // Node endNode = insertNodeAtLast(head, lastNode);
        // traverse(head);

        System.out.println("\nInput new node to insert and target node data: ");
        int newNodeData = sc.nextInt();
        int targetData = sc.nextInt();

        head = insertAfterNode(head, targetData, newNodeData);
        System.out.println("Doubly Linked List after insertion: ");
        traverse(head);
        sc.close();
    }
}