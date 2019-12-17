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
 * Servlet appel�e une fois que le formulaire de modification du contact a �t� rempli et valid�.
 * Elle appelle les m�thodes DAO qui vont modifier le contact en base.
 * 
 * @author Cyril Mailh� et Vincent Bourgueil 
 */

@WebServlet("/ServletConfirmationModif")
public class ServletConfirmationModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * L'attribut serv sert � appeler les m�thodes de la couche service et notamment la m�thode de modification du contact
     * Il est g�r� par le serveur,gr�ce � l'annotation "EJB" ce qui rend toute instanciation inutile
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
	 * M�thode appel�e pour modifier un contact elle r�cup�re l'identifiant renseign� dans le formulaire et les champs modifi�s
	 * puis lance la m�thode "modifierPersonne() de la classe "PersonneService"
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//R�cup�ration des informations modifi�es
		
		long id=Integer.parseInt(request.getParameter("id"));
		String civilite=request.getParameter("Civilite");
		String nom=request.getParameter("Nom");
		String prenom=request.getParameter("Prenom");
		String rue=request.getParameter("Rue");
		String ville=request.getParameter("Ville");
		String cp=request.getParameter("CP");
		String pays=request.getParameter("Pays");
		
		
		//modification des param�tres de la personne correspondant � l'id r�cup�r�
		
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
