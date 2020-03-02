package com.example.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Questionnaire implements Serializable{
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    public int id_questionnaire ;
	private String date;
	private String titre;
	
	
	@Override
	public String toString() {
		return "Questionnaire [id_questionnaire=" + id_questionnaire + ", date=" + date + ", titre=" + titre + ", User="
				+ User + ", Questions=" + Questions + "]";
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Set<User> getUser() {
		return User;
	}
	public void setUser(Set<User> user) {
		User = user;
	}
	public Set<Questions> getQuestions() {
		return Questions;
	}
	public void setQuestions(Set<Questions> questions) {
		Questions = questions;
	}
	public int getId_questionnaire() {
		return id_questionnaire;
	}
	public void setId_questionnaire(int id_questionnaire) {
		this.id_questionnaire = id_questionnaire;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public  void addQues(Questions Ques) {Questions.add(Ques);}
	
	@ManyToMany(mappedBy="Questionnaire")

	private Set <User>User;
	
	
	@ManyToMany(mappedBy="Questionnaire")
	private Set <Questions>Questions;
		

}
