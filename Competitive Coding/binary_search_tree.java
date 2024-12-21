public class binary_search_tree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class treeFunction{

        public boolean searchNode(Node root, int data){
            if(root == null){
                return false;
            }
            if(root.data == data){
                return true;
            }
            else if(data < root.data){
                return searchNode(root.left, data);
            }
            else{
                return searchNode(root.right, data);
            }
        }

        public Node insertNode(Node root, int data){
            if(root == null){
                return new Node(data);
            }
            else if(data < root.data){
                root.left = insertNode(root.left, data);
            }else{
                root.right = insertNode(root.right, data);
            }
            return root;
        }

        public static Node findpacket(Node node){
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        public Node deleteNode(Node root,int data){
            if(root == null){
                return root;
            }
            if(data < root.data){
                root.left = deleteNode(root.left, data);
            }
            else if(data > root.data){
                root.right = deleteNode(root.right, data);
            }
            else{
                if(root.left == null && root.right == null){
                    return null;
                }
                if(root.left == null){
                    return root.right;
                }else if(root.right == null){
                    return root.left;
                }

                Node successor = findpacket(root.right);
                root.data = successor.data;
                root.right = deleteNode(root.right, successor.data);
            }

            return root;

        }

        public void inorderTraversal(Node root){
            if(root != null){
                inorderTraversal(root.left);
                System.out.print(root.data + " ");
                inorderTraversal(root.right);
            }
        }
        public void preorderTraversal(Node root){
            if(root != null){
                System.out.print(root.data + " ");
                preorderTraversal(root.left);
                preorderTraversal(root.right);
            }
        }
        public void postorderTraversal(Node root){
            if(root != null){
                postorderTraversal(root.left);
                postorderTraversal(root.right);
                System.out.print(root.data + " ");
            }
        }
    }
    public static void main(String[] args) {
        Node rootNode = null;
        treeFunction tree = new treeFunction();
        rootNode = tree.insertNode(rootNode, 50);
        rootNode = tree.insertNode(rootNode, 30);
        rootNode = tree.insertNode(rootNode, 70);
        rootNode = tree.insertNode(rootNode, 20);
        rootNode = tree.insertNode(rootNode, 40);
        rootNode = tree.insertNode(rootNode, 60);
        rootNode = tree.insertNode(rootNode, 80);

        System.out.println("Node inserted successfully");

        tree.inorderTraversal(rootNode);
        System.out.println();
        tree.preorderTraversal(rootNode);
        System.out.println();
        tree.postorderTraversal(rootNode);

        rootNode = tree.deleteNode(rootNode, 20);
        System.out.println("\nNode after deletion");

        tree.inorderTraversal(rootNode);
        System.out.println();
        tree.preorderTraversal(rootNode);
        System.out.println();
        tree.postorderTraversal(rootNode);

    }
}
