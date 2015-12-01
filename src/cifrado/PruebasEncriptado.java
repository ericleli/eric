/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author tarda
 */
public class PruebasEncriptado {
    
    public static byte[] CrearBuffer() throws FileNotFoundException, IOException{
     File f = new File("");
      FileInputStream fis = new FileInputStream(f);
      byte[] buffer = new byte[(int) f.length()];
      fis.read(buffer);
      return buffer;
    }
     public static void main(String[] args) {
     
     
     File fil = new File("/home/tarda/Documents/hola.txt") ;
     
     
     
     }
    
    
    }

                
        
                  
   
