package contact_Cyril_Vincent.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import contact_Cyril_Vincent.entites.Adresse;
import contact_Cyril_Vincent.entites.Personne;
import contact_Cyril_Vincent.persistence.PersonneDAO;
/**
 * Cette classe implémente toutes les méthodes de traitement de données de l'application.
 * Elle réalise les opérations souhaitées puis appelle la couche DAO pour retranscrire ces opérations en base.
 * 
 * @author Cyril Mailhé & Vincent Bourgueil
 */
@Singleton
public class PersonneService {
	 /**
     * L'attribut dao sert à appeler les méthodes de la couche DAO (classe ServiceDAO)
     * Il est géré par le serveur,grâce à l'annotation "EJB" ce qui rend toute instanciation inutile
     */
	@EJB private PersonneDAO dao;
	
	/**
	 * Méthode d'ajout d'une personne dans l'application. Elle appelle la couche DAO pour retranscrire ses modifications en base.
	 * @param p
	 */
	public void ajoutPersonne(Personne p) {
		dao.save(p);
	}
	
	/**
	 * Méthode d'affichage de tous les contact dans l'application. Elle appelle la couche DAO pour appeler la requête nécessaire.
	 * @return List<Personne> afficherContacts
	 */
	public List<Personne> afficherContacts(){
		return dao.getAllPersonne();
	}
	
	/**
	 * Méthode de recherche d'un contact dans l'application. Elle appelle la couche DAO pour appeler la requête nécessaire.
	 * @param id
	 * @return Personne
	 */
	public Personne getPersonneById(long id) {
		return dao.getPersonById(id);
	}
	
	/**
	 * Méthode de modification d'un contact. L'adresse et la personne sont passée en paramètre. 
	 * Etant donné qu'elle sont stockées dans des tables différentes elles sont toutes les deux utilisées dans la fonction (merge)
	 * @param p
	 * @param a
	 */
	public void modifierPersonne(Personne p,Adresse a) {
		dao.modifyPersonne(p,a);
	}
	
	/**
	 *  Méthode de supression d'une personne passée en paramètre. Elle appelle la couche DAO pour répercuter l'action dans la BDD.
	 * @param p
	 */
	public void supprimerPersonne(long id) {
		dao.deletePersonne(id);
	}
}
