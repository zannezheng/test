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
		//װ��key�ļ�
		FileInputStream fis  =  new FileInputStream("my.keystore");
		//jdk��Ĭ�ϵļ����㷨��JKS
		KeyStore keyStore = KeyStore.getInstance("JKS");
		//�������ǵ�storepass 123456
		keyStore.load(fis,"123456".toCharArray());
		//��ȡalias����
		Enumeration<String> enumeration = keyStore.aliases();
		while (enumeration.hasMoreElements()) {
			String alias = enumeration.nextElement();
			System.out.println("����:"+alias);
			X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
			System.out.println("֤������,�ṩ��:"+certificate.getType()+","+certificate.getSigAlgName());
			System.out.println("ǩ����:"+certificate.getIssuerDN());
			System.out.println("������:"+certificate.getSubjectDN());
			System.out.println("����ʱ��:"+certificate.getNotBefore());
			System.out.println("����ʱ��:"+certificate.getNotAfter());
			System.out.println("���к�:"+certificate.getSerialNumber().toString(16));
			System.out.println("ǩ���㷨:"+certificate.getSigAlgName());
			System.out.println("��Կ��Ϣ:"+certificate.getPublicKey());
		}
	}
}