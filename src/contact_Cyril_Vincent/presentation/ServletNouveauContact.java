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
 * Servlet implementation class ServletNouveauContact
 * Cette servlet est appelée lorsque l'on clique sur le bouton "valider" de la page "nouveaucontact.html".
 * Elle permet de créer un nouveau contact en base. 
 * 
 * @author Cyril Mailhé et Vincent Bourgueil 
 */
@WebServlet("/ServletNouveauContact")
public class ServletNouveauContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * L'attribut serv permet d'utiliser les méthodes de la classe "PersonneService" dans la servlet.
	 * L'utilisation de l'annotation "EJB" délègue la gestion de ce attribut au serveur et rend toute instanciation inutile.
	 */   
	@EJB private PersonneService serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletNouveauContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Cette méthode créé un nouveau contact en utilisant les champs renseignés dans le formulaire
	 * puis redirige vers la page d'accueil
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupération des paramètres du formulaire pour créer le nouveau contact
		String nom=request.getParameter("Nom");
		String prenom=request.getParameter("Prenom");
		String civilite=request.getParameter("Civilite");
		String rue=request.getParameter("Rue");
		String cp=request.getParameter("CP");
		String ville=request.getParameter("Ville");
		String pays=request.getParameter("Pays");
		
		//Instanciation de l'adresse et de la personne
		Adresse a=new Adresse(rue, cp, ville, pays);
		Personne p=new Personne(civilite, nom, prenom, a);
		
		//Ajout de la personne en base et redirection vers la page d'accueil
		serv.ajoutPersonne(p);
		System.out.println(p);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ServletListeClient");
		dispatcher.forward(request, response);
		
	}

}
