public class reverse_linked_list {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void traverse(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node next = null;
        Node prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }

        return prev;
    }

    public static boolean palindromeLinkedList(Node head){
        if(head == null || head.next == null){
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node curr = slow;
        Node next = null;
        Node prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node firsthalf = head;
        Node secondhalf = prev;

        while (secondhalf != null) {
            if(firsthalf.data != secondhalf.data){
                return false;
            }

            firsthalf = firsthalf.next;
            secondhalf = secondhalf.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.next = new Node(2);
        rootNode.next.next = new Node(3);
        rootNode.next.next.next = new Node(2);
        rootNode.next.next.next.next = new Node(10);

        traverse(rootNode);

        System.out.println("\nReverse Linked list");

        rootNode = reverse(rootNode);

        traverse(rootNode);


        System.out.println(palindromeLinkedList(rootNode));
    }
}
