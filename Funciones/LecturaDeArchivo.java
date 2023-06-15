package Funciones;

import java.io.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

/*
yaser
 */

public class LecturaDeArchivo {

    RandomAccessFile file;
    RandomAccessFile file2;
    RandomAccessFile file3;
    

    public void escribirTxtDat(String ruta, String nombreArchivo) {

        try {

            file = new RandomAccessFile(nombreArchivo, "rw");

            File arch = new File(ruta);
            FileReader fr = new FileReader(arch);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                String docfin = "";
                docfin = linea;

                LLave per = new LLave();
                per.setLlave(docfin);
                per.escribir(file);
                linea = br.readLine();

            }

            file.close();
            br.close();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e);
        }
    }

    public void reporte(String nombreArchivo) throws IOException {
        file = new RandomAccessFile(nombreArchivo, "r");
        LLave per = new LLave();
        String mensaje = "";
        while (file.getFilePointer() < file.length()) {
            per.leer(file);

            mensaje += per.getLlave() + "\n";
        }
        //JOptionPane.showMessageDialog(null, mensaje);
        System.out.println(mensaje);
        file.close();
    }
     public void escribirDat(String nombreArchivo, String key) throws FileNotFoundException, IOException{
        file = new RandomAccessFile(nombreArchivo, "rw");
        file.seek(file.length());
        LLave per = new LLave();
        per.setLlave(key);
        per.escribir(file);
        file.close();
    }

    public void ordenar(String nombreArchivo) throws IOException {
        file = new RandomAccessFile(nombreArchivo, "r");
        LLave per = new LLave();
        int k = 0;
        while (file.getFilePointer() < file.length()) {
            per.leer(file);
            k++;
        }
        ;
        
        file.close();
        String[] arr = new String[k];
        
        file2 = new RandomAccessFile(nombreArchivo, "r");
        LLave per2 = new LLave();
        String mensaje = "";
        int cont=0;
        while (file2.getFilePointer() < file2.length()) {
            per2.leer(file2);
            mensaje = per2.getLlave();
            arr[cont]=mensaje;
            cont++;
        }
        file2.close();
        Arrays.sort(arr);
        if(k<15){
            for(int f = 0; f < arr.length; f ++){
                escribirDat("llavesDiario2.dat", arr[f]);
            }
            System.out.println("entro ord2");
        }else{
            for(int f = 0; f < arr.length; f ++){
                escribirDat("llavesMayor1.dat", arr[f]);
            }
            System.out.println("entro ord1");
        }
        

    }
    
    public void Secuencia(String nomArch1,String nomArch2) throws IOException {
        file = new RandomAccessFile(nomArch1, "r");
        
        
        LLave per = new LLave();
        LLave per2 = new LLave();
        String Arch1 = "";
        String Arch2 = "";
        String docfin="";
        while (file.getFilePointer() < file.length()) {
            per.leer(file);

            Arch1 = per.getLlave().substring(0,3) + "\n";
            docfin+=per.getLlave().substring(0, 29)+"\n";
            file2 = new RandomAccessFile(nomArch2, "r");
            while(file2.getFilePointer() < file2.length()) {
                per2.leer(file2);
                
                Arch2=per2.getLlave().substring(0, 3)+"\n";
                if(Arch2.equals(Arch1)){
                    docfin+="       "+per2.getLlave().substring(3,per2.getLlave().length())+"\n";
                }else{
                    
                }
                
            }
            
        }
         escribirDat("libroOrdenadoContabilidad.dat", docfin);
         docfin="";
        file.close();
        file2.close();
        
    }

}
