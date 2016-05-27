package node;

import java.util.ArrayList;
import java.util.List;

/**
 * Имеется дерево, каждый элемент которого является объектом типа Node со
 ссылками на родительские и дочерние ноды, а так же признак «isRoot» для
 корневой ноды. Необходимо написать логику сравнения произвольных ветвей, а
 так же реализовать хэш функцию.
 */

public class Node {
    static boolean rootExist; //для запрета создания нескольких корневых элементов

    boolean isRoot;
    Node parentNode;
    List<Node> childrenNodes;

    String name;
    int data;

    public Node(Node parentNode, String name, int data){
        this.isRoot = false; // можно не делать, и так при инициализации будет false
        this.parentNode = parentNode;
        this.name = name;
        this.data = data;
        this.childrenNodes = new ArrayList<Node>();
        if (parentNode != null)
            parentNode.childrenNodes.add(this);
    }


    public static Node getRootNode(String name, int data) //для получения корневого элемента
    {
        if (rootExist) {
            System.out.println("Корневой элемент уже существует, эта ссылка = null");
            return null;
        }
        rootExist = true;
        Node node = new Node(null, name, data);
        node.isRoot = true;
        return node;
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (isRoot != node.isRoot) return false;
        if (data != node.data) return false;
        return !(name != null ? !name.equals(node.name) : node.name != null);

    }

    public int hashCode() {
        int result = (isRoot ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + data;
        return result;
    }


}
