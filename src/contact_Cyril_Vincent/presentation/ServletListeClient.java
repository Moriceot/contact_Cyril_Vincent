package contact_Cyril_Vincent.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ServletListeClient
 * Cette servlet est appel�e en page d'accueil de l'application. Elle permet d'afficher la page
 * "listecontact.jsp" en affichant la liste de tous les contacts. 
 * 
 * @author Cyril Mailh� et Vincent Bourgueil
 */
@WebServlet("/ServletListeClient")
public class ServletListeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * L'attribut serv permet d'utiliser les m�thodes de la classe "PersonneService" dans la servlet.
	 * L'utilisation de l'annotation "EJB" d�l�gue la gestion de ce attribut au serveur et rend toute instanciation inutile.
	 */
	@EJB private PersonneService serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * La servlet �tant appel�e en page d'accueil de l'application par une m�thode HTTP Get.
	 * Cette m�thode renvoi directement vers la m�thode HTTP doPost pour �tre trait�e.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Cette m�thode affiche la liste de tous les contacts en appelant la m�thode "afficherContact()"  de la classe "PersonneService"
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//R�cup�ration de la liste des contacts
		List<Personne> listeContact=new ArrayList<Personne>();
		listeContact=serv.afficherContacts();
		
		//Redirection vers la page d'accueil
		RequestDispatcher dispatcher=request.getRequestDispatcher("listecontact.jsp");
		request.setAttribute("liste", listeContact);
	
		dispatcher.forward(request, response);
	}

}
