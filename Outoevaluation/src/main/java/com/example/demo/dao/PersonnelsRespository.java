package com.example.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.Personnels;

public interface PersonnelsRespository extends JpaRepository<Personnels, Integer>{

//	Optional<Personnels> findById(Long id_personnel);

}
