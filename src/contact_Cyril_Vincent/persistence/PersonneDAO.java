package contact_Cyril_Vincent.persistence;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import contact_Cyril_Vincent.entites.Personne;

@Singleton
public class PersonneDAO {

	@PersistenceContext(name = "contact_Cyril_Vincent") private EntityManager em;
	
	public void save(Personne p) {
		em.persist(p);
	}
	
	public List<Personne> getAllPersonne() {
		return em.createNamedQuery("Personne.all",Personne.class).getResultList();
	}
	
	

}
