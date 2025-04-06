import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_1123{
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
    public static void main(String[] args) {
        Node rootNode = new Node(3);
        rootNode.left = new Node(5);
        rootNode.right = new Node(1);
        rootNode.left.left = new Node(6);
        rootNode.left.right = new Node(2);
        rootNode.right.left = new Node(0);
        rootNode.right.right = new Node(8);
        rootNode.left.right.left = new Node(7);
        rootNode.left.right.right = new Node(4);
        
        Node result = findLCADeepestLeaves(rootNode);
        System.out.println("LCA of Deepest Leaves: " + result.data);


    }

    public static int getMaxDepth(Node node){
        if (node == null){
            return 0;
        }

        int left_max_depth = getMaxDepth(node.left);
        int right_max_depth = getMaxDepth(node.right);

        return Math.max(left_max_depth, right_max_depth) + 1;
    }

    public static void collectDeepestLeaves(Node node, int depth, int maxDepth, List<Node> leaves){
        if(node == null){
            return;
        }

        if(depth == maxDepth && node.left == null && node.right == null){
            leaves.add(node);
        }

        collectDeepestLeaves(node.left, depth + 1, maxDepth, leaves);
        collectDeepestLeaves(node.right, depth + 1, maxDepth, leaves);
    }

    public static Node findLCA(Node root, Set<Node> deepest_leaves){
        if (root == null || deepest_leaves.contains(root)){
            return root;
        }

        Node left = findLCA(root.left, deepest_leaves);
        Node right = findLCA(root.right, deepest_leaves);
        if (left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }

    public static Node findLCADeepestLeaves(Node root){
        int getMaxDepth = getMaxDepth(root) - 1;

        List<Node> leaves = new ArrayList<>();
        collectDeepestLeaves(root, 0, getMaxDepth, leaves);

        Set<Node> deepest_leaves = new HashSet<>(leaves);
        return findLCA(root, deepest_leaves);

    }
}