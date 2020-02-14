package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Type {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		    public int id_type ;
		    public String nom_type;
			public int getId() {
				return id_type;
			}
			public void setId(int id) {
				this.id_type = id;
			}
			public String getNom_type() {
				return nom_type;
			}
			public void setNom_type(String nom_type) {
				this.nom_type = nom_type;
			}
			@Override
			public String toString() {
				return "Type [id=" + id_type + ", nom_type=" + nom_type + "]";
			}
		    
			
		    

@OneToMany(mappedBy="t")
private Set<Questions>Questions =new 	HashSet<Questions>();
		    
		   

}
