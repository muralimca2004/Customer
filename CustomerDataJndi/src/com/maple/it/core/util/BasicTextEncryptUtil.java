/**
 * This class is used for decrypting the Password
 * 
 * File Name: EncryptUtil.java
 * 
 * Description: Encryption utility
 * 
 * @author Murali M
 * 
 */
package com.maple.it.core.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.jasypt.util.text.BasicTextEncryptor;

public class BasicTextEncryptUtil {
	
	private static final Log logger = LogFactory.getLog(BasicTextEncryptUtil.class);
	
	private final static BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
	public static final String ENCRYPT_DECRYPT_KEY="HODBS12345678910";
	
	/**
	 *  Default constructor
	 */
	public BasicTextEncryptUtil() {
		
	}
	
	static{
		basicTextEncryptor.setPassword(ENCRYPT_DECRYPT_KEY);
		
	}
	
	
	/**
	 * This method is used for password decryption
	 * 
	 * @param encryptedPasswd
	 * @return
	 */
	public String getDecryptedValue( String encryptedPasswd ){
		return basicTextEncryptor.decrypt(encryptedPasswd);
			
	}
	
	public String getEncryptedValue( String passwd ){
		logger.info(passwd);
		return basicTextEncryptor.encrypt(passwd);
		
			
	}
	
}
