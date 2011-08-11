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
 * Test environment constants and methods
 * 
 * @author Denis Oliveira - denisbito@gmail.com
 */
public class TestEnvironment {

	public static String KEYSTORE_FILENAME = "/signa-cacert-certificates.p12";
	public static String KEYSTORE_PASSWD = "signa-pa55wd";

	/**
	 * Creates a test Java Keystore, from the file
	 * "resources/signa-cacert-certificates.p12".
	 * 
	 * A Java Keystore is a place where certificates and cryptographic keys are
	 * stored, normally kept as a file on the filesystem.
	 * 
	 * @return the test KeyStore object, loaded with the certificates it
	 *         contains.
	 */
	public static KeyStore createTestJavaKeyStore() throws KeyStoreException,
			IOException, NoSuchAlgorithmException, CertificateException,
			FileNotFoundException, URISyntaxException {
		// create a new Java Keystore
		KeyStore keyStore = KeyStore.getInstance("PKCS12");

		// load the keystore from a local file
		File file = new File(TestEnvironment.class.getResource(
				KEYSTORE_FILENAME).toURI());
		keyStore.load(new FileInputStream(file), KEYSTORE_PASSWD.toCharArray());

		return keyStore;
	}

}
