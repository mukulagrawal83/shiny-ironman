package eu.shiny.ds;


import java.util.Stack;

public class BinaryTree {
    public Node root;
    
    public static class Node{
        public int val;
        public String name;
        public int ht;
        public Node left;
        public Node right;
        
        public Node(int key, String name){
            this.val = key;
            this.name = name;
        }

        public Node(){
            //DO nothing
        }
    }
    
    public void addNode(Node node){
        if(root == null){
            root = node; return;
        }else{
            Node parentNode =  root;
            while(true){
                if(parentNode.val > node.val){
                    if(parentNode.left == null){
                        parentNode.left = node;
                        return;
                    }else{
                        parentNode = parentNode.left;
                    }
                }else{
                    if(parentNode.right == null){
                        parentNode.right = node;
                        return;
                    }else{
                        parentNode = parentNode.right;
                    }
                }
            }
        }
    }

    void LevelOrder(Node root){
        if(root == null){
            return;
        }else{
            java.util.Queue<Node> queue = new java.util.concurrent.LinkedBlockingDeque<Node>();
            java.util.Stack stack = new Stack();

            queue.add(root);
            while(!queue.isEmpty()){
                System.out.print(root.val + " ");
                Node node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

        }
    }


    static Node balanceTree(Node root){
        if(root == null) return null;

        if(bf(root) < 0){
            if(bf(root) < -1 && (bf(root.right) == 1 || bf(root.right) == -1)){
                if(bf(root.right) == 1){
                    Node temp = root.right;
                    root.right = temp.left;
                    temp.left = root.right.right;
                    root.right.right =temp;
                }
                Node t2 = root;
                root = root.right;
                t2.right = root.left;
                root.left = t2;
            }else{
                root.right = balanceTree(root.right);
            }
        }else if(bf(root) > 0){
            if(bf(root) > 1 && (bf(root.left) == -1 || bf(root.left) == 1)){
                if(bf(root.left) == -1){
                    Node temp = root.left;
                    root.left = temp.right;
                    temp.right = root.left.left;
                    root.left.left = temp;
                }
                Node t2 = root;
                root = root.left;
                t2.left = root.right;
                root.right = t2;
            }else{
                root.left = (balanceTree(root.left));
            }

        }

        return root;

    }

   /* Class node is defined as :
    class Node
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */

    static Node insert(Node root,int val)
    {
        Node node = new Node();
        node.val = val;
        if(root == null){
            root = node;
        }
        Node focusNode = root;
        while(true){
            if(val > focusNode.val){
                if(focusNode.right == null){
                    focusNode.right = node;
                    break;
                }else{
                    focusNode = focusNode.right;
                }
            }else{
                if(focusNode.left == null){
                    focusNode.left = node;
                    break;
                }else{
                    focusNode = focusNode.left;
                }
            }
        }

        Node balancedRoot = balanceTree(root);
        updateHeight(balancedRoot);
        //balance the tree from here
        return balancedRoot;

    }

    static void updateHeight(Node root){
        if(root == null){
            return ;
        }
        root.ht = height(root);
        updateHeight(root.right);
        updateHeight(root.left);
    }

    static int bf(Node node){
        int left = (node.left != null) ?  height(node.left) : -1;
        int right = (node.right != null) ?  height(node.right) : -1;

        return left - right;
    }

    static int height(Node node){
        if(node == null){
            return -1;
        }

        return 1 + max(height(node.left), height(node.right));
    }

    static int max(int num1, int num2){
        return num1>num2 ? num1: num2;
    }




    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        Node node = new Node(50, "M");
        Node node1 = new Node(25, "M");
        Node node2 = new Node(35, "M");
        Node node3 = new Node(30, "M");
        Node node4 = new Node(15, "M");
        Node node5 = new Node(45, "M");
        
        tree.addNode(node5);
        tree.addNode(node1);
        tree.addNode(node2);
        tree.addNode(node3);
        tree.addNode(node4);
        tree.addNode(node);
        tree.addNode(new Node(10, ""));
        tree.addNode(new Node(20, ""));
        tree.addNode(new Node(40, ""));
//        tree.printString();

    }



}
