package com.example.demo.entities;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity


	
public class Questions{@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    public int id_question ;
	    public String libelle;
	    public  Date date;
		public int getId_question() {
			return id_question;
		}
		public void setId_question(int id_question) {
			this.id_question = id_question;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
		@Override
		public String toString() {
			return "Questions [id_question=" + id_question + ", libelle=" + libelle + ", date=" + date + "]";
		}
		@ManyToOne
		@JoinColumn(name="id_categorie")
	    private Categorie c;
		
		@ManyToOne
		@JoinColumn(name="id_type")
	    private Type t;

}
