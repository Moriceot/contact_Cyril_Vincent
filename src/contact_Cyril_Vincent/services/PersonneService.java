package contact_Cyril_Vincent.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import contact_Cyril_Vincent.entites.Adresse;
import contact_Cyril_Vincent.entites.Personne;
import contact_Cyril_Vincent.persistence.PersonneDAO;
/**
 * Cette classe impl�mente toutes les m�thodes de traitement de donn�es de l'application.
 * Elle r�alise les op�rations souhait�es puis appelle la couche DAO pour retranscrire ces op�rations en base.
 * 
 * @author Cyril Mailh� & Vincent Bourgueil
 */
@Singleton
public class PersonneService {
	 /**
     * L'attribut dao sert � appeler les m�thodes de la couche DAO (classe ServiceDAO)
     * Il est g�r� par le serveur,gr�ce � l'annotation "EJB" ce qui rend toute instanciation inutile
     */
	@EJB private PersonneDAO dao;
	
	/**
	 * M�thode d'ajout d'une personne dans l'application. Elle appelle la couche DAO pour retranscrire ses modifications en base.
	 * @param p
	 */
	public void ajoutPersonne(Personne p) {
		dao.save(p);
	}
	
	/**
	 * M�thode d'affichage de tous les contact dans l'application. Elle appelle la couche DAO pour appeler la requ�te n�cessaire.
	 * @return List<Personne> afficherContacts
	 */
	public List<Personne> afficherContacts(){
		return dao.getAllPersonne();
	}
	
	/**
	 * M�thode de recherche d'un contact dans l'application. Elle appelle la couche DAO pour appeler la requ�te n�cessaire.
	 * @param id
	 * @return Personne
	 */
	public Personne getPersonneById(long id) {
		return dao.getPersonById(id);
	}
	
	/**
	 * M�thode de modification d'un contact. L'adresse et la personne sont pass�e en param�tre. 
	 * Etant donn� qu'elle sont stock�es dans des tables diff�rentes elles sont toutes les deux utilis�es dans la fonction (merge)
	 * @param p
	 * @param a
	 */
	public void modifierPersonne(Personne p,Adresse a) {
		dao.modifyPersonne(p,a);
	}
	
	/**
	 *  M�thode de supression d'une personne pass�e en param�tre. Elle appelle la couche DAO pour r�percuter l'action dans la BDD.
	 * @param p
	 */
	public void supprimerPersonne(long id) {
		dao.deletePersonne(id);
	}
}
