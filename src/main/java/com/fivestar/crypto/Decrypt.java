package com.fivestar.crypto;

//import java.io.UnsupportedEncodingException;
//import java.security.InvalidAlgorithmParameterException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

//import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
//static Logger Log = LogManager.getLogger(Decrypt.class.getName());

// Decrypt Method to be called in mule code
	private static final String key = "C686FBC86A3F4C92A6FD651E3A41BA3D";
	private static final String initVector = "1231233213214566";
	
	
	public static String decrypt(String encrypted) {
	Random rand = new SecureRandom();
	byte[] bytes = new byte[16];
	rand.nextBytes(bytes);
	//IvParameterSpec ivSpec = new IvParameterSpec(bytes);
	//String secretKey = "C686FBC86A3F4C92A6FD651E3A41BA3D";
	 //String ivGen ="1231233213214566";
	
	    try {
	        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	 
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	        //byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
	        String original = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
	 
	        return new String(original);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	 
	    return null;
	}
}