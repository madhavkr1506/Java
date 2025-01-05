import java.util.Scanner;

public class Height {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;

        }
    }
    int index = -1;
    public Node buildtree(int[] nodes){
        
        index++;
        if(nodes[index] == -1){
            return null;
        }
        Node newnode = new Node(nodes[index]);
        newnode.left = buildtree(nodes);
        newnode.right = buildtree(nodes);
        return newnode;
    }

    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public int countNode(Node root){
        if(root == null){
            return 0;
        }
        int leftheight = countNode(root.left);
        int rightheight = countNode(root.right);
        return leftheight + rightheight + 1;
    }

    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Height tree = new Height();
        Node root = tree.buildtree(nodes);
        // tree.postorder(root);
        // System.out.println(tree.countNode(root));

        System.out.println(tree.height(root));
        sc.close();
    }
}
