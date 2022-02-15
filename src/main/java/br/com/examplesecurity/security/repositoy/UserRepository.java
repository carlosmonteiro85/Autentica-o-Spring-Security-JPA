package br.com.examplesecurity.security.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.examplesecurity.security.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.userName = :userName")
	public Optional<User> findByUserName(String userName);
}
