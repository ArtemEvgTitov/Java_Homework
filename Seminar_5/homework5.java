package Seminar_5;

import java.util.ArrayList;

public class homework5 {
    public static void main(String[] args) {
        Node root = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n20 = new Node(20);

        ArrayList<Node> temp_array_root = new ArrayList<Node>();
        temp_array_root.add(n2);
        temp_array_root.add(n3);
        root.son = temp_array_root;

        ArrayList<Node> temp_array_n2 = new ArrayList<Node>();
        temp_array_n2.add(n4);
        n2.son = temp_array_n2;

        ArrayList<Node> temp_array_n3 = new ArrayList<Node>();
        temp_array_n3.add(n5);
        temp_array_n3.add(n6);
        n3.son = temp_array_n3;

        ArrayList<Node> temp_array_n4 = new ArrayList<Node>();
        temp_array_n4.add(n7);
        temp_array_n4.add(n8);
        temp_array_n4.add(n9);
        n4.son = temp_array_n4;

        ArrayList<Node> temp_array_n6 = new ArrayList<Node>();
        temp_array_n6.add(n11);
        temp_array_n6.add(n20);
        n6.son = temp_array_n6;

        preOrder(root, "");

    }

    static void preOrder(Node tree, String space) {
        if (tree != null)
            System.out.println(space + tree.value);
        else {
            System.out.println(space + "nil");
            return;
        }

        for (int i = 0; i < tree.son.size(); i++) {
            preOrder(tree.son.get(i), space + "  ");
        }
    }
}

class Node {
    int value;
    ArrayList<Node> son = new ArrayList<Node>();

    public Node(int value) {
        this.value = value;
    }
}