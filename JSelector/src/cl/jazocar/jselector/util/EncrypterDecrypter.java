package cl.jazocar.jselector.util;
import java.security.InvalidKeyException;
import java.security.Key;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

import cl.jazocar.jselector.constants.IConstants;


public class EncrypterDecrypter {

    private static String algorithm = "DESede";
    private static Key key = getKey();
    private static Cipher cipher = getCipher();
       
    private static Key getKey(){
    	try {
    		String initKey = "b6801fc185687fda3bc4dcfd6e25514a017a380804a8832f";
    		return new SecretKeySpec(fromHex(initKey), algorithm);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
    
    private static Cipher getCipher(){
    	try {
			return Cipher.getInstance(algorithm);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}    	
    }


	public static String encrypt(String input) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        return toHex(cipher.doFinal(inputBytes));
    }

    public static String decrypt(String Encrypted) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes = cipher.doFinal(fromHex(Encrypted));
        String recovered = new String(recoveredBytes);
        return recovered;
    }
    
    private static String toHex(byte[] ba) {
    	StringBuffer sb = new StringBuffer("");
    	for (int i = 0; i < ba.length; i++) {
        	sb.append(Integer.toHexString((ba[i] >> 4) & 0x0F));
        	sb.append(Integer.toHexString(ba[i] & 0x0F));
    	}
    	return sb.toString();
    }
    
    private static byte[] fromHex(String s) {
    	int n = s.length() / 2;
    	byte[] res = new byte[n];
    	for(int i = 0; i < n; i++) {
    		res[i] = (byte)(Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16));
    	}
    	return res;
    }
    
    public static void main(String[] args) throws Exception {
        String input;
        if (args.length !=1) 
            input = "ci";
        else
        	input = args[0];
        String Encrypted = null;       
        Encrypted = encrypt(input);       
    }
}
