package contact_Cyril_Vincent.presentation;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact_Cyril_Vincent.entites.Adresse;
import contact_Cyril_Vincent.entites.Personne;
import contact_Cyril_Vincent.services.PersonneService;

/**
 * Servlet implementation class ServletConfirmationModif
 * Servlet appelée une fois que le formulaire de modification du contact a été rempli et validé.
 * Elle appelle les méthodes DAO qui vont modifier le contact en base.
 * 
 * @author Cyril Mailhé et Vincent Bourgueil 
 */

@WebServlet("/ServletConfirmationModif")
public class ServletConfirmationModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * L'attribut serv sert à appeler les méthodes de la couche service et notamment la méthode de modification du contact
     * Il est géré par le serveur,grâce à l'annotation "EJB" ce qui rend toute instanciation inutile
     */
	@EJB PersonneService serv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfirmationModif() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Méthode appelée pour modifier un contact elle récupère l'identifiant renseigné dans le formulaire et les champs modifiés
	 * puis lance la méthode "modifierPersonne() de la classe "PersonneService"
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération des informations modifiées
		
		long id=Integer.parseInt(request.getParameter("id"));
		String civilite=request.getParameter("Civilite");
		String nom=request.getParameter("Nom");
		String prenom=request.getParameter("Prenom");
		String rue=request.getParameter("Rue");
		String ville=request.getParameter("Ville");
		String cp=request.getParameter("CP");
		String pays=request.getParameter("Pays");
		
		
		//modification des paramètres de la personne correspondant à l'id récupéré
		
		Personne p=serv.getPersonneById(id);
		Adresse a=p.getAdresse();
		if(a == null) {a=new Adresse();}
		a.setCp(cp);
		a.setPays(pays);
		a.setRue(rue);
		a.setVille(ville);
		p.setCivilite(civilite);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAdresse(a);
		
		//Modification de la personne
		serv.modifierPersonne(p,a);
		
		//Renvoi vers la page d'accueil
		RequestDispatcher dispatcher = request.getRequestDispatcher("ServletListeClient");
		dispatcher.forward(request, response);
	}

}
