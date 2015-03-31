import java.util.*;

/**
 * Created by admin on 30.03.2015.
 */
public class Encode {
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

    public static HashMap buildCodeTable(Node node, StringBuffer code){
        HashMap<Character, String> codeTable = new HashMap<>();
        if(node instanceof FinalNode){
            FinalNode finalNode = (FinalNode)node;
            finalNode.setCode(code.toString());
            codeTable.put(finalNode.getaChar(), finalNode.getCode());
        } else if (node instanceof MiddleNode){
            MiddleNode middleNode = (MiddleNode)node;

            code.append('0');
            buildCodeTable(middleNode.left, code);
            code.deleteCharAt(code.length()-1);

            code.append('1');
            buildCodeTable(middleNode.right, code);
            code.deleteCharAt(code.length()-1);
        }
        return codeTable;
    }

}
