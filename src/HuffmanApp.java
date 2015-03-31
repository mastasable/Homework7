import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by admin on 30.03.2015.
 */
public class HuffmanApp {
    public static void main(String...args){
        String s = "Привет с больщого бодуна!";
        char[] chars = s.toCharArray();
        int[] charPop = new int[65536]; //количество символов UTF-8
        for(char c:chars){
            charPop[c]++;
        }
        Node node = Encode.buildTree(charPop);
        System.out.println(Encode.buildCodeTable(node, new StringBuffer()));

    }
}
