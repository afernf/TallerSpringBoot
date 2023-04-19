package com.bootcamp.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UserImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Optional<User> findById(Long id) {
		return userRepo.findById(id);
	}
	
	@Override
	public List<User> findAll(){
		return userRepo.findAll();
	}

	@Override
	public User update(User usuario) {
		// TODO Auto-generated method stub
		return userRepo.saveAndFlush(usuario);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
		
	}

	@Override
	public User save(User usuario) {
		// TODO Auto-generated method stub
		if(usuario.getName().isEmpty() || usuario.getName() == null) {
			throw new IllegalArgumentException("El nombre no debe de estar vacio");
		}
		if(usuario.getBirthDate().equals(null) || usuario.getBirthDate() == null) {
			throw new IllegalArgumentException("La fecha de nacimineto no debe de estar vacia");
		}
		return userRepo.save(usuario);
	}
	

}
