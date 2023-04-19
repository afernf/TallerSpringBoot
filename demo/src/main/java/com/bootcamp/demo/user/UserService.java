package com.bootcamp.demo.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
	
	public Optional<User> findById(Long id);
	
	public List<User> findAll();
	
	public User update(User usuario);

    public void delete(Long id);
    
    public User save(User usuario);

}
