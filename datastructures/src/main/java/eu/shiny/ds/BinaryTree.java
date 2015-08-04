
public class BinaryTree {
    public Node root;
    
    public static class Node{
        public int key;
        public String name;
        
        public Node leftChild;
        public Node rightChild;
        
        public Node(int key, String name){
            this.key = key;
            this.name = name;
        }
    }
    
    public void addNode(Node node){
        if(root == null){
            root = node; return;
        }else{
            Node parentNode =  root;
            while(true){
                if(parentNode.key > node.key){
                    if(parentNode.leftChild == null){
                        parentNode.leftChild = node;
                        return;
                    }else{
                        parentNode = parentNode.leftChild;
                    }
                }else{
                    if(parentNode.rightChild == null){
                        parentNode.rightChild = node;
                        return;
                    }else{
                        parentNode = parentNode.rightChild;
                    }
                }
            }
        }
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
        tree.printString();
        
    }
    
    public void printString(){
          breadthFirstSearch(root);
            
//        printNode(root);
//        
//        Node focusNode = root;
//        Node nextFocusNode = null;
//        boolean isLeftNode = false;
//        boolean isRIghtNode = false;
////        
//        while(focusNode != null ){
//                printNode(focusNode.leftChild);
//                printNode(focusNode.rightChild);
//                
//                if(nextFocusNode != null){
//                    printNode(nextFocusNode.leftChild);
//                    printNode(nextFocusNode.rightChild);
//                }
//            
//                focusNode = focusNode.leftChild;
//                nextFocusNode = focusNode.rightChild;
//        }
//        
//        printNode(root.leftChild);
//        printNode(root.rightChild);
//        
//        
//        printNode(root.leftChild.leftChild);
//        printNode(root.leftChild.rightChild);
//        
//        printNode(root.rightChild.leftChild);
//        printNode(root.rightChild.rightChild);
//
//        printNode(root.leftChild.leftChild.leftChild);
//        printNode(root.leftChild.leftChild.rightChild);
//        
//        printNode(root.leftChild.rightChild.leftChild);
//        printNode(root.leftChild.rightChild.rightChild);
    }
    
    public void postOrderTraversal(Node node){
        if(node!= null){
            printNode(node.leftChild);
            printNode(node.rightChild);
            System.out.println(node.key);
        }
    }
    
    public void printNode(Node node){
        if(node!= null){
            System.out.println(node.key);
            
        }
    }
    
    public void breadthFirstSearch(Node node){
        
        if(node != null){
            System.out.println(node.key);
            
        }
    }
    
}
