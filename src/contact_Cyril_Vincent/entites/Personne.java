package contact_Cyril_Vincent.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe entité contenant tous les attributs correspondants à une personne
 * @author Cyril Mailhé et Vincent Bourgueil
 */

@Entity
@Table(name = "personnes")
@Access(AccessType.FIELD)
@NamedQuery(name = "Personne.all",
			query = "SELECT p FROM Personne p")
public class Personne implements Serializable {
	
	//Atributs****************************************************************
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk;
	private String civilite;
	private String nom;
	private String prenom;
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER) 
	@JoinTable(name = "contacts_adresses",
	joinColumns = @JoinColumn(name="fk_adresse"),
	inverseJoinColumns = @JoinColumn(name="fk_personne"))
	private Adresse adresse;
	
	
	//Constructeurs********************************************************
	public Personne(String civilite, String nom, String prenom, Adresse a) {
		super();
		
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse=a;
	}
	public Personne() {
		super();
	}
	
	//Getters & Setters**********************************************************
	/**
	 * @return the id
	 */
	public long getId() {
		return pk;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long pk) {
		this.pk = pk;
	}
	/**
	 * @return the civilite
	 */
	public String getCivilite() {
		return civilite;
	}
	/**
	 * @param civilite the civilite to set
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the pk
	 */
	public long getPk() {
		return pk;
	}
	/**
	 * @param pk the pk to set
	 */
	public void setPk(long pk) {
		this.pk = pk;
	}

	
}
