class node{
    int data;
    node left;
    node right;
    int height;
    node(int data){
        this.data = data;
        this.left = this.right = null;
        height = 1;

    }
}

class avltree{
    node root;

    int max_between_two(int a, int b){
        return (a > b) ? a : b;
    }

    int get_height(node node_){
        if(node_ == null){
            return 0;
        }
        else{
            return node_.height;
        }
    }

    int balance_factor(node node_){
        if(node_ == null){
            return 0;
        }
        else{
            return get_height(node_.left) - get_height(node_.right);
        }
    }

    node left_rotate(node node_){
        node x = node_.right;
        node y = x.left;

        x.left = node_;
        node_.right = y;

        node_.height = 1 + max_between_two(get_height(node_.left), get_height(node_.right));
        x.height = 1 + max_between_two(get_height(x.left), get_height(x.right));

        return x;
    }


    node right_rotate(node node_){
        node x = node_.left;
        node y = x.right;

        x.right = node_;
        node_.left = y;

        node_.height = 1 + max_between_two(get_height(node_.left), get_height(node_.right));
        x.height = 1 + max_between_two(get_height(x.left), get_height(x.right));
        return x;
    }


    node insert_node (node node_, int data){
        if (node_ == null){
            return new node(data);
        }
        if(data < node_.data){
            node_.left = insert_node(node_.left, data);
        }
        else if(data > node_.data){
            node_.right = insert_node(node_.right, data);
        }
        else{
            return node_;
        }

        node_.height = max_between_two(get_height(node_.left), get_height(node_.right)) + 1;

        int balance_factor = balance_factor(node_);

        if(balance_factor > 1 && data < node_.left.data){
            return right_rotate(node_);
        }
        else if(balance_factor > 1 && data > node_.left.data){
            node_.left = left_rotate(node_.left);
            return right_rotate(node_);
        }
        else if(balance_factor < -1 && data > node_.right.data){
            return left_rotate(node_);
        }
        else if(balance_factor < -1 && data < node_.right.data){
            node_.right = right_rotate(node_.right);
            return left_rotate(node_);
        }
        return node_;
    }

    boolean search_node (node node_,int data){
        if(node_ == null){
            return false;
        }
        if(data == node_.data){
            return true;
        }

        if (data < node_.data){
            return search_node(node_.left, data);
        }
        else{
            return search_node(node_.right, data);
        }

    }

    void insert(int data){
        root = insert_node(root, data);
    }

    boolean search(int data){
        return search_node(root, data);
    }


}
public class avl_tree {
    public static void main(String[] args) {
        avltree tree = new avltree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
        
        System.out.println("Searching node 30: " + tree.search(30));
        System.out.println("Searching node 60: " + tree.search(60));

    }
}

