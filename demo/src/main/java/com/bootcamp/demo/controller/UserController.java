package com.bootcamp.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.user.User;
import com.bootcamp.demo.user.UserService;

@RestController
@RequestMapping(value = "/api/v2")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/{id}")
	public Optional<User> findById(@PathVariable("id") Long id) {
        return userServ.findById((long) 1);
    }
	
	@GetMapping("/users")
	public List<User> findAll() {
        return userServ.findAll();
    }
	
	@PostMapping("/insert")
	public User guardar(@RequestBody User usuario) {
	    return userServ.save(usuario);
	}
	
	@PutMapping("/update/{id}")
	public User actualizar(@PathVariable("id") Long id, @RequestBody User usuario) {
	    usuario.setId(id);
	    return userServ.update(usuario);
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminar(@PathVariable("id") Long id) {
	    userServ.delete(id);
	}

}
