package br.gov.senado.signa;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyStore;

import org.junit.Assert;
import org.junit.Test;

import br.gov.senado.signa.util.TestEnvironment;

public class CertManagerTest {

	@Test
	public void testKeystoreFileExists() throws URISyntaxException {
		URL url = this.getClass()
				.getResource(TestEnvironment.KEYSTORE_FILENAME);
		Assert.assertNotNull(url);

		File file = new File(url.toURI());
		Assert.assertTrue(file.exists());
	}

	@Test
	public void testGetUserCertificates() throws Exception {
		System.out.println();
		KeyStore keyStore = TestEnvironment.createTestJavaKeyStore();
		Assert.assertNotNull(keyStore);
	}

}
