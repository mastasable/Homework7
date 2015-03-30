/**
 * Created by admin on 28.03.2015.
 */
public class MiddleNode extends Node{
    public final Node left, right;

    public MiddleNode(Node l, Node r) {
        super(l.popularity + r.popularity);
        left = l;
        right = r;
    }
}
