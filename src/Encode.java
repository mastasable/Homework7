import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by admin on 30.03.2015.
 */
public class Encode {
    public static void main(String...args){
        String s = "it my striiiiiing!";
        char[] chars = s.toCharArray();
        ArrayList<Node> nodes = new ArrayList<Node>();
        int[] charPop = new int[256];

        for (char c : chars){
            charPop[c]++;
        }
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

    }

}
