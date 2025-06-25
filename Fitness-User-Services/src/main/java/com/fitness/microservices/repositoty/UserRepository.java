package com.fitness.microservices.repositoty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fitness.microservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	Optional<User> findByEmail(String email);
	
	 // boolean existsByEmail(String email);
	
	 @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
     boolean existsByEmail(@Param("email") String email);
	 
	 @Modifying
	 @Transactional
	 @Query("DELETE FROM User u WHERE u.email = :email")
	 void deleteByEmail(@Param("email") String email);

}
