/**
 * Created by admin on 28.03.2015.
 */
public class Node implements Comparable{
    public final int popularity;

    public Node(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public int compareTo(Object o) {
        int res = 0;
        Node compared = (Node) o;
        if (compared.popularity < this.popularity){
            res = -1;
        }
        if(compared.popularity > this.popularity){
            res = 1;
        }
        return res;
    }
}
