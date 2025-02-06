public class make_tree_from_inorder_preorder {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};

        Tree root = function1(preorder, inorder);
        preorder(root);
    }

    public static Tree function1(int[] preorder, int[] inorder){
        return function2(preorder, 0, preorder.length - 1, inorder, 0 , inorder.length - 1);
    }

    public static Tree function2(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){

        if(prestart > preend || instart > inend){
            return null;
        }
        int rootval = preorder[prestart];
        Tree root = new Tree(rootval);

        int rootindex = instart;
        while(inorder[rootindex] != rootval){
            rootindex++;
        }

        root.left = function2(preorder, prestart+1, prestart + (rootindex - instart), inorder, instart, rootindex - 1);
        root.right = function2(preorder, prestart + (rootindex - instart) + 1, preend, inorder, rootindex + 1, inend);

        return root;


    }

    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){
            this.data = data;
        }
    }


    public static void preorder(Tree root){
        if(root != null){
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
