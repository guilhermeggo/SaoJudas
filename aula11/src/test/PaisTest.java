package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import teste.Pais;

public class PaisTest {

	@Test
	public void testComMaisHabitantes() {
		Pais p = new Pais();
		p = p.comMaisHabitantes();
		assertEquals("pais com mais habitantes", "Brasil", p.getNome());
	}

}
