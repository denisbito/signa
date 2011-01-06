package br.gov.senado.signa;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import java.security.Security;

import org.junit.Assert;
import org.junit.Test;

public class CertManagerTest {

	@Test
	public void testCreateUserCertificateAndStoreInJavaKeystore() {
		Assert.assertEquals(1, 2);
	}

	@Test
	public void testGetUserCertificates() throws KeyStoreException {
		KeyStore keyStore = KeyStore.getInstance("jks");
		Assert.assertNotNull(keyStore);

		System.out.println(keyStore.aliases());
	}

	@Test
	public void lhufas() {
		Provider[] providers = Security.getProviders();
		for (Provider provider : providers) {
			System.out.println(provider);
		}
	}

}
