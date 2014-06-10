package test.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import sun.security.pkcs.PKCS7;

public class ReadRSAFile {

	 public static X509Certificate readSignatureBlock(InputStream in) throws IOException, GeneralSecurityException {  
	        PKCS7 pkcs7 = new PKCS7(in);  
	        return pkcs7.getCertificates()[0];  
	    }  
	
	public static void main(String[] args) throws FileNotFoundException, IOException, GeneralSecurityException {
		X509Certificate cert = readSignatureBlock(new FileInputStream(
				"RDT_ALIA.RSA"));
		System.out.println("发布人:" + cert.getIssuerDN());
		System.out.println("拥有人:" + cert.getSubjectDN());
		System.out.println(cert.getPublicKey());
	}
}
