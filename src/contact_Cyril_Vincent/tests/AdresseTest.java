package contact_Cyril_Vincent.tests;


import static org.junit.Assert.*;

import org.junit.Test;

import contact_Cyril_Vincent.entites.Adresse;

class AdresseTest {
	@Test
	void testConstructeur() {
		Adresse a= new Adresse();
		assertNotNull(a);
	}

	void testSetRue() {
		Adresse a= new Adresse();
		a.setRue("une rue");
		assertEquals("une rue",a.getRue());
	}
	
	void testSetVille() {
		Adresse a= new Adresse();
		a.setVille("une ville");
		assertEquals("une ville",a.getVille());
	}
	
	void testSetCP() {
		Adresse a= new Adresse();
		a.setCp("un CP");
		assertEquals("une CP",a.getCp());
	}
	
	void testSetPays() {
		Adresse a= new Adresse();
		a.setPays("un Pays");
		assertEquals("une Pays",a.getPays());
	}
	
	void testGetRue() {
		Adresse a= new Adresse("une rue","12000","une ville d'Aveyron","un pays");
		assertEquals("une rue",a.getRue());
	}
	
	void testGetVille() {
		Adresse a= new Adresse("une rue","12000","une ville d'Aveyron","un pays");
		assertEquals("une ville d'Aveyron",a.getVille());
	}
	
	void testGetCP() {
		Adresse a= new Adresse("une rue","12000","une ville d'Aveyron","un pays");
		assertEquals("12000",a.getCp());
	}
	
	void testGetPays() {
		Adresse a= new Adresse("une rue","12000","une ville d'Aveyron","un pays");
		assertEquals("12000",a.getPays());
	}
}
