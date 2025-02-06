
public class make_tree {
    public static void main(String[] args) {
        // int[] inorder = new int[]{1,2,3,4,5,6};
        int[] preorder = new int[]{10, 5, 1, 7, 40, 50};
        Tree root = null;
        // root = designTreeWithIndorder(inorder, 0, inorder.length - 1);

        root = designTreeWithPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, new int[]{0});

        // inorderTraversal(root);
        System.out.println();
        preorderTraversal(root);
    }


    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){
            this.data = data;
        }
    }

    public static Tree designTreeWithIndorder(int[] order, int left, int right){

        if(left > right){
            return null;
        }

        
        int mid = left + (right - left) / 2;
        Tree root = new Tree(order[mid]);

        root.left = designTreeWithIndorder(order, left, mid-1);
        root.right = designTreeWithIndorder(order, mid+1, right);
        return root;
        
    }


    public static Tree designTreeWithPreorder(int[] preorder, int min, int max, int[] index){

        if(index[0] >= preorder.length){
            return null;
        }

        int val = preorder[index[0]];

        if(val < min || val > max){
            return null;
        }

        Tree root = new Tree(val);
        index[0]++;

        root.left = designTreeWithPreorder(preorder, min, val, index);
        root.right = designTreeWithPreorder(preorder, val, max, index);

        return root;

    }


    public static void inorderTraversal(Tree root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    public static void preorderTraversal(Tree root){
        if(root != null){
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}
