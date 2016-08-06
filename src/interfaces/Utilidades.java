/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author DIEGO
 */
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
 
public class Utilidades {
 
    public  String Encriptar(String texto) {
 
        String palabraClave = "diego"; //llave para encriptar datos
        String base64EncryptedString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(palabraClave.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
 
    public  String Desencriptar(String textoEncriptado) throws Exception {
        String secretKey = "diego"; //llave para encriptar datos
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
//    public static void main(String [] arg ) throws Exception{
//       Utilidades a=new Utilidades();
//       String encr, desencr;
//       encr=a.Encriptar("diego");
//       desencr=a.Desencriptar(encr);
//        System.out.println("encriptar diego: "+encr);
//        System.out.println("encriptar diego: "+desencr);
//    }
}
/**
 * UTF-8 (8-bit Unicode Transformation Format) es 
 * un formato de codificación de caracteres Unicode e ISO 10646 utilizando símbolos de longitud 
 * variable. UTF-8 fue creado por Robert C. Pike y Kenneth L. Thompson. Está definido como estándar por 
 * la RFC 3629 de la Internet Engineering Task Force (IETF).1 Actualmente es una de las tres posibilidades 
 * de codificación reconocidas por Unicode y lenguajes web, o cuatro en ISO 10646.
 */