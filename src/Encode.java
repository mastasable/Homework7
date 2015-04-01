import java.util.*;

/**
 * Created by admin on 30.03.2015.
 */
public class Encode {
    public static void compress(String s){
        char[] chars = s.toCharArray();

        int[] charPop = new int[65536];
        for (char c:chars)
            charPop[c]++;
        Node root = buildTree(charPop);
        buildCodeTable(root, new StringBuffer());
        writeCode(root);

    }

    public static Node buildTree(int[] charPop){
        ArrayList<Node> nodes = new ArrayList<Node>();

        for (int i=0; i<charPop.length; i++){
            if (charPop[i]>0){
                FinalNode finalNode = new FinalNode((char)i, charPop[i]);
                nodes.add(finalNode);
            }
        }
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node a = nodes.get(nodes.size()-1);
            Node b = nodes.get(nodes.size()-2);
            nodes.remove(nodes.size()-1);
            MiddleNode middleNode = new MiddleNode(a, b);
            nodes.add(middleNode);
            nodes.remove(nodes.size()-2);
        }
        return nodes.get(0);
    }

    public static void buildCodeTable(Node node, StringBuffer code){
        if(node instanceof FinalNode){
            FinalNode finalNode = (FinalNode)node;
            finalNode.setCode(code.toString());
        } else if (node instanceof MiddleNode){
            MiddleNode middleNode = (MiddleNode)node;

            code.append('0');
            buildCodeTable(middleNode.left, code);
            code.deleteCharAt(code.length()-1);

            code.append('1');
            buildCodeTable(middleNode.right, code);
            code.deleteCharAt(code.length()-1);
        }

    }

    public static void writeCode(Node node){
        if(node instanceof FinalNode){
            System.out.print(((FinalNode) node).code);
            return;
        } else if (node instanceof  MiddleNode){
            writeCode(((MiddleNode) node).left);
            writeCode(((MiddleNode) node).right);
        }
    }

}
