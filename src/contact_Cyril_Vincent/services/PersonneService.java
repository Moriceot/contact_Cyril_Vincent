package contact_Cyril_Vincent.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import contact_Cyril_Vincent.entites.Personne;
import contact_Cyril_Vincent.persistence.PersonneDAO;

@Singleton
public class PersonneService {
	@EJB private PersonneDAO dao;
	
	public void ajoutPersonne(Personne p) {
		dao.save(p);
	}
	
	public List<Personne> afficherContacts(){
		return dao.getAllPersonne();
	}
}
