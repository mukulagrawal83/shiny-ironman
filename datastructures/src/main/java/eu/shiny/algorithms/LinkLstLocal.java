package eu.shiny.algorithms;

/**
 * Created by e1065894 on 22-Dec-15.
 */
public class LinkLstLocal {


    public static void main(String[] args) {
        LinkListLight list = new LinkListLight();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(8);
        list.insert(12);
        list.insert(16);
        list.insert(15);
        list.insert(14);
        list.insert(13);
        list.insert(9);
        list.insert(5);

        list.rotateBy(2);
        Node node = list.head;

        for (int i = 0; i < 12; ++i){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static class LinkListLight{
        public Node head;
        public Node tail;

        public void insert(int value){
            Node node = new Node();
            node.val = value;

            if(head == null && tail == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
        }

        public void rotateBy(int num){
            while (num > 0){
                Node currHead = this.head;
                this.head = this.head.next;
                tail.next = currHead;
                tail = currHead;
                --num;
            }
        }

    }

    public static class Node{
        public int val;
        public Node next;

    }

}
