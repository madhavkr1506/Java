import java.util.Scanner;

public class Preorder {
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

    static class buildTree{
        static int index = -1;
        public static Node buildingtree(int[] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildingtree(nodes);
            newNode.right = buildingtree(nodes);

            return newNode;

        }
    }

    public static void preorder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        buildTree tree = new buildTree();
        Node root = tree.buildingtree(nodes);
        preorder(root);
        sc.close();
    }
}
