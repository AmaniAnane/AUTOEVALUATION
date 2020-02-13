package com.example.demo.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Personnels {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   
	
	private int id_personnel ;
	private String nom_personnel;
	private String prenom_personnel;
	private String email_personnel;
	private String login_personnel;
	private String pass_personnel;
	private String fonction;
	

	    public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


		@Override
	public String toString() {
		return "Personnels [id_personnel=" + id_personnel + ", nom_personnel=" + nom_personnel + ", prenom_personnel="
				+ prenom_personnel + ", email_personnel=" + email_personnel + ", login_personnel=" + login_personnel
				+ ", pass_personnel=" + pass_personnel + ", fonction=" + fonction + "]";
	}

		public int getId_personnel() {
			return id_personnel;
		}
		
		public void setId_personnel(int id_personnel) {
			this.id_personnel = id_personnel;
		}
		
		public String getNom_personnel() {
			return nom_personnel;
		}
		
		public void setNom_personnel(String nom_personnel) {
			this.nom_personnel = nom_personnel;
		}
		
		public String getPrenom_personnel() {
			return prenom_personnel;
		}
		
		public void setPrenom_personnel(String prenom_personnel) {
			this.prenom_personnel = prenom_personnel;
		}
		
		public String getEmail_personnel() {
			return email_personnel;
		}
		
		public void setEmail_personnel(String email_personnel) {
			this.email_personnel = email_personnel;
		}
		
		public String getLogin_personnel() {
			return login_personnel;
		}
		
		public void setLogin_personnel(String login_personnel) {
			this.login_personnel = login_personnel;
		}
		public String getPass_personnel() {
			return pass_personnel;
		}

		public void setPass_personnel(String pass_personnel) {
			this.pass_personnel = pass_personnel;
		}
		}




		/*public int getid() {
			return id_personnel;
		}
		public void setNum_cin(int num_cin, int id) {
			this.id = id;
		}
		public String getMatricule() {
			return matricule;
		}
		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}
		public int getTel() {
			return tel;
		}
		public void setTel(int tel) {
			this.tel = tel;
		}
	    
		public void reserver() {}*/
		
	    
	    

	   


