import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Levelorder {

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }

    }

    class createtree{
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

    }

    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    @SuppressWarnings("unchecked")
    public void levelorder(Node root){
        if(root == null){
            return;
        }
        @SuppressWarnings("rawtypes")
        Queue queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node currNode = (Levelorder.Node) queue.remove();
            if(currNode == null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                else{
                    queue.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    queue.add(currNode.right);
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Levelorder object = new Levelorder();
        createtree tree = object.new createtree();
        Node root = tree.buildtree(nodes);

        
        // object.postorder(root);
        object.levelorder(root);
        sc.close();
    }
}
