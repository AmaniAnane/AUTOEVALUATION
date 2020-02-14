package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Categorie  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    public int id_categorie ;
	    public String nom_categorie;
		
	    
	    @Override
		public String toString() {
			return "Categorie [id_categorie=" + id_categorie + ", nom_categorie=" + nom_categorie + "]";
		}


		public int getId_categorie() {
			return id_categorie;
		}


		public void setId_categorie(int id_categorie) {
			this.id_categorie = id_categorie;
		}


	    

public String getNom_categorie() {
			return nom_categorie;
		}


		public void setNom_categorie(String nom_categorie) {
			this.nom_categorie = nom_categorie;
		}




@OneToMany(mappedBy="c")
private Set<Questions>Questions =new 	HashSet<Questions>();
		
	
}

