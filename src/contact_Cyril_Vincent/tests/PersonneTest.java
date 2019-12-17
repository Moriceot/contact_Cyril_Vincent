package contact_Cyril_Vincent.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact_Cyril_Vincent.entites.Adresse;
import contact_Cyril_Vincent.entites.Personne;

class PersonneTest {

	@Test
	void testConstructeur() {
		Personne p=new Personne();
		assertNotNull(p);
	}
	
	void testSetCivilite() {
		Personne p=new Personne();
		p.setCivilite("Mme");
		assertEquals("Mme",p.getCivilite());
	}
	
	void testSetNom() {
		Personne p=new Personne();
		p.setNom("un nom");
		assertEquals("un nom",p.getNom());
	}
	
	void testSePrenom() {
		Personne p=new Personne();
		p.setPrenom("un prenom");
		assertEquals("un prenom",p.getPrenom());
	}
	void testGetCivilite() {
		Adresse a= new Adresse("une rue","12000","une ville d'Aveyron","un pays");
		Personne p= new Personne("M", "Lagaffe", "Gaston", a);
		assertEquals("M",p.getCivilite());
	}
	
	void testGetNom() {
		Adresse a= new Adresse("une rue","12000","une ville d'Aveyron","un pays");
		Personne p= new Personne("M", "Lagaffe", "Gaston", a);
		assertEquals("Lagaffe",p.getCivilite());
	}
	
	void testGetPrenom() {
		Adresse a= new Adresse("une rue","12000","une ville d'Aveyron","un pays");
		Personne p= new Personne("M", "Lagaffe", "Gaston", a);
		assertEquals("Gaston",p.getPrenom());
	}
}
