package contact_Cyril_Vincent.persistence;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import contact_Cyril_Vincent.entites.Adresse;
import contact_Cyril_Vincent.entites.Personne;

/**
 *Classe DAO permettant la liaison entre l'application et la base de donn�e.
 *C'est elle qui r�alise toutes les op�rations du CRUD:
 *	-Cr�er un contact
 *	-Modifier un contact
 *	-Rechercher un contact via son id
 *	-Afficher tous les contact
 *	-Supprimer un contact (si impl�ment�)
 *
 *@author Cyril Mailh� et Vincent Bourgueil 
 */

@Singleton
public class PersonneDAO {
	/**
	 * L'entity manager est l'attribut responsable de la connexion avec la base de donn�e
	 * L'annotation "PersistenceContext" permet au serveur de g�rer l'EM rend non n�cessaire son instanciation
	 */
	@PersistenceContext(name = "contact_Cyril_Vincent") private EntityManager em;
	
	
	/**
	 * La m�thode save permet de sauvegarder une entit� personne @param p pass�e en param�tre.
	 */
	public void save(Personne p) {
		em.persist(p);
	}
	
	/**
	 * La m�thode getAllPersonne permet de r�cup�rer la liste  de toutes les personne dans la BDD
	 * @return List<Personne> 
	 */
	public List<Personne> getAllPersonne() {
		return em.createNamedQuery("Personne.all",Personne.class).getResultList();
	}
	
	/**
	 * La m�thode getPersonneById renvoi une entit� personne identifi�e par le param�tre @param id
	 * @return Personne
	 */
	public Personne getPersonById(long id) {
		return em.find(Personne.class, id);
	}
	
	/**
	 * La m�thode modifyPersonne modifie les valeurs des attributs d'une personne pass�e en param�tre @param p
	 */
	public void modifyPersonne(Personne p,Adresse a) {
		em.merge(a);
		em.merge(p);
	}
	
	/**
	 *La m�thode deletePersonne supprime de la base de donn�es une personne pass�e en param�tre 
	 * @param p
	 */
	public void deletePersonne(long id) {
		Personne p=em.find(Personne.class, id);
		em.remove(p);
	}

}
