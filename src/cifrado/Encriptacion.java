package Cifrado;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author tarda
 */
public class Encriptacion {

    /**
     * @param args the command line arguments
     */
public static SecretKey keygenKeyGeneration(int keySize) {

    SecretKey sKey = null;

    if ((keySize == 128)||(keySize == 192)||(keySize == 256)) {

        try {

            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            kgen.init(keySize);

            sKey = kgen.generateKey();


        } catch (NoSuchAlgorithmException ex) {

            System.err.println("Generador no disponible.");

        }

    }

    return sKey;

}


public static byte[] encryptData(SecretKey sKey, byte[] data) {

    byte[] encryptedData = null;

    try {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, sKey);

        encryptedData =  cipher.doFinal(data);

    } catch (Exception  ex) {

        System.err.println("Error xifrant les dades: " + ex);

    }

    return encryptedData;

}
   
public static byte[] dencryptData(SecretKey sKey, byte[] data) {

    byte[] dencryptedData = null;

    try {

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.DECRYPT_MODE, sKey);

        dencryptedData =  cipher.doFinal(data);

    } catch (Exception  ex) {

        System.err.println("Error xifrant les dades: " + ex);

    }

    return dencryptedData;

}


    public static SecretKey passwordKeyGeneration(String text, int keySize){
    SecretKey sKey = null;
    if(keySize == 128){
    try{
        byte[] data = text.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(data);
        byte[] key = Arrays.copyOf(hash, keySize/8);
        sKey = new SecretKeySpec(key, "AES");
    } catch (Exception ex){
    System.err.println("Error generant la clau:"+ex);
    }
    }
return sKey;    
     }
        public static byte[] CrearBuffer(File f) throws FileNotFoundException, IOException{
     
      FileInputStream fis = new FileInputStream(f);
      byte[] buffer = new byte[(int) f.length()];
      fis.read(buffer);
      return buffer;
    }
   
   
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
      
         File input = new File("/home/tarda/Documents/hola.txt");
        byte[] dades = CrearBuffer(input);
        byte[] dadesXifrades;
        byte[] dadesDesxifrades = null;
        
        SecretKey keygenKeyGeneration = keygenKeyGeneration(128);
        
        dadesXifrades = encryptData(keygenKeyGeneration, dades);
        dadesDesxifrades = dencryptData(keygenKeyGeneration, dadesXifrades);
        
        String missatgeDesxifrat = new String(dadesDesxifrades);
        String missatgeXifrat = new String(dadesXifrades);
        
        System.out.println("---------- missatgeDesxifrat ----------------------------------");
        System.out.println(missatgeDesxifrat);
        System.out.println("---------- missatgeXifrat -------------------------------------");
        System.out.println(missatgeXifrat);
    
        
       
    
       
    }

  
   
}