package br.gov.senado.signa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.gov.senado.signa.util.TestEnvironment;

public class CertManagerTest {

	/**
	 * Test environment set up.
	 * 
	 * Basically we just want to setup a keystore for the tests with
	 * certificates.
	 */
	@BeforeClass
	public static void setUp() throws KeyStoreException,
			NoSuchAlgorithmException, CertificateException, IOException {
		// create a new test Java KeyStore (file in user home directory)
		KeyStore keyStore = KeyStore.getInstance("jks");

		// before anything else, keystores MUST be loaded. When creating a new
		// keystore, load it with null arguments!
		keyStore.load(null, null);

		File userDir = FileUtils.getUserDirectory();
		FileOutputStream out = new FileOutputStream(new File(userDir,
				TestEnvironment.KEYSTORE_FILENAME));
		keyStore.store(out, TestEnvironment.KEYSTORE_PASSWD.toCharArray());

		Assert.assertTrue(new File(userDir, TestEnvironment.KEYSTORE_FILENAME)
				.exists());
	}

	@Test
	public void testCreateUserCertificateAndStoreInJavaKeystore() {
		Assert.assertEquals(1, 2);
	}

	@Test
	public void testGetUserCertificates() throws KeyStoreException {
		KeyStore keyStore = KeyStore.getInstance("jks");
		Assert.assertNotNull(keyStore);
	}

}
