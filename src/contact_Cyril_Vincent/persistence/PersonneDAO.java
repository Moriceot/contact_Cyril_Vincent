package contact_Cyril_Vincent.persistence;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import contact_Cyril_Vincent.entites.Adresse;
import contact_Cyril_Vincent.entites.Personne;

/**
 *Classe DAO permettant la liaison entre l'application et la base de donnée.
 *C'est elle qui réalise toutes les opérations du CRUD:
 *	-Créer un contact
 *	-Modifier un contact
 *	-Rechercher un contact via son id
 *	-Afficher tous les contact
 *	-Supprimer un contact (si implémenté)
 *
 *@author Cyril Mailhé et Vincent Bourgueil 
 */

@Singleton
public class PersonneDAO {
	/**
	 * L'entity manager est l'attribut responsable de la connexion avec la base de donnée
	 * L'annotation "PersistenceContext" permet au serveur de gérer l'EM rend non nécessaire son instanciation
	 */
	@PersistenceContext(name = "contact_Cyril_Vincent") private EntityManager em;
	
	
	/**
	 * La méthode save permet de sauvegarder une entité personne @param p passée en paramètre.
	 */
	public void save(Personne p) {
		em.persist(p);
	}
	
	/**
	 * La méthode getAllPersonne permet de récupérer la liste  de toutes les personne dans la BDD
	 * @return List<Personne> 
	 */
	public List<Personne> getAllPersonne() {
		return em.createNamedQuery("Personne.all",Personne.class).getResultList();
	}
	
	/**
	 * La méthode getPersonneById renvoi une entité personne identifiée par le paramètre @param id
	 * @return Personne
	 */
	public Personne getPersonById(long id) {
		return em.find(Personne.class, id);
	}
	
	/**
	 * La méthode modifyPersonne modifie les valeurs des attributs d'une personne passée en paramètre @param p
	 */
	public void modifyPersonne(Personne p,Adresse a) {
		em.merge(a);
		em.merge(p);
	}
	
	/**
	 *La méthode deletePersonne supprime de la base de données une personne passée en paramètre 
	 * @param p
	 */
	public void deletePersonne(long id) {
		Personne p=em.find(Personne.class, id);
		em.remove(p);
	}

}
