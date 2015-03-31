/**
 * Created by admin on 28.03.2015.
 */
public class FinalNode extends Node{
    public final char aChar;
    String code;

    public void setCode(String code) {
        this.code = code;
    }

    public char getaChar() {
        return aChar;
    }

    public String getCode() {
        return code;
    }

    public FinalNode(char c, int pop) {
        super(pop);
        this.aChar = c;
    }
}
