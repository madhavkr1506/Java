import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class createTree{
    int index = -1;
    public Node buildtree(int[] nodes){
        index++;
        if(nodes[index] == -1){
            return null;
        }

        Node newNode = new Node(nodes[index]);
        newNode.left = buildtree(nodes);
        newNode.right = buildtree(nodes);

        return newNode;

    }

    
}

class sum{
    public int sumNode(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = sumNode(root.left);
        int rightsum = sumNode(root.right);
        return leftsum + rightsum + root.data;
    }
}
public class SumOfNodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        createTree tree = new createTree();
        Node root = tree.buildtree(nodes);

        sum object = new sum();
        int sumofnodes = object.sumNode(root);
        System.out.println(sumofnodes);

        sc.close();
    }
}
