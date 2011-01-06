package br.gov.senado.signa;

import org.junit.Assert;
import org.junit.Test;

public class SignatureTest {

	@Test
	public void testarCriarAssinaturaEDefinirSeuTipo() {
		Signature assinatura = new Signature();
		assinatura.setTipo(TipoAssinatura.PKC7S);
		Assert.assertEquals(TipoAssinatura.PKC7S, assinatura.getTipo());
	}

}
