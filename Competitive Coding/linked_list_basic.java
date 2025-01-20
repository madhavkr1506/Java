import java.util.Scanner;

public class linked_list_basic {
    static class node{
        int data;
        node prev;
        node next;
        node(int data){
            this.data = data;
            this.prev = this.next = null;
        }
    }
    public static void traverse_node(node head){
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void reverse(node head){
        while (head.next != null) {
            head = head.next;
        }
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.prev;
        }
    }

    public static node insert_node_at_beg(node head, int data){
        node node_ = new node(data);
        node_.data = data;
        node_.next = head;
        node_.prev = null;
        if(head != null){
            head.prev = node_;
        }
        return node_;

    }


    public static node insert_node_at_last(node head, int data){
        node node_ = new node(data);
        node temp_node = head;
        node_.data = data;
        while(temp_node.next != null){
            temp_node = temp_node.next;
        }

        temp_node.next = node_;
        node_.next = null;
        node_.prev = temp_node;

        return head;
    }


    public static node insert_node_at_index(node head, int data, int index){
        node node_ = new node(data);
        node_.data = data;

        node temp_node = head;

        int i = 0;
        while(i != index - 1){
            temp_node = temp_node.next;
            i++;
        }

        node_.next = temp_node.next;
        node_.prev = temp_node;
        temp_node.next = node_;
        if(node_.next != null){
            node_.next.prev = node_;
        }

        return head;

    }

    public static node delete_node_at_beg(node head){
        node temp_node = head;
        head = head.next;
        head.prev = null;
        return head;
    }

    public static node delete_node_at_end(node head){
        node temp = head;
        node temp_ = head.next;
        while (temp_.next != null) {
            temp = temp.next;
            temp_ = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static node delete_node_at_index(node head, int index){
        node temp = head;
        node temp_ = head.next;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
            temp_ = temp_.next;
        }

        temp.next = temp_.next;
        temp.next.prev = temp;

        return head;
    }


    public static node delete_node_at_value(node head, int data){
        node temp = head;
        node temp_ = head.next;
        while(temp_.next != null && temp_.data != data){
            temp = temp.next;
            temp_ = temp_.next;
        }

        if(temp_.data == data){
            temp.next = temp_.next;
            temp.next.prev = temp;
        }
        return head;
    }

    public static void sort_linked_list(node head){
        node start = null;
        node end = null;
        int swapped = 0;
        if(head == null){
            return;
        }

        do{
            swapped = 0;
            start = head;
            while(start.next != end){
                if(start.data > start.next.data){
                    int temp = start.data;
                    start.data = start.next.data;
                    start.next.data = temp;
                    swapped = 1;
                }
                start = start.next;
            }
            end = start;


        }while(swapped != 0);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input total number of nodes: ");
        int number = sc.nextInt();

        node head = null;

        for(int i=0;i<number;i++){
            System.out.print("Input data: ");
            int data = sc.nextInt();;
            head = insert_node_at_beg(head, data);
        }

        traverse_node(head);
        System.out.println();
        reverse(head);

        // System.out.print("\nInsert node at end: ");
        // int data = sc.nextInt();
        // head = insert_node_at_last(head, data);

        // traverse_node(head);
        // System.out.println();
        // reverse(head);

        // System.out.print("\nInsert node at an index: ");
        // int index_data = sc.nextInt();
        // head = insert_node_at_index(head, index_data,3);

        // traverse_node(head);
        // System.out.println();
        // reverse(head);

        // System.out.println();
        // head = delete_node_at_beg(head);
        // traverse_node(head);
        // System.out.println();
        // reverse(head);

        // System.out.println();
        // head = delete_node_at_end(head);
        // traverse_node(head);
        // System.out.println();
        // reverse(head);

        // System.out.println();
        // head = delete_node_at_index(head,2);
        // traverse_node(head);
        // System.out.println();
        // reverse(head);


        // System.out.println();
        // head = delete_node_at_value(head,5);
        // traverse_node(head);
        // System.out.println();
        // reverse(head);

        sort_linked_list(head);

        System.out.println();
        traverse_node(head);

        
    }
}
