import java.io.OutputStream;

/**
 * Created by admin on 28.03.2015.
 */
public class BitWriter {
    OutputStream os;
    int collectedByte;
    int pos = 0;

    public  BitWriter(OutputStream os){
        this.os = os;
    }

    public void write(boolean bit){
        collectedByte *= 2;
        if(bit) collectedByte += 1;
    }

    public void flush(){

    }
}
