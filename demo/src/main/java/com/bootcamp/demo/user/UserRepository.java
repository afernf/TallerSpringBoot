package com.bootcamp.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	public Optional<User> findById(Long id);
	
	public List<User> findAll();
	
	public User save(User usuario);
	
	public void deleteById(Long id);
	
	public User saveAndFlush(User usuario);

}
