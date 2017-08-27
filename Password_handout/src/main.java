
import java.util.Random;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;

public class main {
	
	
	public static void main(String[] args) {
		
				

		String encStr = "tq90zduRNrwQQxltCEIph3FDVF2TCKNkvGR59MhG+XY="; // This needs to be generated based on the password from Ciso
		String sourceHost = "lonindbengvm37."; // We should get the host name from the header if possible
		
		try {
			String passWord = encStr(encStr, sourceHost);
			System.out.println("Password is : " + passWord);
		} catch (EncryptionOperationNotPossibleException e) {
			String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
			String fakePassword = randomString(chars, 14);
			System.out.println("Password is : " + fakePassword);
		}
		
	
		
		
	}
	
	private static String randomString(String chars, int length) {
		  
		  Random rand = new Random();
		  
		  StringBuilder buf = new StringBuilder();
		  for (int i=0; i<length; i++) {
		    buf.append(chars.charAt(rand.nextInt(chars.length())));
		  }
		  return buf.toString();
		}
	
		private static String encStr(String encrypted, String hostName) {
			String seed = hostName;
			StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
			encryptor.setPassword(seed);
			String decrypted  = encryptor.decrypt(encrypted);
			
			return decrypted;
			
			
			
		}

}
