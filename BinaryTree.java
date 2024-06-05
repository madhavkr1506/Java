import java.util.Scanner;

public class BinaryTree{
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
        public static Node buildingtree(int nodes[]){
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        buildTree tree = new buildTree();
        Node root = tree.buildingtree(nodes);
        System.out.println(root.data);
        sc.close();
    }
}


/*
 * it is a hierarchical data structure.
 * each node can have maximum two children.
 */