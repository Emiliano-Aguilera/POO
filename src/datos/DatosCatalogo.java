package datos;

import java.io.*;

public class DatosCatalogo {
    static public boolean guardar(Object obj)
    {
        try
        {
            FileOutputStream fout = new FileOutputStream("Catalogo.bin");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            //Serialization:
            out.writeObject(obj);
            out.close();
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    static public Object recuperar()
    {
        Object obj;
        try
        {
            FileInputStream fi = new FileInputStream("Catalogo.bin");
            ObjectInputStream fs = new ObjectInputStream(fi);
            // Deserialazation:
            obj = fs.readObject();
            fs.close();
        }
        catch(Exception ex)
        {
            obj=null;
        }
        return obj;
    }

}

