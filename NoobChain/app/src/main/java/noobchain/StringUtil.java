package noobchain;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {
    
    /* 
     * All we need to know is that it takes a string and applies SHA256 algorithm to it, 
     * and returns the generated signature as a string.
     */

    public static String applySha256(String input){		
        
        try {
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);

                if (hex.length() == 1)
                    hexString.append('0');

                hexString.append(hex);            
            }
            return hexString.toString();
        } 
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
           
            throw new RuntimeException(e);
        }
    }
}
