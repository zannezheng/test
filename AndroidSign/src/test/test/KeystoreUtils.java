package test.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class KeystoreUtils {

	public static void main(String[] args) throws CertificateException, NoSuchProviderException, KeyStoreException, NoSuchAlgorithmException, IOException {
		//装载key文件
		FileInputStream fis  =  new FileInputStream("my.keystore");
		//jdk中默认的加密算法是JKS
		KeyStore keyStore = KeyStore.getInstance("JKS");
		//输入我们的storepass 123456
		keyStore.load(fis,"123456".toCharArray());
		//获取alias别名
		Enumeration<String> enumeration = keyStore.aliases();
		while (enumeration.hasMoreElements()) {
			String alias = enumeration.nextElement();
			System.out.println("别名:"+alias);
			X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
			System.out.println("证书类型,提供者:"+certificate.getType()+","+certificate.getSigAlgName());
			System.out.println("签发者:"+certificate.getIssuerDN());
			System.out.println("所有者:"+certificate.getSubjectDN());
			System.out.println("创建时间:"+certificate.getNotBefore());
			System.out.println("过期时间:"+certificate.getNotAfter());
			System.out.println("序列号:"+certificate.getSerialNumber().toString(16));
			System.out.println("签名算法:"+certificate.getSigAlgName());
			System.out.println("公钥信息:"+certificate.getPublicKey());
		}
	}
}