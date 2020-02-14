package com.example.demo.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class User implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   
	
	private int id_User ;
	private String nom_User;
	private String prenom_User;
	private String email_User;
	private int telephon;
	private int Admin=0;
	public int getAdmin() {
		return Admin;
	}

	public void setAdmin(int admin) {
		Admin = admin;
	}

	private String login_User;
	private String pass_User;
	
	

	 

		
	
		@Override
	public String toString() {
		return "User [id_User=" + id_User + ", nom_User=" + nom_User + ", prenom_User=" + prenom_User + ", email_User="
				+ email_User + ", telephon=" + telephon + ", login_User=" + login_User + ", pass_User=" + pass_User
				+ ", u=" + u + "]";
	}

		public int getId_User() {
			return id_User;
		}
		
		public void setId_User(int id_User) {
			this.id_User = id_User;
		}
		
		public String getNom_User() {
			return nom_User;
		}
		
		public void setNom_User(String nom_User) {
			this.nom_User = nom_User;
		}
		
		public String getPrenom_User() {
			return prenom_User;
		}
		
		public void setPrenom_User(String prenom_User) {
			this.prenom_User = prenom_User;
		}
		
		public String getEmail_User() {
			return email_User;
		}
		
		public void setEmail_User(String email_User) {
			this.email_User = email_User;
		}
		
		public String getLogin_User() {
			return login_User;
		}
		
		public void setLogin_User(String login_User) {
			this.login_User = login_User;
		}
		public String getPass_User() {
			return pass_User;
		}

		public void setPass_User(String pass_User) {
			this.pass_User = pass_User;
		}
		
		public int getTelephon() {
			return telephon;
		}

		public void setTelephon(int telephon) {
			this.telephon = telephon;
		}

		@ManyToOne
		@JoinColumn(name="id_fonction")
	    private Fonction u;







		public Fonction getU() {
			return u;
		}

		public void setU(Fonction u) {
			this.u = u;
		}
		

		





		


}




		/*public int getid() {
			return id_User;
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
		
	    
	    

	   


