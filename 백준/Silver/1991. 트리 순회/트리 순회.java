import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node("A");
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String[] tmp = br.readLine().split(" ");
            Node cur = root.get(tmp[0]);
            if(!tmp[1].equals("."))
                cur.left = new Node(tmp[1]);
            if(!tmp[2].equals("."))
                cur.right = new Node(tmp[2]);
        }
        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);

        System.out.println(sb);
    }
    static void preOrder(Node node){
        if(node == null)
            return;
        sb.append(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    static void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        sb.append(node.data);
        inOrder(node.right);
    }
    static void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.data);
    }
}

class Node{
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }
    Node get(String search){
        if(search.equals(this.data))
            return this;
        Node node = null;
        if(this.left != null)
            node = this.left.get(search);
        if(node == null && this.right != null)
            node = this.right.get(search);
        return node;
    }
}