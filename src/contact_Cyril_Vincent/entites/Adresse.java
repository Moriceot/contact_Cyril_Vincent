package contact_Cyril_Vincent.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 *Classe entité contenant tous les attributs correspondants à une adresse
 *@author Cyril Mailhé et Vincent Bourgueil 
 */
@Entity
@Table(name = "adresses")
@Access(AccessType.FIELD)

public class Adresse implements Serializable{
	//Attributs********************************************
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk;
	private String rue;
	@Column(name = "code_postal")
	private String cp;
	private String ville;
	private String pays;
	

	
	
	//Constructeurs*****************************************************
	public Adresse(String rue, String cp, String ville, String pays) {
		super();
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
	}
	public Adresse() {
		super();
		this.rue = "rue";
		this.cp = "cp";
		this.ville ="ville";
		this.pays = "pays";
	}
	
	
	//Getters & Setters*********************************
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}
	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}
	/**
	 * @return the id
	 */
	public long getPk() {
		return pk;
	}
	/**
	 * @param id the id to set
	 */
	public void setPk(long pk) {
		this.pk = pk;
	}
	

}
