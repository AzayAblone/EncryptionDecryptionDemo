package com.example.pdfreader;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encryption {
	
	KeyGenerator keyGen;
	String stringKey;
	SecretKey secretKey;
    
    byte [] encryptedBytes,decryptedBytes;
    Cipher cipher,cipher1;
    String encrypted,decrypted;

    public String RSAEncrypt (final String plain) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException 
    {
        keyGen = KeyGenerator.getInstance("RSA");
        keyGen.init(128);
        secretKey = keyGen.generateKey();

        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        encryptedBytes = cipher.doFinal(plain.getBytes());
        encrypted = new String(encryptedBytes);
        System.out.println("EEncrypted?????"+encrypted);
        stringKey=secretKey.toString();
        System.out.println( "Private key: " +stringKey);
        return encrypted;

    }

    public String RSADecrypt (final String result,String keyIn) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException 
    {
    	if (keyIn.equalsIgnoreCase(secretKey.toString())) {
    		cipher1=Cipher.getInstance("RSA");
    		cipher1.init(Cipher.DECRYPT_MODE, secretKey);
    		decryptedBytes = cipher1.doFinal(result.getBytes());
    		decrypted = new String(decryptedBytes);
    		System.out.println("DDecrypted?????"+decrypted);
    		return decrypted;
		}else{
			return null;
		}
    }

}
