package contact_Cyril_Vincent.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "personnes")
@Access(AccessType.FIELD)
@NamedQuery(name = "Personne.all",
			query = "SELECT p FROM Personne p")
//@NamedQuery(name = "Personne.all",
//			query = "SELECT p.pk, p.nom,p.prenom,p.civilite,a.rue, a.cp, a.ville, a.pays FROM Personne p, Adresse a WHERE p.pk=a.fk")
public class Personne implements Serializable {
	//Attributs********************************
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk;
	private String civilite;
	private String nom;
	private String prenom;
	@ManyToMany(cascade = CascadeType.PERSIST) 
	@JoinTable(name = "contacts_adresses",
	joinColumns = @JoinColumn(name="fk_personne"),
	inverseJoinColumns = @JoinColumn(name="fk_adresse"))
	private List<Adresse> adresse;
	
	//Constructeurs********************************************************
	public Personne(String civilite, String nom, String prenom) {
		super();
		
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
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
	
	

}
