package contact_Cyril_Vincent.presentation;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact_Cyril_Vincent.entites.Personne;
import contact_Cyril_Vincent.services.PersonneService;

/**
 * Servlet implementation class ServletModifPersonne
 * Cette servlet est appelée lorsque l'on clique sur le bouton "modifier" d'une ligne. 
 * Elle permet d'afficher la page de modification d'un contact en pré remplissant tous les champs.
 * "listecontact.jsp" en affichant la liste de tous les contacts. 
 * 
 * @author Cyril Mailhé et Vincent Bourgueil
 */
@WebServlet("/ServletModifPersonne")
public class ServletModifPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * L'attribut serv permet d'utiliser les méthodes de la classe "PersonneService" dans la servlet.
	 * L'utilisation de l'annotation "EJB" délègue la gestion de ce attribut au serveur et rend toute instanciation inutile.
	 */   
	@EJB private PersonneService serv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifPersonne() {
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
	 * Cette méthode retourne la page de modification d'un contact et met insère le contact à modifier en attribut de la requête http
	 * afin de permettre à la page "modifierContact.jsp" de préremplir les champs
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération de la personne sélectionnée
		long id=Integer.parseInt(request.getParameter("id"));
		Personne prs=serv.getPersonneById(id);
		
		//Mise en attribut de la personne sélectionnée
		request.setAttribute("personne", prs);
		RequestDispatcher dispatcher=request.getRequestDispatcher("modifierContact.jsp");
		dispatcher.forward(request, response);
	}

}
