package main;

import node.Node;

/**
 * Имеется дерево, каждый элемент которого является объектом типа Node со
 * ссылками на родительские и дочерние ноды, а так же признак «isRoot» для
 * корневой ноды. Необходимо написать логику сравнения произвольных ветвей, а
 * так же реализовать хэш функцию.
 */

public class Main {
    public static void main(String[] args) {
        Node n1 = Node.getRootNode("Element", 4);
        Node n2 = Node.getRootNode("null node", 2);
        Node n3 = new Node(n1, "Element", 4);
        Node n4 = new Node(n3, "Element", 4);
        Node n5 = new Node(n3, "node5", 4);
        Node n6 = new Node(n3, "Element", 4);
        System.out.println(n1.equals(n3)); //false n1 - корневой, он не равен ни одному другому элементу, потому что isRoot учавствует при расчете hashCode()
        System.out.println(n1.equals(n4)); //false
        System.out.println(n3.equals(n4)); //true
        System.out.println(n5.equals(n4)); //false
        System.out.println(n6.equals(n3)); //true
    }
}
