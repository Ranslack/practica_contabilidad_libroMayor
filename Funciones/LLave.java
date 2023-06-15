package Funciones;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author yaser
 */


public class LLave {

    public String llave;
    RandomAccessFile file;
    
    public void escribir(RandomAccessFile file) throws IOException{
        file.writeUTF(this.llave);
    }
    
    public void leer(RandomAccessFile file) throws IOException{
        this.llave = file.readUTF();
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave+"\n";
    }
    
    
    
}
