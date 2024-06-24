import java.util.Scanner;

public class Solution {
    static class Node {
        int data;
        Node next;
        Node() {}

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node createLinkedList(String[] input) {
        Node head = null;
        Node tail = null;
        if (input != null) {
            for (String s : input) {
                Node newNode = new Node(Integer.parseInt(s));
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
        }
        return head;
    }

    public static void traverse(Node ptr) {
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static Node addTwoNodes(Node head1, Node head2) {
        Node dummyNode = new Node();
        Node curr = dummyNode;
        int total = 0;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            total = carry;
            if (head1 != null) {
                total += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                total += head2.data;
                head2 = head2.next;
            }
            int num = total % 10;
            carry = total / 10;
            curr.next = new Node(num);
            curr = curr.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first list : ");
        String input1[] = sc.nextLine().split(" ");
        Node head1Node = createLinkedList(input1);

        System.out.println("Input second list : ");
        String input2[] = sc.nextLine().split(" ");
        Node head2Node = createLinkedList(input2);

        Node result = addTwoNodes(head1Node, head2Node);
        traverse(result);

        sc.close();
    }
}
