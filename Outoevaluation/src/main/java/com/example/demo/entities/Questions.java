package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity


	
public class Questions implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    public int id_question ;
	
	  public String libelle;
	
	  public Set<Questionnaire> getQuestionnaire() {
		return Questionnaire;
	}

	public void setQuestionnaire(Set<Questionnaire> questionnaire) {
		Questionnaire = questionnaire;
	}
	private Date date;
/*	@Temporal(DATE)
	@DateTimeFormat (pattern="dd-MMM-YYYY")
	
*/	

		@Override
	public String toString() {
		return "Questions [id_question=" + id_question + ", libelle=" + libelle + ", date=" + date + ", c=" + c + ", t="
				+ t + "]";
	}

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

		public Categorie getC() {
			return c;
		}

		public void setC(Categorie c) {
			this.c = c;
		}

		public Type getT() {
			return t;
		}

		public void setT(Type t) {
			this.t = t;
		}
		@ManyToMany(mappedBy="Questionss")
		private Set<Questionnaire> Questionnaire;

		@ManyToOne
		@JoinColumn(name="id_categorie")
	    private Categorie c;
		
		@ManyToOne
		@JoinColumn(name="id_type")
	    private Type t;
		
		
		

}
