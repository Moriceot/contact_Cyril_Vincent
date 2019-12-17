package contact_Cyril_Vincent.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import contact_Cyril_Vincent.entites.Personne;
import contact_Cyril_Vincent.services.PersonneService;
/**
 *Cette classe fournit toutes les méthodes du web service REST de l'application.
 *@author Cyril Mailhé & Vicent Bourgueil
 */
@Path("/contact")
public class PersonneREST {
	/**
	 * L'attribut serv permet d'utiliser les méthodes de la classe "PersonneService" dans la servlet.
	 * L'utilisation de l'annotation "EJB" délègue la gestion de ce attribut au serveur et rend toute instanciation inutile.
	 */  
	@EJB PersonneService serv;
	
	/**
	 * Méthode affichant la liste des contacts 
	 * @return List<Personne> afficherContacts
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tous")
	public List<Personne> affichageContacts(){
		return serv.afficherContacts();
	}
	/**
	 * Méthode sauvegarde une personne passée en paramètre en base
	 * @param p
	 */
	@POST
	@Path("/newcontact/{p}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Personne p) {
		serv.ajoutPersonne(p);
	}
	
	/**
	 * Méthode de recherche d'une personne via un id passé en paramètre.
	 * @param id
	 * @return Personne
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/byid/{id}")
	public Personne getPersonneById(@PathParam("id")long id) {
		return serv.getPersonneById(id);
	}
	
}
