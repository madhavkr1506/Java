import java.util.*;

public class Tree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public static void levelorder(Node root){
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return;
        }
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node cuuNode = queue.remove();
            if(cuuNode == null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }
            else{
                System.out.print(cuuNode.data+" ");
                if(cuuNode.left != null){
                    queue.add(cuuNode.left);
                }
                if(cuuNode.right != null){
                    queue.add(cuuNode.right);
                }
            }
            
        }
    }
    public static void main(String[] args) {
        Node rootnode = new Node(10);
        Node leftnode = new Node(5);
        Node rightnode = new Node(15);
        Node leftnodeleftchild = new Node(3);
        Node leftnoderightchild = new Node(7);
        Node rightnodeleftchild = new Node(13);
        Node rightnoderightchild = new Node(19);

        rootnode.left = leftnode;
        rootnode.right = rightnode;

        leftnode.left = leftnodeleftchild;
        leftnode.right = leftnoderightchild;

        rightnode.left = rightnodeleftchild;
        rightnode.right = rightnoderightchild;

        System.out.println(rootnode.left.data);

        System.out.println(rootnode.left.left.data);

        System.out.println("Preorder : ");
        preorder(rootnode);
        System.out.println("\nInorder : ");
        inorder(rootnode);
        System.out.println("\nLevel order : ");
        levelorder(rootnode);

    }
}
