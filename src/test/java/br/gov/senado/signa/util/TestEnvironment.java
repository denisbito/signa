package br.gov.senado.signa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Constantes e métodos do ambiente de teste.
 * 
 * @author Denis Oliveira
 */
public class TestEnvironment {

	public static String KEYSTORE_FILENAME = "/signa-cacert-certificates.p12";
	public static String KEYSTORE_PASSWD = "signa-pa55wd";

	/**
	 * Cria a keystore Java de teste, a partir do arquivo
	 * "resources/signa-cacert-certificates.p12".
	 * 
	 * Uma keystore em Java é um local onde se guarda certificados e chaves
	 * critpográficas, e normalmente é salvo em um arquivo em disco.
	 * 
	 * @return a keyStore carregada com os certificados constantes do arquivo.
	 */
	public static KeyStore createTestJavaKeyStore() throws KeyStoreException,
			IOException, NoSuchAlgorithmException, CertificateException,
			FileNotFoundException, URISyntaxException {
		// criar uma nova keystore Java
		KeyStore keyStore = KeyStore.getInstance("PKCS12");

		// carregar a keystore a partir do arquivo
		File file = new File(TestEnvironment.class.getResource(
				KEYSTORE_FILENAME).toURI());
		keyStore.load(new FileInputStream(file), KEYSTORE_PASSWD.toCharArray());

		return keyStore;
	}

}
