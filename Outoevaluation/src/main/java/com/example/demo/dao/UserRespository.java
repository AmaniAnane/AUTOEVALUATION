package com.example.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entities.User;

public interface UserRespository extends JpaRepository<User, Integer>{

//	Optional<Users> findById(Long id_User);

}
