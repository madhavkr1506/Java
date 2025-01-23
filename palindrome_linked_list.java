public class palindrome_linked_list {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    public static Node insertNodeAtLast(Node head, int data){
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        Node newnode = new Node(data);
        newnode.data = data;
        temp.next = newnode;
        newnode.next = null;
        return head;

    }

    public static void traverseNode(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head = insertNodeAtLast(head, 100);
        head = insertNodeAtLast(head, 200);
        head = insertNodeAtLast(head, 300);
        head = insertNodeAtLast(head, 400);
        head = insertNodeAtLast(head, 500);
        head = insertNodeAtLast(head, 600);
        head = insertNodeAtLast(head, 700);
        traverseNode(head);
        System.out.println();
        System.out.println(checkpalindromelinkedlist(head));
        
    }

    public static boolean checkpalindromelinkedlist(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node curr = slow;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node firsthalf = head;
        Node secondhalf = prev;

        while(secondhalf != null){
            if(firsthalf.data != secondhalf.data){
                return false;
            }
            firsthalf = firsthalf.next;
            secondhalf = secondhalf.next;
        }

        return true;

    }
}
