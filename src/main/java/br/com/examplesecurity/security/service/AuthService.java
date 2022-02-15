package br.com.examplesecurity.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.examplesecurity.security.dto.UserDTO;
import br.com.examplesecurity.security.repositoy.UserRepository;

@Service
public class AuthService {

	@Autowired
	UserRepository repository;
	
	/**
	 * Metodo obtem o usuário logado na sessão.
	 * */
	public UserDTO getUserAuth() {
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDTO userDTO;

		if (principal instanceof UserDetails) {
			userDTO = new UserDTO(principal);
			return userDTO;
		}
		return new UserDTO();
	}
}
