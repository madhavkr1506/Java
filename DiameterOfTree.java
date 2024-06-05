import java.util.Scanner;

public class DiameterOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class createtree{
        static int index = -1;
        public static Node buildtree(int [] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newnode = new Node(nodes[index]);
            newnode.left = buildtree(nodes);
            newnode.right = buildtree(nodes);

            return newnode;
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);

        return Math.max(leftheight,rightheight) + 1;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3,Math.max(diam1,diam2));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        createtree tree = new createtree();
        Node root = tree.buildtree(nodes);
        System.out.println(diameter(root));
        sc.close();
    }
}
