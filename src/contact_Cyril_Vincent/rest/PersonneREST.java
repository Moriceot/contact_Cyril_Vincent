package contact_Cyril_Vincent.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import contact_Cyril_Vincent.entites.Personne;
import contact_Cyril_Vincent.services.PersonneService;

@Path("/contact")
public class PersonneREST {
	@EJB PersonneService serv;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tous")
	public List<Personne> AffichageContacts(){
		return serv.afficherContacts();
	}
	
	@POST
	@Path("/newcontact/{p}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Personne p) {
		serv.ajoutPersonne(p);
	}
}
