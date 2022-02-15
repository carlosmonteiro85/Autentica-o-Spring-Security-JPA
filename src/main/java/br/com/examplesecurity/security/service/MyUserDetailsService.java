package br.com.examplesecurity.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.examplesecurity.security.model.User;
import br.com.examplesecurity.security.repositoy.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<User> user = repository.findByUserName(username); // busca o usuario pela cheve unica seja email ou user name
		 user.orElseThrow(() -> new UsernameNotFoundException("Não entrado:" + username));
		 return user.map(MyUserDetails::new).get();
	}

}
