public class BinaryTreeMaximumPathSum {
    static class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);

        int max_path_sum = function1(root);
        System.out.println(max_path_sum);
        
    }

    public static int function1(node root){
        int[] res = {root.data};
        return function2(root, res);
    }

    public static int function2(node root, int[] res){
        if(root == null){
            return 0;
        }
        int leftpart = Math.max(0, function2(root.left, res));
        int rightpart = Math.max(0, function2(root.right, res));
        res[0] = Math.max(res[0], leftpart + rightpart + root.data);
        return root.data + Math.max(leftpart, rightpart);
    }
}
