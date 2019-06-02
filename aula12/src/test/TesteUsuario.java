package test;

import org.junit.Assert;
import org.junit.Test;

import model.Usuario;

public class TesteUsuario {
	@Test
	public void aesPasswordTest() {
		Usuario u = new Usuario();
		u.setPassword("1234");
		Assert.assertEquals("[B@523884b2", u.getPasswordCripto());
	}
	
}
